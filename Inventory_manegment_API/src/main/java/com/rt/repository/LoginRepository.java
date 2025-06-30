package com.rt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rt.DTO.RespLoginDTO;
import com.rt.entity.SignUpEntity;

@Repository
public interface LoginRepository extends JpaRepository<SignUpEntity, Integer> {

	
	@Query("SELECT new com.rt.DTO.RespLoginDTO(u.id, u.email, u.role) FROM SignUpEntity u WHERE u.email = :email AND u.password = :password")
	RespLoginDTO findByEmailAndPassword(@Param("email") String email, @Param("password") String password);


}
