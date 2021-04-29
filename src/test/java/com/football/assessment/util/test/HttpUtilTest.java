/**
 * 
 */
package com.football.assessment.util.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.football.assessment.common.ConfigProperties;
import com.football.assessment.util.HTTPUtil;

/**
 * @author Venu.Gopal
 *
 */
@SpringBootTest
@ActiveProfiles("test")
public class HttpUtilTest {
	
private static final Logger LOGGER = LoggerFactory.getLogger(HttpUtilTest.class);
		
	@Autowired
	HTTPUtil httpUtil;
	
	@Autowired 
	ConfigProperties configProperties;
	
	/**
	 * TC_17
	 * Description     : Http util success response.
	 * Class           : Httputil  
	 * Method          : get
	 * Input           : team standings url. 
	 * Expected Output : Error response, league does not exist. 
	 */
	@Test
	public void httpUtilSuccess_TC_17() {
		String url = configProperties.getBaseurl()+configProperties.getStandings()+"149"+configProperties.getApikey();
		String response = httpUtil.get(url);
		try {
			JSONObject json = new JSONObject(response);
			assertEquals(json.get("overall_league_position"), "2");
		} catch (JSONException e) {
			LOGGER.error("Error while parsing json",e.getMessage());
		}
	}
	/**
	 * TC_18
	 * Description     : Http util failure response.
	 * Class           : Httputil  
	 * Method          : get
	 * Input           : Requesting api without apikey. 
	 * Expected Output : 404. 
	 */
	@Test
	public void httpUtilFailure_TC_18() {
		String url = configProperties.getBaseurl()+configProperties.getStandings()+"149";
		String response = httpUtil.get(url);	
		try {
			JSONObject json = new JSONObject(response);
			assertEquals(json.get("error"), 404);
		} catch (JSONException e) {
			LOGGER.error("Error while parsing json",e.getMessage());
		}
	}

}
