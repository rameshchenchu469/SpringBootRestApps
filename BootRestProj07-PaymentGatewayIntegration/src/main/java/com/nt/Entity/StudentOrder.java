package com.nt.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="student_order")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentOrder {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer orderId;
	private String name;
	private String email;
	private String phNumber;
	private String course;
	private Integer amount;
	private String orderStatus;
	private String razorPayOrderId;

}
