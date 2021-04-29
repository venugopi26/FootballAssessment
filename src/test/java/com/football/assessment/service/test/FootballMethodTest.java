/**
 * 
 */
package com.football.assessment.service.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.football.assessment.common.ConfigProperties;
import com.football.assessment.service.FootballMethod;

/**
 * @author Venu.Gopal
 *
 */
@SpringBootTest
@ActiveProfiles("test")
public class FootballMethodTest {

	@Autowired
	FootballMethod  footballMethod;
	
	@Autowired 
	ConfigProperties configProperties;
	
	/**
	 * TC_14
	 * Description     : Get countryId success
	 * Class           : FootballService  
	 * Method          : getCounryId
	 * Input           : Country name
	 * Expected Output : country id 41
	 */
	@Test
	public void getCountryIdSuccesss_TC_14() {
		String countryId = footballMethod.getCounryId("England");
		assertNotNull(countryId);
	}
	
	/**
	 * TC_15
	 * Description     : Get league success
	 * Class           : FootballService  
	 * Method          : getLeagueId
	 * Input           : CountryId, League name
	 * Expected Output : league id 149
	 */
	@Test
	public void getLeagueSuccesss_TC_15() {
		String leagueId = footballMethod.getLeagueId("41","Championship");
		assertNotNull(leagueId);
	}

	
	/**
	 * TC_16
	 * Description     : Get TeamId and Position success
	 * Class           : FootballService  
	 * Method          : getTeamPosition
	 * Input           : League id, team name
	 * Expected Output : team id 2461
	 */
	@Test
	public void getTeamSuccesss_TC_16() {
		String leagueId = footballMethod.getTeamPosition("149","Norwich");
		assertNotNull(leagueId);
	}

}
