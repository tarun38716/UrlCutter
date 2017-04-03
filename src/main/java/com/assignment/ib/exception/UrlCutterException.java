package com.assignment.ib.exception;

/**
 * @author Tarun
 *
 */
public class UrlCutterException extends Exception {

	private static final long serialVersionUID = 5122024381638177039L;
	
	private Throwable excep;
	private String errorMessage;
	
	public Throwable getExcep() {
		return excep;
	}

	public void setExcep(Throwable excep) {
		this.excep = excep;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public UrlCutterException(Throwable excep, String errorMessage) {
		super();
		this.excep = excep;
		this.errorMessage = errorMessage;
	}
	
	public UrlCutterException(){
		super();
	}
}
