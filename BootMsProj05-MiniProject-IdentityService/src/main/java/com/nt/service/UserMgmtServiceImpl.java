package com.nt.service;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nt.dto.UserDTO;
import com.nt.entity.UserEntity;
import com.nt.repo.UserRepository;
import com.nt.utility.UserMapper;

@Service
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
