package com.nt.service;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.nt.Entity.StudentOrder;
import com.nt.repo.StudentOrderRepo;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;



@Service
public class StudentOrderService {
	
	@Value("${razorpay.key.id}")
	private String razorPayKey;
	
	@Value("${razorpay.key.secret}")
	private String razorPaySecret;

	@Autowired
	private StudentOrderRepo studentRepo;
	
	@Autowired
	private RazorpayClient client;
	
	public StudentOrder createOrder(StudentOrder studentOrder) throws RazorpayException {
		
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("amount", studentOrder.getAmount()*100);
		jsonObject.put("currency","INR");
		jsonObject.put("email", studentOrder.getEmail());
		
		RazorpayClient client = new RazorpayClient(razorPayKey,razorPaySecret);
		
		Order razorPayOrder = client.orders.create(jsonObject);
		
		System.out.println(razorPayOrder);
		
		studentOrder.setRazorPayOrderId(razorPayOrder.get("id"));
		studentOrder.setOrderStatus(razorPayOrder.get("status"));
		
		studentRepo.save(studentOrder);
		
		return studentOrder;
	}
	
	
	public StudentOrder updateOrderStatus(Map<String,String> responsePayLoad) {
		
		String razorPayOrderId = responsePayLoad.get("razorPay_Order_Id");
		
		StudentOrder order = studentRepo.findByRazorPayOrderId(razorPayOrderId);
		
		order.setOrderStatus("PAYMENT_COMPLETED");
		
		StudentOrder updateOrder = studentRepo.save(order);

		return updateOrder;
	}
}
