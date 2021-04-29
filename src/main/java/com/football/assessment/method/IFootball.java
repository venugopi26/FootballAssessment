/**
 * 
 */
package com.football.assessment.method;

/**
 * @author venugopal
 *
 */
public interface IFootball {
	
	public String getCounryId(String country);
	
	public String getLeagueId(String countryId, String league);
	
	public String getTeamPosition(String leagueId, String team);
}
