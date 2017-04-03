package com.assignment.ib.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Tarun
 *
 */
public class AccountResponse implements Serializable {

	private static final long serialVersionUID = 7168308070684640601L;
	
	@JsonProperty("success")
	private String success;
	
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("password")
	private String password;

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "AccountResponse [success=" + success + ", description=" + description + ", password=" + password + "]";
	}
}
