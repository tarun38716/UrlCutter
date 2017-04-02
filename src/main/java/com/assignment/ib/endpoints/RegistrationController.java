package com.assignment.ib.endpoints;

import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.ib.request.UrlRegisterRequest;
import com.assignment.ib.response.UrlRegisterResponse;
import com.assignment.ib.service.RegistrationService;

@RestController
public class RegistrationController {
	
	@Autowired
	@Qualifier("RegistrationService")
	private RegistrationService registrationService;
	

	@PostMapping("/register")
	public ResponseEntity<?> registerUrl(@Valid @RequestBody UrlRegisterRequest urlRegisterRequest){
		UrlRegisterResponse response = registrationService.registerUrl(urlRegisterRequest, "suar");
		return new ResponseEntity<UrlRegisterResponse>(response,HttpStatus.OK);
	}


	@GetMapping("/redirect")
	public ResponseEntity<Object> redirectUrl(HttpServletResponse response) throws URISyntaxException{
		URI fb = new URI("http://www.facebook.com");
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(fb);
		return new ResponseEntity<>(httpHeaders, HttpStatus.FOUND);
	}

}
