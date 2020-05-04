package com.store.service;

import com.store.entity.Address;
import com.store.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;
    public Address findById(Integer id){
        return addressRepository.findById(id).orElse(null);
    }
}
