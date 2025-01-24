package mx.altum.jsilva.payments.data.model;

/**
 * Enum donde se enlistan los estados del Pago
 */
public enum PaymentStatus {
    /**
     * Estado de pago PENDIENTE
     */
    PENDING,
    /**
     * Estado de pago COMPLETADO
     */
    COMPLETED,
    /**
     * Estado de pago FALLIDO
     */
    FAILED,
    /**
     * Estado de pago RECHAZADO
     */
    REJECTED
}