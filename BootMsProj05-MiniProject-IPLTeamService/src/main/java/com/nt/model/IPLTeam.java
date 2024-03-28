package com.nt.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="MS_IPL_TEAM")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IPLTeam {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TEAM_ID")
	private Integer TeamId;
	@Column(name="TEAM_NAME")
	private String teamName;
	@Column(name="TEAM_SIZE")
	private Integer teamSize;
	@Column(name="TEAM_OWNER")
	private String teamOwner;
	
	
}
