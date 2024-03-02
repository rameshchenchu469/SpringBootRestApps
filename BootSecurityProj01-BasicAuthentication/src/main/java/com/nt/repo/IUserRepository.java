package com.nt.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


import com.nt.entity.UserEntity;

public interface IUserRepository extends CrudRepository<UserEntity, Integer> {

public Optional<UserEntity> findByUsername(String username);

}
