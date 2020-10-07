package com.gbtec.lba.teams.remote;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.gbtec.lba.teams.remote.model.Player;


@Controller
public class PlayersFeignController {

	@Autowired
	private PlayersServiceProxy playersServiceProxy;

	@GetMapping(value = "/feign/getTeamPlayers/{teamId}")
	public List<Player> getTeamPlayers(@PathVariable("teamId") Integer teamId) {
		return playersServiceProxy.getTeamPlayers(teamId);
	}
}
