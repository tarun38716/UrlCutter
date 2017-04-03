package com.assignment.ib.service;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.assignment.ib.entities.Urls;
import com.assignment.ib.exception.UrlCutterException;
import com.assignment.ib.repositories.AccountRepository;
import com.assignment.ib.repositories.UrlsRepository;
import com.assignment.ib.request.UrlRegisterRequest;
import com.assignment.ib.response.UrlRegisterResponse;
import com.assignment.ib.util.UrlCutterUtility;

/**
 * @author Tarun
 *
 */
@Service("RegistrationService")
public class RegistrationService {

	@Autowired
	@Qualifier("UrlsRepository")
	private UrlsRepository urlsRepository;

	@Autowired
	@Qualifier("AccountRepository")
	private AccountRepository accountRepository;

	@Value("${redirect.url}")
	private String redirectUrl;

	@Value("${server.port}")
	private String port;

	public UrlRegisterResponse registerUrl(UrlRegisterRequest urlRegisterRequest, String accountId) throws UrlCutterException{
		UrlRegisterResponse response = new UrlRegisterResponse();
		Urls urls = new Urls();
		try{
			urls.setLongUrl(urlRegisterRequest.getUrl());
			urls.setRedirectType(urlRegisterRequest.getRedirectType());
			urls.setAccount(accountRepository.findOne(accountId));
			urls = urlsRepository.save(urls);
			urls.setShortUrl(UrlCutterUtility.encodeBase62(urls.getId()));
			response.setShortUrl(ipPortAppender(port,redirectUrl)+urls.getShortUrl());
			urlsRepository.save(urls);
		} catch(DataIntegrityViolationException ex){
			throw new UrlCutterException(ex, "This URL is already Registered with us");
		} catch(Exception e){
			throw new UrlCutterException(e, "Internal Error Occured. Please try again later");
		}
		return response;
	}

	public static String ipPortAppender(String port, String redirectUrl) throws UnknownHostException{
		if(null!=port){
			port = "8080";
		}
		String server = InetAddress.getLocalHost().getHostAddress();
		return server+":"+port+redirectUrl;
	}

}
