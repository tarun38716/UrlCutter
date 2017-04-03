package com.assignment.ib.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.assignment.ib.entities.Account;
import com.assignment.ib.entities.Urls;
import com.assignment.ib.exception.UrlCutterException;
import com.assignment.ib.repositories.AccountRepository;
import com.assignment.ib.repositories.UrlsRepository;
import com.assignment.ib.request.UrlRegisterRequest;

/**
 * @author Tarun
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class RegistrationServiceTest {
	
	@InjectMocks
	private RegistrationService registrationService = new RegistrationService();
	
	@Mock
	private UrlsRepository urlsRepository;
	
	@Mock
	private AccountRepository accountRepository;
	
	@Before
	public void setUp() throws Exception {
		ReflectionTestUtils.setField(registrationService, "redirectUrl", "https://test.com");
		ReflectionTestUtils.setField(registrationService, "port", "8080");
	}

	@Test
	public void testRegisterUrl() throws UrlCutterException {
		Urls url = new Urls();
		url.setId(100005);
		UrlRegisterRequest urlRegisterRequest = new UrlRegisterRequest();
		urlRegisterRequest.setRedirectType(301);
		urlRegisterRequest.setUrl("www.testUrl.com");
		when(accountRepository.findOne(anyString())).thenReturn(new Account());
		when(urlsRepository.save((Urls)anyObject())).thenReturn(url);
		assertNotNull(registrationService.registerUrl(urlRegisterRequest, "testAccount"));
	}
	
	@Test(expected=UrlCutterException.class)
	public void testRegisterUrlException() throws UrlCutterException {
		Urls url = new Urls();
		url.setId(100005);
		UrlRegisterRequest urlRegisterRequest = new UrlRegisterRequest();
		urlRegisterRequest.setRedirectType(301);
		urlRegisterRequest.setUrl("www.testUrl.com");
		when(accountRepository.findOne(anyString())).thenReturn(new Account());
		when(urlsRepository.save((Urls)anyObject())).thenThrow(new RuntimeException());
		registrationService.registerUrl(urlRegisterRequest, "testAccount");
	}

}
