package com.gbtec.lba.teams;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gbtec.lba.teams.model.Team;
import com.gbtec.lba.teams.service.TeamService;

@Component
public class TeamsInitializer implements ApplicationListener<ContextRefreshedEvent> {

	private static final Logger LOG = LoggerFactory.getLogger(TeamsInitializer.class);

	private static final String DEFAULT_TEAMS_FILE_LOCATION = "assets/default-teams.json";

	@Autowired
	private TeamService teamService;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		LOG.info("Teams startup");

		long totalTeams = teamService.count();
		LOG.info("Total teams: {}", totalTeams);

		if (totalTeams == 0) {
			insertDefaultTeams();
		}
	}

	private void insertDefaultTeams() {
		List<Team> teams = readDefaultTeams();

		for (Team team : teams) {
			if (teamService.findByTeamId(team.getTeamId()) == null) {
				LOG.info("Adding '{}' to teams table", team.getTeamName());
				teamService.insert(team);
			}
		}
	}

	private List<Team> readDefaultTeams() {

		List mapList = new ArrayList<>();

		try {
			ObjectMapper mapper = new ObjectMapper();

			mapList = mapper.readValue(
					new InputStreamReader(new ClassPathResource(DEFAULT_TEAMS_FILE_LOCATION).getInputStream(),
							StandardCharsets.UTF_8),
					List.class);
		} catch (IOException e) {
			LOG.error("", e);
		}
		return convertToTeams(mapList);
	}

	private List<Team> convertToTeams(List mapList) {
		List<Team> result = new ArrayList<Team>();

		for (Object mapElement : mapList) {
			if (mapElement instanceof Map) {
				Map data = (Map) mapElement;

				Team newTeam = new Team();
				newTeam.setTeamId(Integer.valueOf(data.get("teamId").toString()));
				newTeam.setAbbreviation(data.get("abbreviation").toString());
				newTeam.setTeamName(data.get("teamName").toString());
				newTeam.setSimpleName(data.get("simpleName").toString());
				newTeam.setLocation(data.get("location").toString());
				result.add(newTeam);
			}
		}
		return result;
	}
}