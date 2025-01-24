package mx.altum.jsilva.payments.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Clase de entidad historica de pagos
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payments_history")
public class PaymentHistory {

    /**
     * Identificador unico de movimiento historico de pagos
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    /**
     * Propiedad del movimiento payment modificado
     */
    @Column(nullable = false, name = "payment_id")
    protected Long paymentId;

    /**
     * Propiedad de estado del pago anterior
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = true, name = "old_payment_status", length = 20)
    protected PaymentStatus oldPaymentStatus;

    /**
     * Propiedad del nuevo estado del pago
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    protected PaymentStatus status;

    /**
     * Comentarios de la transacci&oacute;n
     */
    @Column(nullable = true, length = 100)
    protected String comments;

    /**
     * Propiedad de la fecha modificaci&oacute;n
     */
    @Column(nullable = false, name = "modified_at")
    protected LocalDateTime modifiedAt;

    /**
     * M&eacute;todo para inicializar la fecha de modificaci&oacute;n en la bitacora
     */
    @PrePersist
    protected void onCreated() {
        modifiedAt = LocalDateTime.now();
    }
}
