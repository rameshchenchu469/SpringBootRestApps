package com.nt.service;

import java.util.List;

import com.nt.entity.Product;
import com.nt.entity.UserEntity;
import com.nt.handler.ProductNotFoundException;

public interface IProductService {
	
	public String registerProduct(Product p);

	public Product fetchProductById(Integer id) throws ProductNotFoundException;
	
	public Iterable<Product> getAll();
	
	public String addUser(UserEntity user);

}
