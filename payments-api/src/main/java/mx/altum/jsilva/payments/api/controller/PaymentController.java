package mx.altum.jsilva.payments.api.controller;

import mx.altum.jsilva.payments.api.model.PaymentReq;
import mx.altum.jsilva.payments.data.model.Payment;
import mx.altum.jsilva.payments.data.model.PaymentStatus;
import mx.altum.jsilva.payments.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador Altas y Cambios de Pagos
 */
@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    /**
     *
     * @return Listado completo de pagos
     */
    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.getAll();
    }

    /**
     *
     * @param id Identificador del pago
     * @return Objeto del pago correspondiente a ese Identificador.
     */
    @GetMapping("/find/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.findById(id);
        return ResponseEntity.ok(payment);
    }

    /**
     *
     * @return Listado de estados disponibles para actualizarlo
     */
    @GetMapping("/list/status")
    public ResponseEntity<PaymentStatus[]> getAllPaymentStatus() {
        PaymentStatus[] statuses = PaymentStatus.values();
        return ResponseEntity.ok(statuses);
    }

    /**
     * M\u00E9todo de registro de pago
     * @param payment Objeto de pago
     * @return Mensaje del servidor para saber si el registro se concreto
     */
    @PostMapping
    public ResponseEntity<String> register(@RequestBody Payment payment) {
        paymentService.save(payment);
        return ResponseEntity.ok("Pago registrado con \u00E9xito");
    }

    /**
     *
     * @param id Identificador \u00FAnico del pago
     * @param paymentReq Objeto que contiene el estatus nuevo del pago y alg\u00FAn comentario que se dese agregar
     * @return Mensaje del servidor si el cambio se realiz\u00F3 o no.
     */
    @PutMapping("{id}")
    public ResponseEntity<String> update(@PathVariable("id") Long id, @RequestBody PaymentReq paymentReq) {
        switch (paymentReq.getStatus()) {
            case COMPLETED -> paymentService.complete(id, paymentReq.getComments());
            case FAILED -> paymentService.failed(id, paymentReq.getComments());
            case REJECTED -> paymentService.rejected(id, paymentReq.getComments());
            default -> paymentService.failed(id, paymentReq.getComments());
        }
        return ResponseEntity.ok("La solicitud de actualizaci\u00F3n ha sido enviada");
    }

}
