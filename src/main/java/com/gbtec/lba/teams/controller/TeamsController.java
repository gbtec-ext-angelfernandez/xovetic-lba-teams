package com.gbtec.lba.teams.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.gbtec.lba.teams.service.TeamService;

/**
 * <p>
 * Teams controller class.
 * </p>
 */
@Controller
public class TeamsController {

	@Autowired
	private TeamService teamService;

	/**
	 * <p>
	 * Homepage.
	 * </p>
	 */
	@GetMapping(value = "/")
	public String home() {
		return "redirect:/teams";
	}

	/**
	 * <p>
	 * Full list of teams.
	 * </p>
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/teams")
	public String init(@ModelAttribute("model") ModelMap model) {
		model.addAttribute("teamList", teamService.findAll());
		return "index";
	}

}
