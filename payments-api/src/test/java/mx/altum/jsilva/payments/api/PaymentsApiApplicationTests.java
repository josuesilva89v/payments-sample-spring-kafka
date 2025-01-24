package mx.altum.jsilva.payments.api;

import mx.altum.jsilva.payments.data.model.Payment;
import mx.altum.jsilva.payments.data.model.PaymentStatus;
import mx.altum.jsilva.payments.data.repository.PaymentRepository;
import mx.altum.jsilva.payments.service.PaymentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PaymentsApiApplicationTests {

	private static final Logger logger = LoggerFactory.getLogger(PaymentsApiApplicationTests.class);

	@Autowired
	private PaymentService paymentService;

	@Test
	void insertPayment() {
		logger.info("Prueba de nuevo registro de pago");
		Payment payment = Payment.builder()
				.payer("TEST PAGANTE")
				.payee("TEST BENEFICIARIO")
				.concept("Prueba de registro")
				.status(PaymentStatus.PENDING)
				.quantify(11)
				.amount(150d)
				.build();
		logger.info("Enviando payment al servicio");
		logger.info("Payment Info: {}", payment.toString());
		paymentService.save(payment);
	}

	@Test
	void confirmedPaymentTopic() {
		paymentService.complete(10L, "test");
	}

	@Test
	void failedPaymentTopic() {
		paymentService.failed(8L, "test");
	}

	@Test
	void rejectedPaymentTopic() {
		paymentService.rejected(9L, "test");
	}

}
