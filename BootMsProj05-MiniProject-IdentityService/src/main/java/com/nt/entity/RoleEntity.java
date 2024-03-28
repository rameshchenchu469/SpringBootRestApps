package com.nt.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="ROLES_TABLE")
public class RoleEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer roleId;
private String roleName;
}
