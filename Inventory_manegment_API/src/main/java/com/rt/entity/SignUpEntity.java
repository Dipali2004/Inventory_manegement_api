package com.rt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Table(name = "signup")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SignUpEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id ;
	
	@Column(name="fullName")
	private String fullName;
	
	@Column(name="email",unique=true)
	private String email;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="password")
	private String password;
	
	@Column(name="role")
	private String role;

}
