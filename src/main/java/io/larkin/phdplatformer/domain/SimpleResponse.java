package io.larkin.phdplatformer.domain;

/**
 * Ensure a properly formatted JSON response, even when only true or false is returned
 * 
 * @author Larkin.Cunningham
 *
 */
public class SimpleResponse {

	public SimpleResponse(Boolean response) {
		this.response = response;
	}
	public SimpleResponse(Boolean response, String message) {
		this.response = response;
		this.message = message;
	}
	
	private Boolean response;
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getResponse() {
		return response;
	}

	public void setResponse(Boolean response) {
		this.response = response;
	}
}
