package com.nt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeOperationsController {

	@GetMapping("/get")
	public String getEmployeeDetails(@RequestParam Integer eno,@RequestParam String ename,
										@RequestParam Float sal)
	{
		return eno+" "+ename+" "+sal;
	}
}
