package com.store.controller;

import com.store.entity.Status;
import com.store.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/status")
public class StatusController {
    @Autowired
    private StatusRepository statusRepository;

    @RequestMapping(value = "/allStatus", method = RequestMethod.GET)
    public Iterable<Status> getAllStatus() {
        return statusRepository.findAll();
    }

    @RequestMapping(value = "/addStatus", method = RequestMethod.POST)
    public Status addNewStatus (@RequestBody Status status) {
        return statusRepository.save(status);
    }

    @RequestMapping(value = "/updateStatus/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Status> updateStatus(@PathVariable("id") int id,
                                                 @RequestBody Status status) {
        return statusRepository.findById(id)
                .map(record -> {
                    record.setName(status.getName());

                    Status updated = statusRepository.save(status);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }
}
