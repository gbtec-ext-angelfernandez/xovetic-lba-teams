package com.gbtec.lba.teams.remote.model;

/**
 * <p>
 * Java bean handling the LBA players information.
 * </p>
 */
public class Player {

	private Integer playerId;
	
	private Integer teamId;

	private String firstName;

	private String lastName;

	public Integer getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}

	public Integer getTeamId() {
		return teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
