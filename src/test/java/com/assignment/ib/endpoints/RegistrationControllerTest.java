package com.assignment.ib.endpoints;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.assignment.ib.entities.Urls;
import com.assignment.ib.request.UrlRegisterRequest;
import com.assignment.ib.response.UrlRegisterResponse;
import com.assignment.ib.service.RegistrationService;

/**
 * @author Tarun
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class RegistrationControllerTest {
	
	@InjectMocks
	RegistrationController registrationController = new RegistrationController();

	@Mock
	private RegistrationService registrationService;
	
	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(registrationController).build();
	}
	
	
	@Test
	public void testRegisterUrl() throws Exception{
		Urls url = new Urls();
		url.setLongUrl("www.google.com");
		when(registrationService.registerUrl((UrlRegisterRequest)anyObject(),anyString())).thenReturn(new UrlRegisterResponse());
		mockMvc.perform(post("/register").header("Authorization", "Basic c3Vhcjp4YUU1QUVuUQ==").contentType(MediaType.APPLICATION_JSON_VALUE).content("{\"url\":\"http://www.fcfsdsddsdsdffdfdfefook.com/\",\"redirectType\" : 301}")).andExpect(status().isOk());
	}
}
