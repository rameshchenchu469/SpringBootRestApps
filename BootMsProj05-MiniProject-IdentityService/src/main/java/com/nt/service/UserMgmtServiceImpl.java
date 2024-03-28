package com.nt.service;

import org.mapstruct.ap.internal.model.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.nt.dto.UserDTO;
import com.nt.entity.UserEntity;
import com.nt.repo.UserRepository;
import com.nt.utility.UserMapper;

public class UserMgmtServiceImpl implements IUserMgmtService  {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Override
	public UserDTO addUser(UserDTO user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		UserEntity userEntity=UserMapper.INSTANCE.dtoToEntity(user);
		
		userEntity=userRepo.save(userEntity);
		
		return UserMapper.INSTANCE.entityToDto(userEntity);

	}

}
