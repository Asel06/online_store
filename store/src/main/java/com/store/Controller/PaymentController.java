package com.store.controller;


import com.store.entity.Payment;
import com.store.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/payment")
public class PaymentController {
    @Autowired
    PaymentRepository paymentRepository;

    @RequestMapping(value = "/allPayment", method = RequestMethod.GET)
    public Iterable<Payment> getAllPayment() {
        return paymentRepository.findAll();
    }

    @RequestMapping(value = "/addPayment", method = RequestMethod.POST)
    public Payment addNewPayment (@RequestBody Payment payment) {
        return paymentRepository.save(payment);
    }

    @RequestMapping(value = "/updatePayment/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Payment> updateStatus(@PathVariable("id") int id,
                                               @RequestBody Payment payment) {
        return paymentRepository.findById(id)
                .map(record -> {
                    record.setMethod(payment.getMethod());

                    Payment updated = paymentRepository.save(payment);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }
}
