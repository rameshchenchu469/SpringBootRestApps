package com.nt.model;

import lombok.Data;

@Data
public class Company {

	private String name;
	private String addrs;
	private String type;
	private Integer size;
	@Override
	public String toString() {
		return "Company [name=" + name + ", addrs=" + addrs + ", type=" + type + ", size=" + size + "]";
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddrs() {
		return addrs;
	}

	public void setAddrs(String addrs) {
		this.addrs = addrs;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	
	public Company(String name, String addrs, String type, Integer size) {
		super();
		this.name = name;
		this.addrs = addrs;
		this.type = type;
		this.size = size;
	}
}
