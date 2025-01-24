package mx.altum.jsilva.payments.service;

import mx.altum.jsilva.payments.data.model.Payment;

import java.util.List;

/**
 * Servicio de Pagos, se implementara dependiendo el servicio
 */
public interface PaymentService {

    /**
     *
     * @param payment
     * M&eacute;todo para guardar la transacci&oacute;n de pago.
     */
    void save(Payment payment);

    /**
     * M&eacute;todo para confirmar el pago.
     * @param paymentId Identificador del pago.
     * @param comments Comentarios hac&iacute;a la transacci&oacute;n
     */
    void complete(Long paymentId, String comments);

    /**
     * M&eacute;todo para rechazo del pago por alg\u00FAn error o factor externo.
     * @param paymentId Identificador del pago.
     * @param comments Comentarios hac\u00EDa la transacci\u00F3n
     */
    void failed(Long paymentId, String comments);

    /**
     * M&eacute;todo para rechazar la transacci\u00F3n. Queda a criterio de las personas quienes gestionen los pagos.
     * @param paymentId Identificador del pago.
     * @param comments Comentarios hac&iacute;a la transacci\u00F3n
     */
    void rejected(Long paymentId, String comments);

    /**
     * M\u00E9todo de consulta de las tranascciones
     * @return Listado de las transacciones de pago realizadas
     */
    List<Payment> getAll();

    /**
     * M&eacute;todo de consulta de la transacci\u00F3n de pago.
     * @param id Identificador de la transacc\u00F3n de pago.
     * @return Transacci&oacute;n de Pago
     */
    Payment findById(Long id);
}
