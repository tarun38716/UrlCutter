package com.assignment.ib.endpoints;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.ib.exception.UrlCutterException;
import com.assignment.ib.request.AccountRequest;
import com.assignment.ib.response.AccountResponse;
import com.assignment.ib.service.AccountService;
import com.assignment.ib.util.UrlCutterUtility;

/**
 * @author Tarun
 *
 */
@RestController
public class AccountsController {

	@Autowired
	@Qualifier("AccountService")
	AccountService accountService;

	@PostMapping("/account")
	public ResponseEntity<?> saveAccount(@Valid @RequestBody AccountRequest accountRequest){
		AccountResponse response = null;
		try{
			response =	accountService.saveAccount(accountRequest.getAccountId());
		} catch(UrlCutterException e) {
			return UrlCutterUtility.exceptionResponseBuilder(e);
		}
		return new ResponseEntity<AccountResponse>(response,HttpStatus.OK);
	}
}
