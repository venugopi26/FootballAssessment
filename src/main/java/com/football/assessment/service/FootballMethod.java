package com.football.assessment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.football.assessment.common.ConfigProperties;
import com.football.assessment.method.IFootball;
import com.football.assessment.util.HTTPUtil;

/**
 * 
 * @author venugopal
 *
 */
@Service
public class FootballMethod implements IFootball{
	
	@Autowired
	HTTPUtil httpUtil;
				
	@Autowired
	ConfigProperties configProperties;
	/**
	 * Get country details
	 */
	@Override
	public String getCounryId(String country) {
		String countryUrl = configProperties.getBaseurl()+configProperties.getCountries()+configProperties.getApikey();			
		String response = httpUtil.get(countryUrl);	
		return response;
	}
	/**
	 * Get League details by passing country id 
	 */
	@Override
	public String getLeagueId(String countryId, String league) {
		String leagueUrl = configProperties.getBaseurl()+configProperties.getLeagues()+countryId+configProperties.getApikey();			
		String response = httpUtil.get(leagueUrl);
		return response;
	}
	
	/**
	 * Get teams details by passing league id
	 */
	@Override
	public String getTeamPosition(String leagueId, String team) {
		String teamUrl = configProperties.getBaseurl()+configProperties.getStandings()+leagueId+configProperties.getApikey();			
		String response = httpUtil.get(teamUrl);
		return response;
	}

}
