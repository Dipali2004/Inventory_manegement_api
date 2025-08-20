package com.rt.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rt.DTO.ManegerRepDTO;
import com.rt.entity.Maneger;

public interface ManegerInt extends JpaRepository<Maneger, Integer> {
	
	

}
