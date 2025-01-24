package mx.altum.jsilva.payments.api.constants;


/**
 * Constantes de nombre de los t&oacute;picos de las transacciones
 */
public class KafkaTopicsConstants {
    /**
     * Topico para procesar pagos completados
     */
    public static final String COMPLETED = "completed-payment-topic";
    /**
     * Topico para procesar pagos fallidos
     */
    public static final String FAILED = "failed-payment-topic";
    /**
     * Topico para procesar pagos rechazados
     */
    public static final String REJECTED = "rejected-payment-topic";
}
