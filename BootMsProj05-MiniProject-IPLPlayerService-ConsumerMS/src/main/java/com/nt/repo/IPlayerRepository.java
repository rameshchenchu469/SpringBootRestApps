package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.IPLPlayer;

public interface IPlayerRepository extends JpaRepository<IPLPlayer, Integer> {

}
