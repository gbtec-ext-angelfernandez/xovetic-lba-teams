package com.gbtec.lba.teams.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gbtec.lba.teams.model.Team;
import com.gbtec.lba.teams.repository.TeamRepository;

/**
 * <p>Teams Service.</p>
 */
@Service
public class TeamService {

	@Autowired
	private TeamRepository teamRepository;
	
	/**
	 * <p>Return all teams information.</p>
	 * @return Teams list
	 */
	public List<Team> findAll() {
		return teamRepository.findAll();
	}
	
	/**
	 * <p>Return team information for a given team id.</p>
	 * @param teamId Team id
	 * @return Team information
	 */
	public Team findByTeamId(Integer teamId) {
		return teamRepository.findByTeamId(teamId);
	}
	
	/**
	 * <p>Return team information for a given team abrreviation text.</p>
	 * @param abbreviation Team abbreviation
	 * @return Team information
	 */
	public Team findByAbbreviation(String abbreviation) {
		return teamRepository.findByAbbreviation(abbreviation);
	}

	/**
	 * <p>Get the total number of teams in the league.</p>
	 * @return
	 */
	public long count() {
		return teamRepository.count();
	}

	/**
	 * <p>Add a new team.</p>
	 * @param team Team instance
	 */
	public void insert(Team team) {
		teamRepository.save(team);		
	}
	
}

