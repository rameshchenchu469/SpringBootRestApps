package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.client.ITeamServiceConsumerClient;
import com.nt.entity.IPLPlayer;
import com.nt.entity.IPLTeam;
import com.nt.repo.IPlayerRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class IPLPlayerServiceImpl implements IIPLPlayerService {

	@Autowired
	private IPlayerRepository playerRepo;
	
	@Autowired
	private ITeamServiceConsumerClient client;
	
	public String registerPlayer(IPLPlayer player) {
		
		log.info("PlayerMgmtServiceImpl:: savePlayer");
		//get Team by id
		IPLTeam  team=client.fetchTeamById(player.getTeamInfo().getTeamId()).getBody();
		System.out.println(team.toString());
		//set Team to player
		player.setTeamInfo(team);
		int idVal=playerRepo.save(player).getPalyerId();
		return  "Player is saved with idValue ::"+idVal;
	}
	

	@Override
	public Iterable<IPLPlayer> showAllPlayers() {
		log.info("PlayerMgmtServiceImpl::showAllPlayers()");
		return playerRepo.findAll();
	}

	@Override
	public IPLPlayer showPlayerById(Integer id) {
		log.info("PlayerMgmtServiceImpl::showPlayerById()");
	     return   playerRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid Player Id"));
	}
}
