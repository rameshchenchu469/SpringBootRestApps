package com.nt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.nt.entity.Actor;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
	
	@Query("from Actor where role=:category")
	public List<Actor> getActorsBycategory(String category);

}
