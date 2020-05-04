package com.store.service;

import com.store.entity.Payment;
import com.store.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;
    public Payment findById(Integer id){
        return paymentRepository.findById(id).orElse(null);
    }
}
