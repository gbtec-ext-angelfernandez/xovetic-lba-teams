package com.gbtec.lba.teams.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.gbtec.lba.teams.model.Team;
import com.gbtec.lba.teams.remote.PlayersFeignController;
import com.gbtec.lba.teams.remote.model.Player;
import com.gbtec.lba.teams.service.TeamService;

/**
 * <p>
 * Teams controller class.
 * </p>
 */
@Controller
public class TeamsController {

	@Autowired
	private PlayersFeignController playersFeignController;

	@Autowired
	private TeamService teamService;

	/**
	 * <p>
	 * Full list of teams.
	 * </p>
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/list")
	public String init(@ModelAttribute("model") ModelMap model) {
		model.addAttribute("teamList", teamService.findAll());
		return "index";
	}

	@GetMapping(value = "/team/{abbreviation}")
	public String init(@ModelAttribute("model") ModelMap model,
			@PathVariable(name = "abbreviation", required = true) String abbreviation) {
		try {
			Team team = teamService.findByAbbreviation(abbreviation);		
			model.addAttribute("team", team);

			List<Player> teamRoster = playersFeignController.getTeamPlayers(team.getTeamId());	
			model.addAttribute("roster", teamRoster);
			return "roster";
		} catch (Exception e) {
			model.addAttribute("errorMessage", e.getMessage());
			return "error";
		}
		
	}
}
