package com.rt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rt.DTO.SupplierRespDTO;
import com.rt.entity.Supplier;

public interface SupplierRepo extends JpaRepository<Supplier, Integer> {
	
}
