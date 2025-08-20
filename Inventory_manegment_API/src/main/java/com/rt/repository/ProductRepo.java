package com.rt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rt.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

}
