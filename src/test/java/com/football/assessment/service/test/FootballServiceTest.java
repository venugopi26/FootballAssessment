/**
 * 
 */
package com.football.assessment.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.football.assessment.common.ResponseObject;
import com.football.assessment.pojo.OverallLeaguePosition;
import com.football.assessment.pojo.Standings;
import com.football.assessment.service.FootballService;

/**
 * @author Venu.Gopal
 *
 */
@SpringBootTest
@ActiveProfiles("test")
public class FootballServiceTest {
	
private static final Logger LOGGER = LoggerFactory.getLogger(FootballServiceTest.class);
	
	@Autowired
	FootballService footballService;
		
	/**
	 * TC_01
	 * Description     : Overall standing position success
	 * Class           : FootballService  
	 * Method          : overallLeaguePosition
	 * Input           : Country name, League name, Team name
	 * Expected Output : Position 2 
	 */
	@Test
	public void standingAssertionSuccess_TC_01() {
		ResponseObject<OverallLeaguePosition> response = footballService.overallLeaguePosition("England",
				"Championship", "Watford");
		assertEquals(response.getResponse().getPosition(), "2");
	}
	
	/**
	 * TC_02
	 * Description     : Overall standing position assertion failed
	 * Class           : FootballService  
	 * Method          : overallLeaguePosition
	 * Input           : Country name, League name, Team name
	 * Expected Output : Position 222 
	 */	
	@Test
	public void standingAssertionFailed_TC_02() {
		ResponseObject<OverallLeaguePosition> response = footballService.overallLeaguePosition("England",
				"Championship", "Watford");
		assertNotEquals(response.getResponse().getPosition(), "222");
	}
	
	/**
	 * TC_03
	 * Description     : Country does not in football country api.
	 * Class           : FootballService  
	 * Method          : overallLeaguePosition
	 * Input           : Country name, League name, Team name
	 * Expected Output : Error response, country does not exist. 
	 */	
	@Test
	public void countryNotExist_TC_03() {
		ResponseObject<OverallLeaguePosition> response = footballService.overallLeaguePosition("India", "Championship",
				"Watford");
		assertEquals(response.getErrorResponse(), "Country does not exist.");
	}
	/**
	 * TC_04
	 * Description     : League does not in football country api.
	 * Class           : FootballService  
	 * Method          : overallLeaguePosition
	 * Input           : Country name, League name, Team name
	 * Expected Output : Error response, league does not exist. 
	 */	
	@Test
	public void leagueNotExist_TC_04() {
		ResponseObject<OverallLeaguePosition> response = footballService.overallLeaguePosition("England", "Laliga",
				"Watford");
		assertEquals(response.getErrorResponse(), "League does not exist.");
	}
	/**
	 * TC_05
	 * Description     : Team does not in football country api.
	 * Class           : FootballService  
	 * Method          : overallLeaguePosition
	 * Input           : Country name, League name, Team name
	 * Expected Output : Error response, team does not exist. 
	 */
	@Test
	public void teamNotExist_TC_05() {
		ResponseObject<OverallLeaguePosition> response = footballService.overallLeaguePosition("England",
				"Championship", "RCB");
		assertEquals(response.getErrorResponse(), "Team Standings does not exist.");
	}
	/**
	 * TC_06
	 * Description     : Passing country as null.
	 * Class           : FootballService  
	 * Method          : overallLeaguePosition
	 * Input           : Country name, League name, Team name
	 * Expected Output : Null pointer exception. 
	 */
	@Test
	public void getStandingPositionByPassingNull_TC_06() {
		try {
			ResponseObject<OverallLeaguePosition> response = footballService.overallLeaguePosition(null, "Championship",
					"Watford");
			assertEquals(response.getResponse().getPosition(), "2");
		} catch (NullPointerException e) {
			assertEquals(null, e.getMessage());
			LOGGER.error("Msg",e.getMessage());
		}
	}
	/**
	 * TC_07
	 * Description     : Corresponding League not exist for country.
	 * Class           : FootballService  
	 * Method          : overallLeaguePosition
	 * Input           : Country name, League name, Team name
	 * Expected Output : Error response, league does not exist. 
	 */
	@Test
	public void getStandingPositionByPassingNull_TC_07() {
			ResponseObject<OverallLeaguePosition> response = footballService.overallLeaguePosition("France", "Championship",
					"Watford");
			assertEquals(response.getErrorResponse(), "League does not exist.");	
	}
	
	/**
	 * TC_08
	 * Description     : Get countryId success
	 * Class           : FootballService  
	 * Method          : getCounryId
	 * Input           : Country name
	 * Expected Output : country id 41
	 */
	@Test
	public void getCountryIdSuccesss_TC_08() {
		String countryId = footballService.getCounryId("England");
		assertEquals(countryId, "41");
	}
	
	/**
	 * TC_09
	 * Description     : Get countryId failure
	 * Class           : FootballService  
	 * Method          : getCounryId
	 * Input           : Country name
	 * Expected Output : country id 41
	 */
	@Test
	public void getCountryIdfailure_TC_09() {
		String countryId = footballService.getCounryId("England");
		assertNotEquals(countryId, "42");
	}
	
	/**
	 * TC_10
	 * Description     : Get league success
	 * Class           : FootballService  
	 * Method          : getLeagueId
	 * Input           : CountryId, League name
	 * Expected Output : league id 149
	 */
	@Test
	public void getLeagueSuccesss_TC_10() {
		String leagureId = footballService.getLeagueId("41","Championship");
		assertEquals(leagureId, "149");
	}
	
	/**
	 * TC_11
	 * Description     : Get league failure
	 * Class           : FootballService  
	 * Method          : getLeagueId
	 * Input           : CountryId, League name
	 * Expected Output : league id 150
	 */
	@Test
	public void getLagueIdfailure_TC_11() {
		String leagueId = footballService.getLeagueId("42","Laliga");
		assertNotEquals(leagueId, "150");
	}
	
	/**
	 * TC_12
	 * Description     : Get TeamId and Position success
	 * Class           : FootballService  
	 * Method          : getTeamPosition
	 * Input           : League id, team name
	 * Expected Output : team id 2641
	 */
	@Test
	public void getTeamSuccesss_TC_12() {
		Standings teamId = footballService.getTeamPosition("149","Norwich");
		assertEquals(teamId.getTeam_id(), "2641");
	}
	
	/**
	 * TC_13
	 * Description     : Get TeamId and Position success
	 * Class           : FootballService  
	 * Method          : getTeamPosition
	 * Input           : League id, team name
	 * Expected Output : team id 2462
	 */
	@Test
	public void getTeamFailure_TC_13() {
		Standings teamId = footballService.getTeamPosition("149","Norwich");
		assertNotEquals(teamId.getTeam_id(), "2462");
	}
}
