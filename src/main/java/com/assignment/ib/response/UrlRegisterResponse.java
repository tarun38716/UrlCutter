package com.assignment.ib.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Tarun
 *
 */
public class UrlRegisterResponse implements Serializable {

	private static final long serialVersionUID = 2779467785230026761L;
	
	@JsonProperty("shortUrl:")
	String shortUrl;

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}
}
