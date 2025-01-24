package mx.altum.jsilva.payments.core.service;

import mx.altum.jsilva.payments.data.model.Payment;
import mx.altum.jsilva.payments.data.model.PaymentHistory;
import mx.altum.jsilva.payments.data.model.PaymentStatus;
import mx.altum.jsilva.payments.data.repository.PaymentHistoryRepository;
import mx.altum.jsilva.payments.data.repository.PaymentRepository;
import mx.altum.jsilva.payments.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementaci&oacute;n del servicio PaymentService, que se encarga de procesar todos aquellos
 * pagos que se hayan
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentHistoryRepository paymentHistoryRepository;

    @Override
    public void save(Payment payment) {

    }

    @Override
    public void complete(Long paymentId, String comments) {
        Payment payment = paymentRepository.findById(paymentId).orElseThrow();
        PaymentHistory paymentHistory = PaymentHistory
                .builder()
                .paymentId(paymentId)
                .oldPaymentStatus(payment.getStatus())
                .status(PaymentStatus.COMPLETED)
                .comments(comments)
                .build();
        payment.setStatus(PaymentStatus.COMPLETED);
        paymentRepository.save(payment);
        paymentHistoryRepository.save(paymentHistory);
    }

    @Override
    public void failed(Long paymentId, String comments) {
        Payment payment = paymentRepository.findById(paymentId).orElseThrow();
        PaymentHistory paymentHistory = PaymentHistory
                .builder()
                .paymentId(paymentId)
                .oldPaymentStatus(payment.getStatus())
                .status(PaymentStatus.FAILED)
                .comments(comments)
                .build();
        payment.setStatus(PaymentStatus.FAILED);
        paymentRepository.save(payment);
        paymentHistoryRepository.save(paymentHistory);
    }

    @Override
    public void rejected(Long paymentId, String comments) {
        Payment payment = paymentRepository.findById(paymentId).orElseThrow();
        PaymentHistory paymentHistory = PaymentHistory
                .builder()
                .paymentId(paymentId)
                .oldPaymentStatus(payment.getStatus())
                .status(PaymentStatus.REJECTED)
                .comments(comments)
                .build();
        payment.setStatus(PaymentStatus.REJECTED);
        paymentRepository.save(payment);
        paymentHistoryRepository.save(paymentHistory);
    }

    @Override
    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment findById(Long id) {
        return paymentRepository.findById(id).orElseThrow();
    }
}
