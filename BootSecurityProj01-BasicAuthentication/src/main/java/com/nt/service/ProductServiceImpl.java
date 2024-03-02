package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nt.entity.Product;
import com.nt.entity.UserEntity;
import com.nt.handler.ProductNotFoundException;
import com.nt.repo.IProductRepository;
import com.nt.repo.IUserRepository;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IUserRepository userRepo;
	
	@Autowired
	private IProductRepository productRepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public String registerProduct(Product p) {
		
		productRepo.save(p);
		return "product registered successfully with"+" "+ p.getPId() +"id value";
	}
	@Override
	public Product fetchProductById(Integer id) throws ProductNotFoundException{
		
	return	productRepo.findById(id).orElseThrow(()->new ProductNotFoundException(id+"product not found"));
		
		
	}
	@Override
	public Iterable<Product> getAll() {
		Iterable<Product> productList=productRepo.findAll();
		productList.forEach(product->System.out.println(product));
		//return  productList.sort((p1,p2)->p1.getPid().compareTo(p2.getPid()));
		return productList;
	}
	@Override
	public String addUser(UserEntity user) {
		
		 user.setPassword(encoder.encode(user.getPassword()));
		 userRepo.save(user);
		 return "user added successfully";
	}

	
}
