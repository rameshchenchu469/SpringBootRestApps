package com.nt.userService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nt.userEntity.UserEntity;
import com.nt.userRepo.IUserRepository;

@Service
public class UserMgmtServiceImpl implements IUserMgmtService {

	@Autowired
	private IUserRepository userRepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public String registerUser(UserEntity userEntity) {
		userEntity.setPassword(encoder.encode(userEntity.getPassword()));
		int id = userRepo.save(userEntity).getId();
		return "user registered successfully with id value"+id;
	}

}
