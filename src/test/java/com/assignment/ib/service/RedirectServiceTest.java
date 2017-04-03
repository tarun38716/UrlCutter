package com.assignment.ib.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.assignment.ib.entities.Urls;
import com.assignment.ib.exception.UrlCutterException;
import com.assignment.ib.repositories.UrlsRepository;

/**
 * @author Tarun
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class RedirectServiceTest {
	
	@InjectMocks
	private RedirectService redirectService = new RedirectService();
	
	@Mock
	private UrlsRepository urlsRepository; 
	

	@Test
	public void testIncrementCount() throws UrlCutterException {
		Urls urls = new Urls();
		when(urlsRepository.findOne(anyInt())).thenReturn(urls);
		assertNotNull(redirectService.incrementCount("ab4C"));
	}
	
	@Test(expected=UrlCutterException.class)
	public void testIncrementCountException() throws UrlCutterException {
		when(urlsRepository.findOne(anyInt())).thenThrow(new RuntimeException());
		redirectService.incrementCount("ab4C");
	}

}
