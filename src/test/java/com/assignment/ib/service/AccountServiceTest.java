package com.assignment.ib.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.assignment.ib.exception.UrlCutterException;
import com.assignment.ib.repositories.AccountRepository;
import com.assignment.ib.repositories.UrlsRepository;
import com.assignment.ib.response.AccountResponse;

/**
 * @author Tarun
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {
	
	@InjectMocks
	private AccountService accountService = new AccountService();
	
	@Mock
    private AccountRepository accountRepository;
	
	@Mock
	private UrlsRepository urlsRepository;
	
	@Test
	public void testSaveAccountIfAccountExists() throws UrlCutterException{
		when(accountRepository.exists(anyString())).thenReturn(true);
		AccountResponse response = accountService.saveAccount("accountId");
		assertNotNull(response);
		assertTrue(StringUtils.equals("false", response.getSuccess()));
	}
	
	@Test
	public void testSaveAccountSuccess() throws UrlCutterException{
		when(accountRepository.exists(anyString())).thenReturn(false);
		AccountResponse response = accountService.saveAccount("accountId");
		assertNotNull(response);
		assertTrue(StringUtils.equals("true", response.getSuccess()));
	}
	
	@Test(expected=UrlCutterException.class)
	public void testSaveAccountException() throws UrlCutterException{
		when(accountRepository.exists(anyString())).thenThrow(new RuntimeException());
		accountService.saveAccount("accountId");
	}
	
	@Test(expected=UrlCutterException.class)
	public void testFetchStatsException() throws UrlCutterException{
		when(urlsRepository.getUrlStats(anyString())).thenReturn(null);
		accountService.fetchStats("accountId");
	}
	
	@Test
	public void testFetchStatsSuccess() throws UrlCutterException{
		List<Object[]> result = new ArrayList<Object[]>();
		when(urlsRepository.getUrlStats(anyString())).thenReturn(result);
		assertNotNull(accountService.fetchStats("accountId"));
	}
}
