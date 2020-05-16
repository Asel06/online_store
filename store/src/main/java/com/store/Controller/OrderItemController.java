package com.store.controller;

import com.store.entity.OrderItem;
import com.store.model.OrderItemForm;
import com.store.repository.OrderItemRepository;
import com.store.service.OrderService;
import com.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/orderitem")
public class OrderItemController {
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/allOrderItem", method = RequestMethod.GET)
    public Iterable<OrderItem> getAllOrderItem() {
        return orderItemRepository.findAll();
    }

    @RequestMapping(value = "/addOrderItem", method = RequestMethod.POST)
    public OrderItem addNewOrderItem (@RequestBody OrderItemForm form ) {
        OrderItem orderItem = new OrderItem();
        orderItem.setOrder(orderService.findById(form.getOrderId()));
        orderItem.setProduct(productService.findById(form.getProduct()));
        orderItem.setQuantity(form.getQuantity());
        orderItem.setPrice(form.getPrice());
        return orderItemRepository.save(orderItem);
    }

    @RequestMapping(value = "/deleteOrderItem/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteOrderItem(@PathVariable("id") int id) {
        return orderItemRepository.findById(id)
                .map(record -> {
                    orderItemRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
