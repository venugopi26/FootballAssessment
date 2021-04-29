/**
 * 
 */
package com.football.assessment.common;

import java.io.Serializable;

/**
 * @author venugopal
 * {@summary Default response class}
 */
public class ResponseObject<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3922436009583661046L;
	private int statusCode = 500;
	private T response;
	private String errorResponse;
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public T getResponse() {
		return response;
	}
	public void setResponse(T response) {
		this.response = response;
	}
	public String getErrorResponse() {
		return errorResponse;
	}
	public void setErrorResponse(String errorResponse) {
		this.errorResponse = errorResponse;
	}
	
	

}
