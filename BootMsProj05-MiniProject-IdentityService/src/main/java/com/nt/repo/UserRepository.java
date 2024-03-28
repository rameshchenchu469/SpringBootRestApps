package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.nt.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

	UserDetails findUserByUserName(String username);

}
