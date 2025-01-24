package mx.altum.jsilva.payments.core.listener;

import mx.altum.jsilva.payments.core.constants.KafkaTopicsConstants;
import mx.altum.jsilva.payments.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Servicio donde se escuchan todos los eventos de las diferentes operaciones
 */
@Service
public class KafkaConsumerListener {

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerListener.class);

    @Value("${spring.kafka.group-id}")
    private String groupId;

    @Autowired
    private PaymentService paymentService;

    /**
     * De manera asincrona se recibe la orden de cerrar de manera completa la transacci&oacute;n
     * @param message Se recibe el mensaje de la operaci&oacute;n para procesarlo
     */
    @KafkaListener(topics = KafkaTopicsConstants.COMPLETED)
    public void completedPaymentListen(String message) {
        logger.info("Mensaje de pago completado recibido");
        Long paymentId = Long.parseLong(message.split(",")[0]);
        String comments = message.split(",")[1];
        paymentService.complete(paymentId, comments);
    }

    /**
     * De manera asincrona se recibe la orden de cambiar el estatus a fallido de
     * la transacci&oacute;n
     * @param message Se recibe el mensaje de la operaci&oacute;n para procesarlo
     */
    @KafkaListener(topics = KafkaTopicsConstants.FAILED)
    public void failededPaymentListen(String message) {
        logger.info("Mensaje de pago fallido recibido");
        Long paymentId = Long.parseLong(message.split(",")[0]);
        String comments = message.split(",")[1];
        paymentService.failed(paymentId, comments);
    }

    /**
     * De manera asincrona se recibe la orden de rechazar la transacci&oacute;n
     * @param message Se recibe el mensaje de la operaci&oacute;n para procesarlo
     */
    @KafkaListener(topics = KafkaTopicsConstants.REJECTED)
    public void rejetedPaymentListen(String message) {
        logger.info("Mensaje de pago completado recibido");
        Long paymentId = Long.parseLong(message.split(",")[0]);
        String comments = message.split(",")[1];
            paymentService.rejected( paymentId, comments);
    }
}
