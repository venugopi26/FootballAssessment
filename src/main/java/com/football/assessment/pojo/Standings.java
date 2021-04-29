package com.football.assessment.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author venugopal
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Standings {

	private String country_name;
	private String league_id;
	private String league_name;
	private String team_id;
	private String team_name;
	private String overall_league_position;
	
	/**
	 * Default constructor
	 */
	public Standings() {
		super();
	}
	/**
	 * Parameterized constructor	
	 * @param country_name
	 * @param league_id
	 * @param league_name
	 * @param team_id
	 * @param team_name
	 * @param overall_league_position
	 */
	public Standings(String country_name, String league_id, String league_name, String team_id, String team_name,
			String overall_league_position) {
		super();
		this.country_name = country_name;
		this.league_id = league_id;
		this.league_name = league_name;
		this.team_id = team_id;
		this.team_name = team_name;
		this.overall_league_position = overall_league_position;
	}


	public String getCountry_name() {
		return country_name;
	}
	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}
	public String getLeague_id() {
		return league_id;
	}
	public void setLeague_id(String league_id) {
		this.league_id = league_id;
	}
	public String getLeague_name() {
		return league_name;
	}
	public void setLeague_name(String league_name) {
		this.league_name = league_name;
	}
	public String getTeam_id() {
		return team_id;
	}
	public void setTeam_id(String team_id) {
		this.team_id = team_id;
	}
	public String getTeam_name() {
		return team_name;
	}
	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}
	public String getOverall_league_position() {
		return overall_league_position;
	}
	public void setOverall_league_position(String overall_league_position) {
		this.overall_league_position = overall_league_position;
	}
	
	
}
