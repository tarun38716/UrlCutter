package com.assignment.ib.endpoints;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.assignment.ib.entities.Urls;
import com.assignment.ib.service.RedirectService;

/**
 * @author Tarun
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class RedirectControllerTest {

	@InjectMocks
	RedirectController redirectController = new RedirectController();

	@Mock
	private RedirectService redirectService;

	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(redirectController).build();
	}
	
	@Test
	public void testRedirectUrl() throws Exception{
		Urls url = new Urls();
		url.setLongUrl("www.google.com");
		when(redirectService.incrementCount(anyString())).thenReturn(url);
		mockMvc.perform(get("/redirect/shortUrl")).andExpect(status().is3xxRedirection());
	}

}
