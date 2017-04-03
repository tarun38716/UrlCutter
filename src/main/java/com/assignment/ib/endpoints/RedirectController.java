package com.assignment.ib.endpoints;

import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.ib.entities.Urls;
import com.assignment.ib.exception.UrlCutterException;
import com.assignment.ib.service.RedirectService;
import com.assignment.ib.util.UrlCutterUtility;

/**
 * @author Tarun
 *
 */
@RestController
public class RedirectController {
	
	@Autowired
	@Qualifier("RedirectService")
	private RedirectService redirectService;
	
	@GetMapping("/redirect/{shortUrl}")
	public ResponseEntity<?> redirectUrl(HttpServletResponse response, @PathVariable String shortUrl) throws URISyntaxException{
		Urls url = null;
		HttpHeaders httpHeaders = new HttpHeaders();
		try{
			url = redirectService.incrementCount(shortUrl);
			URI longUrl = new URI(url.getLongUrl());
			httpHeaders.setLocation(longUrl);
		} catch(UrlCutterException ex) {
			return UrlCutterUtility.exceptionResponseBuilder(ex);
		} 
		if(url.getRedirectType() == 302)
		return new ResponseEntity<>(httpHeaders, HttpStatus.FOUND);
		
		return new ResponseEntity<>(httpHeaders, HttpStatus.MOVED_PERMANENTLY);
	}

}
