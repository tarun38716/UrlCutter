package com.assignment.ib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.assignment.ib.entities.Account;
import com.assignment.ib.exception.UrlCutterException;
import com.assignment.ib.repositories.AccountRepository;
import com.assignment.ib.response.AccountResponse;
import com.assignment.ib.util.UrlCutterUtility;

@Service("AccountService")
public class AccountService {

	@Autowired
	@Qualifier("AccountRepository")
	AccountRepository accountRepository;

	public AccountResponse saveAccount(String accountId) throws UrlCutterException {
		AccountResponse response = new AccountResponse();
		try{
			if(!accountRepository.exists(accountId)){
				Account account = new Account();
				account.setAccountId(accountId);
				account.setPassword(UrlCutterUtility.generateRandomPassword());
				accountRepository.save(account);
				response.setSuccess("success");
				response.setDescription("Your account is opened");
				response.setPassword(account.getPassword());
			} else{
				response.setSuccess("failure");
				response.setDescription("Account for account Id: "+accountId+" already exist");
			}
		} catch(Exception e){
			throw new UrlCutterException(e, e.getLocalizedMessage());
		}
		return response;
	}

}
