package com.gbtec.lba.teams.remote;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.gbtec.lba.teams.remote.model.Player;

@FeignClient(value = "LBA-Service-Players")
public interface PlayersServiceProxy {


	@GetMapping(value = "/feign/getTeamPlayers/{teamId}")
	public List<Player> getTeamPlayers(@PathVariable("teamId") Integer teamId);
	
}