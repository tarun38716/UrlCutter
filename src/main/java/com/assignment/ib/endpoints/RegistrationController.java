package com.assignment.ib.endpoints;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.ib.exception.UrlCutterException;
import com.assignment.ib.request.UrlRegisterRequest;
import com.assignment.ib.response.UrlRegisterResponse;
import com.assignment.ib.service.RegistrationService;
import com.assignment.ib.util.UrlCutterUtility;

/**
 * @author Tarun
 *
 */
@RestController
public class RegistrationController {
	
	@Autowired
	@Qualifier("RegistrationService")
	private RegistrationService registrationService;
	

	@PostMapping("/register")
	public ResponseEntity<?> registerUrl(@Valid @RequestBody UrlRegisterRequest urlRegisterRequest, HttpServletRequest request){
		UrlRegisterResponse response;
		try {
			String accountId = UrlCutterUtility.getAccountIdfromHeader(request);
			response = registrationService.registerUrl(urlRegisterRequest, accountId);
		} catch (UrlCutterException e) {
			return UrlCutterUtility.exceptionResponseBuilder(e);
		}
		return new ResponseEntity<UrlRegisterResponse>(response,HttpStatus.OK);
	}
}
