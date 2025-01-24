package mx.altum.jsilva.payments.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


/**
 * La clase Payment es la represenaci&oacute;n de una transacci&oacute;n de pago.
 * En este se detalla el concepto, cantidad del producto, quien paga, quien recibe el pago,
 * monto, estatus y las marcas de tiempo de creaci&oacute;n y modificaci&oacute;n.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Payments")
public class  Payment {

    /**
     * Identificador \u00FAnico de la transacci\u00F3n
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    /**
     * Concepto de pago
     */
    @Column(nullable = false, length = 300)
    protected String concept;

    /**
     * Cantidad de producto
     */
    @Column(nullable = false)
    protected int quantify;

    /**
     * Nombre de la persona que realiza el pago
     */
    @Column(nullable = false, length = 100)
    protected String payer;

    /**
     * Persona beneficiaria del pago
     */
    @Column(nullable = false, length = 100)
    protected String payee;

    /**
     * Monto total de la transacci\u00F3n
     */
    @Column(nullable = false)
    public Double amount;

    /**
     * Estatus del pago
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    protected PaymentStatus status;

    /**
     * Comentarios de la transacci\u00F3n
     */
    @Column(nullable = true, length = 100)
    protected String comments;

    /**
     * Fecha de creaci\u00F3n del movimiento
     */
    @Column(nullable = false, name = "create_at")
    protected LocalDateTime createdAt;

    /**
     * Fecha de \u00FAltima modificaci\u00F3n
     */
    @Column(nullable = false, name="modified_at")
    protected LocalDateTime modifiedAt;

    /**
     * M\u00E9todo que se ejecuta al momento de la creaci\u00F3n del objeto payment
     */
    @PrePersist
    protected void onCreated() {
        createdAt = LocalDateTime.now();
        modifiedAt = createdAt;
    }

    /**
     * Metodo que actualiza la fecha de modificaci\u00F3n al momento de actualizar el objeto payment.
     */
    @PreUpdate
    protected void onUpdate() {
        modifiedAt = LocalDateTime.now();
    }
}
