package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.model.IPLTeam;

public interface IPLTeamRepository extends JpaRepository<IPLTeam,Integer> {

	
}
