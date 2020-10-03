package com.gbtec.lba.teams.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * <p>
 * Java bean handling the LBA teams information.
 * </p>
 */
@Entity
@Table(name = "teams", schema = "teams", uniqueConstraints = { @UniqueConstraint(columnNames = { "team_id" }) })
public class Team {

	@Id
	@Column(name = "team_id")
	private Integer teamId;

	@Column(name = "abbreviation")
	private String abbreviation;

	@Column(name = "team_name")
	private String teamName;

	@Column(name = "simple_name")
	private String simpleName;

	@Column(name = "location")
	private String location;

	public Integer getTeamId() {
		return teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getSimpleName() {
		return simpleName;
	}

	public void setSimpleName(String simpleName) {
		this.simpleName = simpleName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
