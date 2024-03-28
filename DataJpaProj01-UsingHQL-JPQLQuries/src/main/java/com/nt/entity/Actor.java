package com.nt.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.annotations.DynamicInsert;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name="JPA_ACTOR")
@Entity
@DynamicInsert(true)
public class Actor {

	@Id
	@SequenceGenerator(name="gen1",sequenceName="actor_sequence",initialValue=1001,allocationSize=1)
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
	@Column(name="ACTOR_ID")
	private Integer aid;
	@Column(name="ACTOR_NAME")
	private String aname;
	@Column(name="ACTOR_ROLE")
	private String role;
	@ElementCollection
	@CollectionTable(name="ACTOR_NAMES",joinColumns=@JoinColumn(name="ACTOR_NO",referencedColumnName="ACTOR_ID"))
	private List<String> nickNames;
	@ElementCollection
	@CollectionTable(name="ACTOR_NUMBERS",joinColumns=@JoinColumn(name="ACTOR_NO",referencedColumnName="ACTOR_ID"))
	private Set<Long> phNumbers;
	@ElementCollection
	@CollectionTable(name="ACTOR_IDDETAILS",joinColumns=@JoinColumn(name="ACTOR_NO",referencedColumnName="ACTOR_ID"))
	@MapKeyColumn(name="ID_TYPE")
	private Map<String,Long> idDetails;
	
}
