package com.assignment.ib.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.assignment.ib.entities.Account;
import com.assignment.ib.exception.UrlCutterException;
import com.assignment.ib.repositories.AccountRepository;
import com.assignment.ib.repositories.UrlsRepository;
import com.assignment.ib.response.AccountResponse;
import com.assignment.ib.util.UrlCutterUtility;

/**
 * @author Tarun
 *
 */
@Service("AccountService")
public class AccountService {

	@Autowired
	@Qualifier("AccountRepository")
	private AccountRepository accountRepository;
	
	@Autowired
	@Qualifier("UrlsRepository")
	private UrlsRepository urlsRepository;

	public AccountResponse saveAccount(String accountId) throws UrlCutterException {
		AccountResponse response = new AccountResponse();
		try{
			if(!accountRepository.exists(accountId)){
				Account account = new Account();
				account.setAccountId(accountId);
				account.setPassword(UrlCutterUtility.generateRandomPassword());
				accountRepository.save(account);
				response.setSuccess("true");
				response.setDescription("Your account is opened");
				response.setPassword(account.getPassword());
			} else{
				response.setSuccess("false");
				response.setDescription("Account for account Id: "+accountId+" already exist");
			}
		} catch(Exception e){
			throw new UrlCutterException(e, "Internal Error Occured. Please try again later");
		}
		return response;
	}
	
	public Map<String, Long> fetchStats(String accountId) throws UrlCutterException{
		Map<String, Long> map = new HashMap<String, Long>();
		try{
			List<Object[]> result = urlsRepository.getUrlStats(accountId);
			result.forEach(data->map.put((String)data[0], (Long)data[1]));
		} catch(Exception e){
			throw new UrlCutterException(e, "Internal Error Occured. Please try again later");
		}
		return map;
	}

}
