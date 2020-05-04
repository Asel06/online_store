package com.store.controller;

import com.store.entity.Manufactor;
import com.store.entity.Product;
import com.store.repository.ManufactorRepository;
import com.store.service.ManufactorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/manufactor")
public class ManufactorController {
    @Autowired
    ManufactorRepository manufactorRepository;
    @Autowired
    ManufactorService manufactorService;

    @RequestMapping(value = "/addManufactor", method = RequestMethod.POST)
    public Manufactor addNewManufactor (@RequestBody Manufactor manufactor ) {
        return manufactorRepository.save(manufactor);
    }

    @RequestMapping(value = "/allManufactor", method = RequestMethod.GET)
    public Iterable<Manufactor> getAllManufactor() {
        return manufactorRepository.findAll();
    }

    @RequestMapping(value = "/getManufactor/{id}", method = RequestMethod.GET)
    public Manufactor findById(@PathVariable("id") int id) {
        return manufactorService.findById(id);
    }

    @RequestMapping(value = "/deleteManufactor/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteManufactor(@PathVariable("id") int id) {
        return manufactorRepository.findById(id)
                .map(record -> {
                    manufactorRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
