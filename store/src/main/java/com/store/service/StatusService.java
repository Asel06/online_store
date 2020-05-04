package com.store.service;

import com.store.entity.Status;
import com.store.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusService {
    @Autowired
    StatusRepository statusRepository;
    public Status findById(Integer id){
        return statusRepository.findById(id).orElse(null);
    }
}
