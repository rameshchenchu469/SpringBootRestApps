package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.dto.AuthRequest;
import com.nt.entity.Product;
import com.nt.entity.UserEntity;
import com.nt.jwt.JwtService;
import com.nt.service.IProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
	private IProductService productService;
    
    @Autowired
    private JwtService jwtService;
    
    @Autowired
    private AuthenticationManager authManager;
    
    @PostMapping("/addUser")
    public String registerUser(@RequestBody UserEntity userEntity) {
    	return productService.addUser(userEntity);
    }
	
	@GetMapping("/welcome")
	public String welcomeMessage() {
		return "This is not a secured endpoint";
	}
	
	@GetMapping("/wish")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public String getMessage() {
		return "welcome to springboot security implementation";
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> saveProduct(@RequestBody Product product) {
		String resultMsg=productService.registerProduct(product);
		 return new ResponseEntity<String>(resultMsg,HttpStatus.CREATED);
		 
	}
	
	@GetMapping("get/{id}")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public ResponseEntity<?> getProductById(@PathVariable("id") Integer id ) {
		try {
		Product product=productService.fetchProductById(id);
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
		catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		
		@GetMapping("/getAll")
		@PreAuthorize("hasAuthority('ROLE_ADMIN')")
		public ResponseEntity<?> fetchAllProducts(){
			try {
				Iterable<Product> pList=productService.getAll();
				return new ResponseEntity<Iterable<Product>>(pList,HttpStatus.OK);
			}
			catch(Exception e) {
				e.printStackTrace();
				return new ResponseEntity<String>("problem in fetchig proucts details",HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@PostMapping("/authenticate")
		public String authenticateAndGetToken(@RequestBody AuthRequest auth)throws Exception {
	Authentication authentication=authManager.authenticate(new UsernamePasswordAuthenticationToken(auth.getUsername(), auth.getPassword()));
	       if(authentication.isAuthenticated()) {
			return jwtService.generateToken(auth.getUsername());
		}
	       else {
	    	   throw new UsernameNotFoundException("invalid user request");
	       }
			
		}
}
