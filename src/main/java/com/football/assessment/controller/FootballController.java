/**
 * 
 */
package com.football.assessment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.football.assessment.common.ResponseObject;
import com.football.assessment.pojo.OverallLeaguePosition;
import com.football.assessment.service.FootballService;

/**
 * @author venugopal
 *
 */
@RestController
public class FootballController {

	@Autowired
	FootballService footballService;

	/**
	 * {@summary Get the team standings by passing country,league and team name}
	 * 
	 * @param country
	 * @param league
	 * @param team
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	@GetMapping(value = "/get_standing", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseObject> findStanding(
			@RequestParam(value = "country", required = true) String country,
			@RequestParam(value = "league", required = true) String league,
			@RequestParam(value = "team", required = true) String team) {

		ResponseObject<OverallLeaguePosition> responseObject = footballService.overallLeaguePosition(country, league,
				team);
		return new ResponseEntity<>(responseObject,HttpStatus.valueOf(responseObject.getStatusCode()));		 

	}

}
