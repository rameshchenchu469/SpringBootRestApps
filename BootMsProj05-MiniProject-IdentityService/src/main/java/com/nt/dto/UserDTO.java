package com.nt.dto;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

	
	private int userId;
	@NotBlank(message="username mandatory")
	private String username;
	@NotBlank(message="password  mandatory")
	private String password;
	@NotBlank(message="email mandatory")
	private String email;
	@NotBlank(message="created date mandatory")
	private LocalDateTime creted_at;
	@NotBlank(message="user roles mandatory")
	private List<RoleDTO> roles;
}
