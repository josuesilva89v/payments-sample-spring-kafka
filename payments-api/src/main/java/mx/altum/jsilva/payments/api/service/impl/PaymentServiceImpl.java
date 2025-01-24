package mx.altum.jsilva.payments.api.service.impl;

import mx.altum.jsilva.payments.api.constants.KafkaTopicsConstants;
import mx.altum.jsilva.payments.data.model.Payment;
import mx.altum.jsilva.payments.data.model.PaymentHistory;
import mx.altum.jsilva.payments.data.repository.PaymentHistoryRepository;
import mx.altum.jsilva.payments.data.repository.PaymentRepository;
import mx.altum.jsilva.payments.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Implementaci&oacute;n del servicio payment en el API
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    private static final Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentHistoryRepository paymentHistoryRepository;

    @Override
    public void save(Payment payment) {
        logger.info("Almacenando info de pago");
        paymentRepository.save(payment);
        PaymentHistory paymentHistory = PaymentHistory
                                            .builder()
                                            .paymentId(payment.getId())
                                            .status(payment.getStatus())
                                            .build();
        logger.info("Generando registro en la bitacora");
        paymentHistoryRepository.save(paymentHistory);
        logger.info("Info de pago almacenado");
    }

    @Override
    public void complete(Long paymentId, String comments) {
        kafkaTemplate.send(KafkaTopicsConstants.COMPLETED, String.join(",", Arrays.asList(paymentId.toString(), comments)));
    }

    @Override
    public void failed(Long paymentId, String comments) {
        kafkaTemplate.send(KafkaTopicsConstants.FAILED, String.join(",", Arrays.asList(paymentId.toString(), comments)));
    }

    @Override
    public void rejected(Long paymentId, String comments) {
        kafkaTemplate.send(KafkaTopicsConstants.REJECTED, String.join(",", Arrays.asList(paymentId.toString(), comments)));
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
