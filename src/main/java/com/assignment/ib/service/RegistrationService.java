package com.assignment.ib.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.assignment.ib.entities.Urls;
import com.assignment.ib.repositories.AccountRepository;
import com.assignment.ib.repositories.UrlsRepository;
import com.assignment.ib.request.UrlRegisterRequest;
import com.assignment.ib.response.UrlRegisterResponse;
import com.assignment.ib.util.UrlCutterUtility;

@Service("RegistrationService")
public class RegistrationService {
	
	@Autowired
	@Qualifier("UrlsRepository")
	private UrlsRepository urlsRepository;
	
	@Autowired
	@Qualifier("AccountRepository")
	AccountRepository accountRepository;
	
	@Transactional
	public UrlRegisterResponse registerUrl(UrlRegisterRequest urlRegisterRequest, String accountId){
		UrlRegisterResponse response = new UrlRegisterResponse();
		
		Urls urls = new Urls();
		urls.setLongUrl(urlRegisterRequest.getUrl());
		urls.setShortUrl(" ");
		urls.setRedirectType(urlRegisterRequest.getRedirectType());
		urls.setAccount(accountRepository.findOne(accountId));
		
		urls = urlsRepository.save(urls);
		
		urls.setShortUrl(UrlCutterUtility.encodeBase62(urls.getId()));
		response.setShortUrl(urls.getShortUrl());
		urlsRepository.save(urls);
		
		
		return response;
	}

}
