package com.rt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rt.entity.SignUpEntity;

public interface SignUp extends JpaRepository<SignUpEntity, Integer>{


}
