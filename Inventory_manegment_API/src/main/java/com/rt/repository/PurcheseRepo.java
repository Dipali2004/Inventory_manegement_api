package com.rt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rt.entity.Purchase;
@Repository
public interface PurcheseRepo extends JpaRepository<Purchase, Integer>{

}
