package com.store.repository;

import com.store.entity.Manufactor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufactorRepository extends JpaRepository<Manufactor, Integer> {
}
