package com.store.controller;

import com.store.entity.Order;
import com.store.entity.OrderForm;
import com.store.entity.Product;
import com.store.repository.OrderRepository;
import com.store.service.AddressService;
import com.store.service.PaymentService;
import com.store.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/order")
public class OrderController {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    StatusService statusService;
    @Autowired
    AddressService addressService;
    @Autowired
    PaymentService paymentService;

    @RequestMapping(value = "/allOrder", method = RequestMethod.GET)
    public Iterable<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    @RequestMapping(value = "/addOrder", method = RequestMethod.POST)
    public Order addNewOrder (@RequestBody OrderForm form ) {
        Order order = new Order();
        order.setStatus(statusService.findById(form.getStatus()));
        order.setAddress(addressService.findById(form.getAddress()));
        order.setPayment(paymentService.findById(form.getPayment()));
        order.setPrice(form.getPrice());
        return orderRepository.save(order);
    }

    @RequestMapping(value = "/deleteProduct/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteProduct(@PathVariable("id") int id) {
        return orderRepository.findById(id)
                .map(record -> {
                    orderRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

}
