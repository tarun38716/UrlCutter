package com.assignment.ib.request;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.internal.Nullable;

/**
 * @author Tarun
 *
 */
public class UrlRegisterRequest implements Serializable {

	private static final long serialVersionUID = 2779467785230026761L;
	
	@JsonProperty("url")
	@NotBlank(message = "Please Provide URL.")
	@URL(message = "Please Provide Valid URL")
	String url;
	
	@JsonProperty("redirectType")
	@Nullable
	@Max(value=302, message = "Please Enter Valid Redirect Type")
	@Min(value=301, message = "Please Enter Valid Redirect Type")
	int redirectType;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getRedirectType() {
		return redirectType;
	}

	public void setRedirectType(int redirectType) {
		this.redirectType = redirectType;
	}
}
