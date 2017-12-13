package com.loganbe;

/**
 * Modelling the response from the CRM authorisation service
 */
public class CheckUser {

	private boolean exaneResearchAccess = false;
    private String httpStatus; //"OK"
    private String errors;
	
    @Override
    public String toString() {
        return "CheckUser{" +
                "exaneResearchAccess=" + exaneResearchAccess +
                ", httpStatus='" + httpStatus + '\'' +
                ", errors='" + errors + '\'' +
                '}';
    }
    
    public boolean isExaneResearchAccess() {
		return exaneResearchAccess;
	}
	public void setExaneResearchAccess(boolean exaneResearchAccess) {
		this.exaneResearchAccess = exaneResearchAccess;
	}
	public String getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(String httpStatus) {
		this.httpStatus = httpStatus;
	}
	public String getErrors() {
		return errors;
	}
	public void setErrors(String errors) {
		this.errors = errors;
	}
	
}