package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.Entity.StudentOrder;

public interface StudentOrderRepo extends JpaRepository<StudentOrder,Integer>{

	StudentOrder findByRazorPayOrderId(String razorPayOrderId);
	
	

}
