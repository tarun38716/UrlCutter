package com.assignment.ib.request;

import java.io.Serializable;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Tarun
 *
 */
public class AccountRequest implements Serializable {

	private static final long serialVersionUID = -7593409174904302599L;
	
	@JsonProperty("AccountId")
	@NotBlank(message = "Account Id cannot be blank")
	@Size(max = 20 , message = "Account Id cannot be more than 20 characters")
	private String accountId;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	@Override
	public String toString() {
		return "AccountRequest [accountId=" + accountId + "]";
	}
}
