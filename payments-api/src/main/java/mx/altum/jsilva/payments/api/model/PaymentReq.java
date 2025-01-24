package mx.altum.jsilva.payments.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.altum.jsilva.payments.data.model.PaymentStatus;

/**
 * Clase para recibir el estatus y comentarios para actualizar un pago
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentReq {
    /**
     * Estaus de la operaci\u00F3n
     */
    protected PaymentStatus status;
    /**
     * Comentarios hac&iacute;a la operaci&oacute;n de porque fue rechazado o cancelado
     */
    protected String comments;
}
