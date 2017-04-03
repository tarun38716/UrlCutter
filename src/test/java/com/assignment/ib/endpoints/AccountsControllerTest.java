package com.assignment.ib.endpoints;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.assignment.ib.exception.UrlCutterException;
import com.assignment.ib.response.AccountResponse;
import com.assignment.ib.service.AccountService;

/**
 * @author Tarun
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class AccountsControllerTest {
	
	@InjectMocks
	private AccountsController accountsController = new AccountsController();
	
	@Mock
	private AccountService accountService;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(accountsController).build();
	}
	
	@Test
	public void testSaveAccount() throws Exception{
		AccountResponse response = new AccountResponse();
		when(accountService.saveAccount(anyString())).thenReturn(response);
		mockMvc.perform(post("/account").contentType(MediaType.APPLICATION_JSON_VALUE).content("{\"AccountId\" : \"testAccount\"}")).andExpect(status().isOk());
	}
	
	@Test
	public void testSaveAccountWrongID() throws Exception{
		AccountResponse response = new AccountResponse();
		when(accountService.saveAccount(anyString())).thenReturn(response);
		mockMvc.perform(post("/account").contentType(MediaType.APPLICATION_JSON_VALUE).content("{\"AccountId\" : \"\"}")).andExpect(status().isBadRequest());
	}
	
	@Test
	public void testSaveAccountInternalError() throws Exception{
		when(accountService.saveAccount(anyString())).thenThrow(new UrlCutterException());
		mockMvc.perform(post("/account").contentType(MediaType.APPLICATION_JSON_VALUE).content("{\"AccountId\" : \"testAccount\"}")).andExpect(status().isInternalServerError());
	}
	
	@Test
	public void testFetchStats() throws Exception{
		when(accountService.fetchStats(anyString())).thenReturn(new HashMap<String, Long>());
		mockMvc.perform(get("/statistic/testAccount")).andExpect(status().isOk());
	}
	
	@Test
	public void testFetchStatsException() throws Exception{
		when(accountService.fetchStats(anyString())).thenThrow(new UrlCutterException());
		mockMvc.perform(get("/statistic/testAccount")).andExpect(status().isInternalServerError());
	}
}
