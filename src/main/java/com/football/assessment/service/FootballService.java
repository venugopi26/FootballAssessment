/**
 * 
 */
package com.football.assessment.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.football.assessment.common.ResponseObject;
import com.football.assessment.pojo.Country;
import com.football.assessment.pojo.League;
import com.football.assessment.pojo.OverallLeaguePosition;
import com.football.assessment.pojo.Standings;

/**
 * @author venugopal
 *
 */
@Service
public class FootballService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FootballService.class);
	
	@Autowired
	FootballMethod footballMethod;
	
	/**
	 * 
	 * @param country
	 * @param league
	 * @param team
	 * @return
	 */
	public ResponseObject<OverallLeaguePosition> overallLeaguePosition(String country,String league,String team) {
		ResponseObject<OverallLeaguePosition> response = new ResponseObject<OverallLeaguePosition>();
		try {
			OverallLeaguePosition overallLeaguePosition = new OverallLeaguePosition();
			// Get the Country Id
			String countryId = getCounryId(country);
			if(null == countryId) {
				response.setErrorResponse("Country does not exist.");
				return response;
			}			
			// Get League Id
			String leagueId = getLeagueId(countryId, league);
			if(null == leagueId) {
				response.setErrorResponse("League does not exist.");
				return response;
			}			
			// Get Team Position
			Standings standingInfo = getTeamPosition(leagueId, team);
			if(standingInfo == null) {
				response.setErrorResponse("Team Standings does not exist.");
				return response;
			}			
			// Construct the final response
			overallLeaguePosition.setCountry(constructFinalRes(countryId,country));
			overallLeaguePosition.setLeague(constructFinalRes(leagueId,league));
			overallLeaguePosition.setTeam(constructFinalRes(standingInfo.getTeam_id(),team));
			overallLeaguePosition.setPosition(standingInfo.getOverall_league_position());
			
			response.setStatusCode(200);
			response.setResponse(overallLeaguePosition);
		} catch (Exception e) {
			response.setErrorResponse("Error while finding league position.");
		}
		return response;		
	}
	
	/**
	 * 
	 * @param country
	 * @return
	 */
	public String getCounryId(String country) {
		String countryRes = null;
		try {
			String response = footballMethod.getCounryId(country);	
			
			/**
			 * search the country id
			 */
			ObjectMapper mapper = new ObjectMapper();			
			List<Country> listOfCountries = mapper.readValue(response, new TypeReference<List<Country>>(){});
			Optional<Country> result = listOfCountries.stream()
					.filter(c->c.getCountry_name().equalsIgnoreCase(country)).findAny(); 
			countryRes = result.isPresent() ? result.get().getCountry_id() : null;
		} catch (Exception e) {
			LOGGER.error("Error while fetching Countries.");
		}
		return countryRes;
	}
	
	/**
	 * 
	 * @param countryId
	 * @param league
	 * @return
	 */
	public String getLeagueId(String countryId, String league) {
		String leagueRes = null;
		try {
			String response = footballMethod.getLeagueId(countryId, league);
			
			/**
			 * search the league id
			 */
			ObjectMapper mapper = new ObjectMapper();			
			List<League> listOfLeagues = mapper.readValue(response, new TypeReference<List<League>>(){});
			Optional<League> result = listOfLeagues.stream()
					.filter(c->c.getLeague_name().equalsIgnoreCase(league)).findAny(); 
			leagueRes = result.isPresent() ? result.get().getLeague_id() : null;
		} catch (Exception e) {
			LOGGER.error("Error while fetching Leagues.");
		}
		return leagueRes;
	}
	/**
	 * 
	 * @param leagueId
	 * @param team
	 * @return
	 */
	public Standings getTeamPosition(String leagueId, String team) {
		Standings standingRes = null;
		try {
			String response = footballMethod.getTeamPosition(leagueId, team);		
			
			// get the team position
			ObjectMapper mapper = new ObjectMapper();			
			List<Standings> listOfStandings = mapper.readValue(response, new TypeReference<List<Standings>>(){});
			Optional<Standings> result = listOfStandings.stream()
					.filter(c->c.getTeam_name().equalsIgnoreCase(team)).findAny(); 
			standingRes = result.isPresent() ? result.get() : null;
			
		} catch (Exception e) {
			LOGGER.error("Error while fetching Standings.");
		}
		return standingRes;
	}
	
	/**
	 * 
	 * @param id
	 * @param name
	 * @return
	 */
	public String constructFinalRes(String id, String name) {
		String result = "("+id+") - "+name;
		return result;
	}
}
