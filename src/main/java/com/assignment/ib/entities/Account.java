package com.assignment.ib.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Tarun
 *
 */
@Entity
@Table(name = "UC_ACCOUNT")
public class Account {
	
	@Column(name="UCA_ACCOUNT_ID")
	@Id
	private String accountId;
	
	@Column(name="UCA_PASSWORD")
	private String password;

	@OneToMany(mappedBy ="account")
	private List<Urls> urls;
	
	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Urls> getUrls() {
		return urls;
	}

	public void setUrls(List<Urls> urls) {
		this.urls = urls;
	}
	
	
}
