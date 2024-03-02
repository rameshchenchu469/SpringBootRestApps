package com.nt.repo;

import org.springframework.data.repository.CrudRepository;

import com.nt.entity.Product;

public interface IProductRepository extends CrudRepository<Product, Integer> {

}
