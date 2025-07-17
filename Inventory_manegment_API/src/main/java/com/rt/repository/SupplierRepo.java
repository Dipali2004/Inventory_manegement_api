package com.rt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rt.entity.Supplier;

public interface SupplierRepo extends JpaRepository<Supplier, Integer> {

}
