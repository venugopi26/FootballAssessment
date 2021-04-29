/**
 * 
 */
package com.football.assessment.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.football.assessment.common.ResponseObject;
import com.football.assessment.pojo.OverallLeaguePosition;
import com.football.assessment.pojo.Standings;
import com.football.assessment.service.FootballMethod;
import com.football.assessment.service.FootballService;
import com.football.assessment.util.HTTPUtil;

/**
 * @author venugopal
 *
 */
@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class FootballServiceMockTest {

	@InjectMocks
	FootballService footballService = new FootballService();

	@Mock
	FootballMethod footballMethod;

	@Mock
	HTTPUtil httpUtil;

	
	public void getCountryIdSuccess() {

		String countryResponse = "[\n" + "    {\n" + "        \"country_id\": \"41\",\n"
				+ "        \"country_name\": \"England\",\n"
				+ "        \"country_logo\": \"https://apiv2.apifootball.com/badges/logo_country/41_england.png\"\n"
				+ "    },\n" + "    {\n" + "        \"country_id\": \"46\",\n"
				+ "        \"country_name\": \"France\",\n"
				+ "        \"country_logo\": \"https://apiv2.apifootball.com/badges/logo_country/46_france.png\"\n"
				+ "    }\n" + "]";

		String leagueResponse = "[\n" + "    {\n" + "        \"country_id\": \"41\",\n"
				+ "        \"country_name\": \"England\",\n" + "        \"league_id\": \"149\",\n"
				+ "        \"league_name\": \"Championship\",\n" + "        \"league_season\": \"2020/2021\",\n"
				+ "        \"league_logo\": \"https://apiv2.apifootball.com/badges/logo_leagues/149_championship.png\",\n"
				+ "        \"country_logo\": \"https://apiv2.apifootball.com/badges/logo_country/41_england.png\"\n"
				+ "    }\n" + "]";

		Standings teamResponse = new Standings("England", "149", "Championship", "2623", "Watford", "2");		

		Mockito.when(footballService.getCounryId(Mockito.anyString())).thenReturn(countryResponse);

		Mockito.when(footballService.getLeagueId(Mockito.anyString(), Mockito.anyString())).thenReturn(leagueResponse);

		Mockito.when(footballService.getTeamPosition(Mockito.anyString(), Mockito.anyString()))
				.thenReturn(teamResponse);

		ResponseObject<OverallLeaguePosition> result = footballService.overallLeaguePosition("England", "Championship",
				"Watford");

		assertEquals(result.getStatusCode(), "200");
	}

}
