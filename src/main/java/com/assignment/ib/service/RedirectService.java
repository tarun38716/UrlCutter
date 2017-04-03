package com.assignment.ib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.assignment.ib.entities.Urls;
import com.assignment.ib.exception.UrlCutterException;
import com.assignment.ib.repositories.UrlsRepository;
import com.assignment.ib.util.UrlCutterUtility;

/**
 * @author Tarun
 *
 */
@Service("RedirectService")
public class RedirectService {
	
	@Autowired
	@Qualifier("UrlsRepository")
	private UrlsRepository urlsRepository;
	
	public Urls incrementCount(String shortUrl) throws UrlCutterException{
		Urls urls = null;
		try{
			long urlId = UrlCutterUtility.decodeBase10(shortUrl);
			urls = urlsRepository.findOne((int)urlId);
			urls.setCount(urls.getCount() + 1);
			urlsRepository.save(urls);
		} catch(Exception e){
			throw new UrlCutterException(e, "Internal Error Occured. Please try again later");
		}
		return urls;
	}
}
