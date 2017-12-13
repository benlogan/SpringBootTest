package com.loganbe;

/**
 * Modelling our response object, following attempted authentication & authorisation 
 */
public class ExaneResponse {

	private boolean authorised = false;
	private String email;
	private String content;
	
    @Override
    public String toString() {
        return "ExaneResponse{" +
                "authorised=" + authorised +
                ", email='" + email + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
	
	public boolean isAuthorised() {
		return authorised;
	}
	public void setAuthorised(boolean authorised) {
		this.authorised = authorised;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}