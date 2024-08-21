package com.nt.userRepo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.nt.userEntity.UserEntity;

public interface IUserRepository extends CrudRepository<UserEntity,Integer>{

	Optional<UserEntity> findByUsername(String username);

}
