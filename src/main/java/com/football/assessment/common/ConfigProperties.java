/**
 * 
 */
package com.football.assessment.common;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author venugopal
 *{@summary Configuration properties}
 */
@Component
@ConfigurationProperties(prefix = "football")
public class ConfigProperties {
	
	private String baseurl;	
	private String apikey;	
	private String countries;	
	private String leagues;	
	private String standings;
	
	public String getBaseurl() {
		return baseurl;
	}
	public void setBaseurl(String baseurl) {
		this.baseurl = baseurl;
	}
	public String getApikey() {
		return apikey;
	}
	public void setApikey(String apikey) {
		this.apikey = apikey;
	}
	public String getCountries() {
		return countries;
	}
	public void setCountries(String countries) {
		this.countries = countries;
	}
	public String getLeagues() {
		return leagues;
	}
	public void setLeagues(String leagues) {
		this.leagues = leagues;
	}
	public String getStandings() {
		return standings;
	}
	public void setStandings(String standings) {
		this.standings = standings;
	}

}
