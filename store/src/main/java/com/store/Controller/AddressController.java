package com.store.controller;

import com.store.entity.Address;
import com.store.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/address")
public class AddressController {
    @Autowired
    private AddressRepository addressRepository;

    @RequestMapping(value = "/addAddress", method = RequestMethod.POST)
    public Address addNewAddress (@RequestBody Address address) {
        return addressRepository.save(address);
    }

    @RequestMapping(value = "/allAddress", method = RequestMethod.GET)
    public Iterable<Address> getAllAddress() {
        return addressRepository.findAll();
    }

    @RequestMapping(value = "/updateAddress/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Address> updateAddress(@PathVariable("id") int id,
                                                 @RequestBody Address address) {
        return addressRepository.findById(id)
                .map(record -> {
                    record.setCountry(address.getCountry());
                    record.setCity(address.getCity());
                    record.setStreet(address.getStreet());
                    record.setHouse(address.getHouse());
                    record.setApartment(address.getApartment());

                    Address updated = addressRepository.save(address);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(value = "/deleteAddress/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAddress(@PathVariable("id") int id) {
        return addressRepository.findById(id)
                .map(record -> {
                    addressRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
