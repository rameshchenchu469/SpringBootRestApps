package com.nt.entity1;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserEntity {
	
	private Integer uno;
	private String uname;
	private String email;
	
	
	
	

}
