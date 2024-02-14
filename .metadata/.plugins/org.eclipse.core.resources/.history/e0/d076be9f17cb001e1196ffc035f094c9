package com.nt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	
private Integer cno;
private String cname;
private Float billAmt;

public Integer getCno() {
	return cno;
}
public void setCno(Integer cno) {
	this.cno = cno;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public Float getBillAmt() {
	return billAmt;
}
public void setBillAmt(Float billAmt) {
	this.billAmt = billAmt;
}

public Customer(Integer cno, String cname, Float billAmt) {
	super();
	this.cno = cno;
	this.cname = cname;
	this.billAmt = billAmt;
}
@Override
public String toString() {
	return "Customer [cno=" + cno + ", cname=" + cname + ", billAmt=" + billAmt + "]";
}

}
