/**
 * 
 */
package com.football.assessment.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author venugopal
 *
 */
@Component
public class HTTPUtil {

	@Autowired
	RestTemplate restTemplate;

	public String get(String url) {
		String result = null;
		if (null == url || url.isBlank()) {
			throw new RuntimeException("URL cannot be empty.");
		}
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Content-Type", "application/json");
		HttpEntity<String> requestEntity = new HttpEntity<>(null, httpHeaders);
		ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
		if (HttpStatus.OK == responseEntity.getStatusCode() || HttpStatus.CREATED == responseEntity.getStatusCode()) {
			result = responseEntity.getBody();
		}
		return result;
	}

}
