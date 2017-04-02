package com.assignment.ib.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Tarun
 *
 */
@Entity
@Table(name = "UC_URLS")
public class Urls {
	
	@GeneratedValue
	@Id
	@Column(name = "UCU_URL_ID")
	private int id;
	
	@Column(name = "UCU_SHORT_URL")
	private String shortUrl;
	
	@Column(name = "UCU_LONG_URL")
	private String longUrl;
	
	@Column(name = "UCU_REDIRECT_TYPE")
	private int redirectType;
	
	@Column(name = "UCU_COUNT")
	private long count;
	
	@ManyToOne
	@JoinColumn(name="UCA_ACCOUNT_ID")
	private Account account;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	public String getLongUrl() {
		return longUrl;
	}

	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
	}

	public int getRedirectType() {
		return redirectType;
	}

	public void setRedirectType(int redirectType) {
		this.redirectType = redirectType;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}
}
