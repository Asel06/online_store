package com.store.service;

import com.store.entity.Manufactor;
import com.store.repository.ManufactorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManufactorService {
    @Autowired
    ManufactorRepository manufactorRepository;
    public Manufactor findById(Integer id){
        return manufactorRepository.findById(id).orElse(null);
    }
}
