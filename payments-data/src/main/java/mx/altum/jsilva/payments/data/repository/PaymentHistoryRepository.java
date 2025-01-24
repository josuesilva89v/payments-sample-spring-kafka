package mx.altum.jsilva.payments.data.repository;

import mx.altum.jsilva.payments.data.model.PaymentHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para procesar la bitacora de pagos
 */
@Repository
public interface PaymentHistoryRepository extends JpaRepository<PaymentHistory, Long> {
}
