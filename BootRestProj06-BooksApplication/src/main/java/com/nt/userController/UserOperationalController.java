package com.nt.userController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nt.dto.AuthRequest;
import com.nt.jwt.JwtService;
import com.nt.userEntity.UserEntity;
import com.nt.userService.IUserMgmtService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserOperationalController {
	
	@Autowired
	private IUserMgmtService userService;
	
	@Autowired
    private AuthenticationManager authManager;
	
		@Autowired
	    private JwtService jwtService;
		
	
		
	@PostMapping("/register")
	public  ResponseEntity<String> saveUser(@RequestBody UserEntity userEntity){
		String resultMsg = userService.registerUser(userEntity);
		return new ResponseEntity<String>(resultMsg,HttpStatus.CREATED);
	}
	
	
	@PostMapping("/login")
	public  String authnticateUser(@RequestBody AuthRequest auth) {
		Authentication authentication=authManager.authenticate(new UsernamePasswordAuthenticationToken(auth.getUsername(), auth.getPassword()));
	       if(authentication.isAuthenticated()) {
			return jwtService.generateToken(auth.getUsername());
		}
	       else {
	    	   throw new UsernameNotFoundException("invalid user request");
	       }
			
		}
	}
	

