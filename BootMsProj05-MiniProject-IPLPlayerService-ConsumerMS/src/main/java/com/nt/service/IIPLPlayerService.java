package com.nt.service;

import com.nt.entity.IPLPlayer;

public interface IIPLPlayerService {
	public String registerPlayer(IPLPlayer player);
	 public   Iterable<IPLPlayer> showAllPlayers();
	   public    IPLPlayer   showPlayerById(Integer id);
}
