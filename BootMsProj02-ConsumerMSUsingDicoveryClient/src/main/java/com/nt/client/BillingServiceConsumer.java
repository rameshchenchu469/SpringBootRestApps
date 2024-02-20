package com.nt.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BillingServiceConsumer {

	@Autowired
	private DiscoveryClient client;
	
	public String getBillingInfo() {
	
	List<ServiceInstance> listSI=client.getInstances("billing-service");
	ServiceInstance si=listSI.get(0);
	String url=si.getUri()+"/billing/info";
	
	RestTemplate template=new RestTemplate();
	
String resp=template.getForObject(url,String.class);
return resp;
	
}
}
