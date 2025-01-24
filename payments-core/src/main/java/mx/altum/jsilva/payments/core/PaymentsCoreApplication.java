package mx.altum.jsilva.payments.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de arranque del core de payments
 */
@SpringBootApplication(scanBasePackages = "mx.altum.jsilva.payments")
public class PaymentsCoreApplication {

	/**
	 * Funci\u00F3n de arranque main, inicializa todos los servicios de spring boot
	 * @param args Argumentos arranque, en este pueden venir variables de entorno
	 */
	public static void main(String[] args) {
		SpringApplication.run(PaymentsCoreApplication.class, args);
	}

}
