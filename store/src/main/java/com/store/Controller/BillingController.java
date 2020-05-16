package com.store.controller;

import com.store.entity.Billing;
import com.store.model.BillingForm;
import com.store.repository.BillingRepository;
import com.store.service.AddressService;
import com.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/billing")
public class BillingController {
    @Autowired
    private BillingRepository billingRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private AddressService addressService;

    @RequestMapping(value = "/allBilling", method = RequestMethod.GET)
    public Iterable<Billing> getAllBilling() {
        return billingRepository.findAll();
    }

    @RequestMapping(value = "/addBilling", method = RequestMethod.POST)
    public Billing addNewBilling (@RequestBody BillingForm form ) {
        Billing billing = new Billing();
        billing.setUser(userService.findById(form.getUserId()));
        billing.setAddress(addressService.findById(form.getAddress()));
        return billingRepository.save(billing);
    }

    @RequestMapping(value = "/deleteBilling/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteBilling(@PathVariable("id") int id) {
        return billingRepository.findById(id)
                .map(record -> {
                    billingRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

}
