package com.gbtec.lba.teams.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gbtec.lba.teams.model.Team;

@Repository
public interface TeamRepository extends CrudRepository<Team, Serializable> {
	
	List<Team> findAll();
	
	Team findByTeamId(Integer teamId);
	
	Team findByAbbreviation(String abbreviation);
	
}
