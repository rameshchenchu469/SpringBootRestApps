package com.nt.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Company;
import com.nt.model.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeOperationsController {

	@GetMapping("/data")
	public ResponseEntity<Employee> showData()
	{
		Employee emp=new Employee(1001,"suresh",53463.0f,
				                    new String[]{"red","green","blue"},
								    List.of("ssc","inter","b.tech"),
									Set.of(835377377L,764767647L),
									Map.of("aadhar",2645764476L,"panNo",346575565L),
									new Company("samsung","hyd","electronic",4000));
		
		
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<Employee> registerEmployee(@RequestBody Employee emp)
	{
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
	}
	
}
