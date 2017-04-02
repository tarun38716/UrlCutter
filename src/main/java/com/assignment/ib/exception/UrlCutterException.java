package com.assignment.ib.exception;

/**
 * @author Tarun
 *
 */
public class UrlCutterException extends Exception {

	private static final long serialVersionUID = 5122024381638177039L;
	
	private Throwable excep;
	private String errorMessage;
	
	public UrlCutterException(Throwable excep, String errorMessage) {
		super();
		this.excep = excep;
		this.errorMessage = errorMessage;
	}
	
	public UrlCutterException(){
		super();
	}
}
