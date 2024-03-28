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

import com.nt.entity.Actor;
import com.nt.service.IActorMgmtService;

@RestController
@RequestMapping("/actor/api")
public class ActorOperationalController {
	@Autowired
	private IActorMgmtService actorService;
	
	@PostMapping("/register")
	public ResponseEntity<?> registerActor(@RequestBody Actor actor) {
		try {
		Actor actorDetails=actorService.saveActor(actor);
		return new ResponseEntity<Actor>(actorDetails,HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<String>("problem in register",HttpStatus.INTERNAL_SERVER_ERROR);
		}
				
	}
	
	@GetMapping("/category/{role}")
	public ResponseEntity<?> fetchActorsByCategory(@PathVariable String role){
		
		try {
		Iterable<Actor> HerosList=actorService.findActorByCategory(role);
		return new ResponseEntity<Iterable<Actor>>(HerosList,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>("category not found for fetching the details",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
