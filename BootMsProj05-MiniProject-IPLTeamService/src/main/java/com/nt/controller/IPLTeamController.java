package com.nt.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.IPLTeam;
import com.nt.service.IIPLTeamService;

@RestController
@RequestMapping("/team/api")
public class IPLTeamController {

	@Autowired
	private IIPLTeamService teamService;
	
	@PostMapping("/register")
	public ResponseEntity<String> saveIPLTeam(@RequestBody IPLTeam iplTeam) {
		try {
	String result= teamService.registerTeam(iplTeam);
	return new ResponseEntity<String>(result,HttpStatus.CREATED);
	}
		catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("problem in register team",HttpStatus.INTERNAL_SERVER_ERROR);
		}
}
	@GetMapping("get/{tid}")
	public ResponseEntity<?> fetchTeamById(@PathVariable Integer tid) {
		try {
		Optional<IPLTeam> iplTeam=teamService.getTeamByID(tid);
		IPLTeam team=iplTeam.orElseThrow(()-> new IllegalArgumentException("Team not for fetching the deatils"));
		return new ResponseEntity<IPLTeam>(team,HttpStatus.OK);
	}
		catch(Exception e) {
			return new ResponseEntity<String>("Problem in fetching the team details",HttpStatus.INTERNAL_SERVER_ERROR);
		}
}
	
	@GetMapping("/FtechAllTeams")
	public ResponseEntity<?> fetchAllTeams(){
		try {
			List<IPLTeam> teams=teamService.getAll();
			return new ResponseEntity<List<IPLTeam>>(teams,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>("problem infetching teams details",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}


