package com.nt.entity2;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="books")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookEntity {
	
	private Integer bid;
	private String title;
	private String author;

}
