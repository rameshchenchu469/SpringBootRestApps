package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.IPLTeam;
import com.nt.repo.IPLTeamRepository;

@Service
public class IPLTeamServiceImpl implements IIPLTeamService {
 
	@Autowired
	private IPLTeamRepository teamRepo;
	
	@Override
	public String registerTeam(IPLTeam iplTeam) {
		teamRepo.save(iplTeam);
		return "team registered successfully with id value"+iplTeam.getTeamId();
	}

	@Override
	public Optional<IPLTeam> getTeamByID(Integer tid) {
		
		 Optional<IPLTeam> opt=teamRepo.findById(tid);
//		 
//		  if(opt.isPresent())
//		 {
//			 System.out.println("Team Info"+opt.get());
//		 }
//		 else {
//			 System.out.println(tid+"team not found for fetching team details ");
//		 }
		 return opt;
	}

	@Override
	public List<IPLTeam> getAll() {
		
		 List<IPLTeam> teamsList=teamRepo.findAll();
		 return teamsList;
	}
}
