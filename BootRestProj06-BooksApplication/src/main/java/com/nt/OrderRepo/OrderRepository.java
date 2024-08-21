package com.nt.OrderRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.OrderEntity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {

}
