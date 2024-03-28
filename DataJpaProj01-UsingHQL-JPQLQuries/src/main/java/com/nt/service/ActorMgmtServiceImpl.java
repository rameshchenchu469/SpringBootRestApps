package com.nt.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Actor;
import com.nt.repo.ActorRepository;

@Service
public class ActorMgmtServiceImpl implements IActorMgmtService {
	
	@Autowired
	private ActorRepository actorRepo;

	@Override
	public Actor saveActor(Actor actor) {
		
//		Actor actor1=new Actor();
//		actor1.setAname(actor.getAname());
//		actor1.setRole(actor.getRole());
//		actor1.setNickNames(actor.getNickNames());
//		actor.setPhNumbers(actor.getPhNumbers());
//		actor.setIdDetails(actor.getIdDetails());
	return actorRepo.save(actor);
	}

	@Override
	public List<Actor> findActorByCategory(String role) {
		
		 List<Actor> actors = actorRepo.getActorsBycategory(role);
	List<Actor> actorsList=actors.stream().sorted((a1,a2)->a2.getAname().compareTo(a1.getAname())).collect(Collectors.toList());
		  //List<Actor> actors1=((List<Actor>) (List(actors))).stream().sorted(Comparator.comparing(Actor->((com.nt.entity.Actor) Actor).getAname())).collect(Collectors.toList());
	return  actorsList;
	}


}
