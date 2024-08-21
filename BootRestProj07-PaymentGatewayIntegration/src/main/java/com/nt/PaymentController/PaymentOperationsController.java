package com.nt.PaymentController;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nt.Entity.StudentOrder;
import com.nt.service.StudentOrderService;
import com.razorpay.RazorpayException;


@Controller
public class PaymentOperationsController {
	
	@Autowired
	private StudentOrderService orderService;

	@GetMapping("/")
	public String init() {
		return "index";
	}
	
	@PostMapping(value="/create-order",produces = "application/json")
	@ResponseBody
	public ResponseEntity<StudentOrder> createPayment(@RequestBody StudentOrder studentOrder) throws RazorpayException{
		
		StudentOrder createdOrder = orderService.createOrder(studentOrder);
		
		return new ResponseEntity<StudentOrder>(createdOrder,HttpStatus.CREATED);
	}
	
	@PostMapping("/handle-payment-callback")
	@ResponseBody
	public String handlePaymentCallback(@RequestParam Map<String,String> respPayLoad) {
		System.out.println(respPayLoad);
		orderService.updateOrderStatus(respPayLoad);
		return "success";
	}
	
}
