package com.learning.bootRestTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultHandler;

@SpringBootTest
@AutoConfigureMockMvc
class SpringBootRestTestApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void whenTestApp_thenEmptyResponse() throws Exception {
		
		this.mockMvc.perform(get("/foos")).andExpect(status().is(HttpStatus.NOT_FOUND.value()))
			.andDo(new ResultHandler() {
				
				@Override
				public void handle(MvcResult result) throws Exception {
					
					System.out.println("This is fucked.");
				}
			});
	}
	
	@Test
	public void testFirstApiCall() throws Exception {
		
		this.mockMvc.perform(get("/first/comeGetMe")).andExpect(status().is(HttpStatus.OK.value()))
			.andDo(new ResultHandler() {
				
				@Override
				public void handle(MvcResult result) throws Exception {
					
					System.out.println(result.getResponse().getContentAsString());
				}
			});
	}
}
