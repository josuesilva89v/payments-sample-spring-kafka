package mx.altum.jsilva.payments.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase de arranque de spring framework para el api de pagos
 */
@SpringBootApplication(scanBasePackages = "mx.altum.jsilva.payments")
public class PaymentsApiApplication {

	/**
	 * Funci\u00F3n de arranque main, inicializa todos los serviciso en el API
	 * @param args argumentos de arranque, estos
	 */
	public static void main(String[] args) {
		SpringApplication.run(PaymentsApiApplication.class, args);
	}

}
