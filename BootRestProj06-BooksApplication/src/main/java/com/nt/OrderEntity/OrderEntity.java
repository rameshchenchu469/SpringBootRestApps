package com.nt.OrderEntity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name="books_orders_table")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer orderId;
	private String userId;
	private String bookId;
	private List<String> orderBooks;
	private LocalDate bookingDate;
	private LocalTime bookingTime;
	private Double orderAmount;
}
