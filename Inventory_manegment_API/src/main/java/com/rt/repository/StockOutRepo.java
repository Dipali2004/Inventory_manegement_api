package com.rt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rt.entity.StockOut;
@Repository
public interface StockOutRepo extends JpaRepository<StockOut, Integer>{

	
}
