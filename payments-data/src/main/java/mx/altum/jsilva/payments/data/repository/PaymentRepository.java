package mx.altum.jsilva.payments.data.repository;

import mx.altum.jsilva.payments.data.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para procesar los pagos
 */
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
