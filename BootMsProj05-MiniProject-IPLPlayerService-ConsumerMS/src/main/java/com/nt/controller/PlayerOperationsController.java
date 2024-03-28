package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.IPLPlayer;
import com.nt.service.IIPLPlayerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/player/api")
@Slf4j
public class PlayerOperationsController {

	@Autowired
	private IIPLPlayerService playerService;
	
	@PostMapping("/register")
	public ResponseEntity<String> savePlayer(@RequestBody IPLPlayer player) {
		
		log.info("PlayerOperationsController.savePlayer()");
		  
		String result=playerService.registerPlayer(player);
		return new ResponseEntity<String>(result,HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public  ResponseEntity<Iterable<IPLPlayer>>   fetchAllPlayers(){
		log.info("PlayerOperationsController.fetchAllPlayers()");
		//use service
		Iterable<IPLPlayer>  list=playerService.showAllPlayers();
		 return  new ResponseEntity<Iterable<IPLPlayer>>(list, HttpStatus.OK);
	}
	
	
	@GetMapping("/find/{pid}")
	public    ResponseEntity<IPLPlayer>  findPlayerById(@PathVariable Integer  pid){
		log.info("PlayerOperationsController.findPlayerById()");
		//use service
		 IPLPlayer player=playerService.showPlayerById(pid);
		 return new ResponseEntity<IPLPlayer>(player, HttpStatus.OK);
	}
	
}
