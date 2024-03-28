package com.nt.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name="MS_TEAM_PLAYER")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IPLPlayer {

	@Id
	@SequenceGenerator(name="gen1",sequenceName = "PLAYER_ID_SEQ",initialValue = 1000 ,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	@Column(name="PLAYER_ID")
	private Integer palyerId;
	@Column(name="PLAYER_NAME",length = 20)
	@NonNull
	private  String playerName;
	@Column(name="ROLE",length = 20)
	@NonNull
	private   String  role;
	@NonNull
	@Column(name="JERSY_NO")
	private   Integer jersyNo;
	
	@ManyToOne(targetEntity = IPLTeam.class,cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	@JoinColumn(name = "TEAM_INFO_ID",referencedColumnName = "TEAM_ID")
	@NonNull
	private  IPLTeam  teamInfo;

}
