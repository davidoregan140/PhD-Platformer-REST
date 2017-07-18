package io.larkin.phdplatformer.response;

/**
 * Ensure a properly formatted JSON response, even when only true or false is returned
 * 
 * @author Larkin.Cunningham
 *
 */
public class BooleanResponseWithMessage {

	public BooleanResponseWithMessage(Boolean response) {
		this.response = response;
	}
	public BooleanResponseWithMessage(Boolean response, String message) {
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
