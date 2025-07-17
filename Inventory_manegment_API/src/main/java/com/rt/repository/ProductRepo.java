package com.rt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rt.entity.Product;
@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

	

}
