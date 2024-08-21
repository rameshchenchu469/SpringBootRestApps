package com.nt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="USER_INFO")
@Data
public class UserEntity   {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Long mobileNo;
	private String email;
	private String username;
	private String password;
//	public String getRoles() {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
