package com.nt.repo1;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity1.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{

}
