package mx.altum.jsilva.payments.core.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Clase de configuraci&oacute;n para las entidades y repositorios
 */
@Configuration
@EnableJpaRepositories(basePackages = "mx.altum.jsilva.payments.data.repository")
@EntityScan(basePackages = "mx.altum.jsilva.payments.data.model")
public class JpaConfig {
}
