package com.nt.service;

import java.util.List;

import com.nt.entity.Actor;

public interface IActorMgmtService {
public Actor saveActor(Actor actor);
public List<Actor> findActorByCategory(String role);
}
