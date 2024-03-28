package com.nt.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nt.entity.IPLTeam;


@FeignClient("TEAM-SERVICE")
public interface ITeamServiceConsumerClient {

	@GetMapping("/team/api/get/{tid}")
	   public  ResponseEntity<IPLTeam>  fetchTeamById(@PathVariable Integer tid);
	}
