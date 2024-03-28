package com.nt.service;

import java.util.List;
import java.util.Optional;

import com.nt.model.IPLTeam;

public interface IIPLTeamService {
public String registerTeam(IPLTeam iplTeam); 
public Optional<IPLTeam> getTeamByID(Integer tid);
public List<IPLTeam> getAll();
}
