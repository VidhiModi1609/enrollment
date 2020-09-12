package com.enroll.controller;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.enroll.model.Enrollee;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
public class EnrolleeEndpointTest {
	public static final String GET_PATH = "/enrollment-api/enrollees";
	public static final String POST_PATH = "/enrollment-api/enrollee";
	public static final String UPDTE_PATH = "/enrollment-api/enrollee";
	public static final String DELETE_PATH = "/enrollment-api/enrollee/1";

	@Autowired
	private MockMvc mvc;

	@Test
	public void getEnrollsList() throws Exception {

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(GET_PATH).accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

		String content = mvcResult.getResponse().getContentAsString();
		assertNotNull(content);
	}

	@Test
	public void createEnroll() throws Exception {
		Enrollee enrollee = new Enrollee();
		enrollee.setName("Rad");
		enrollee.setPhoneNumber("9908059344");
		enrollee.setBirth_date(new Date());
		ObjectMapper mapper = new ObjectMapper();
		String enrollJson = mapper.writeValueAsString(enrollee);

		mvc.perform(MockMvcRequestBuilders.post(POST_PATH)
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(enrollJson))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void updateEnroll() throws Exception {
		Enrollee enrollee = new Enrollee();
		enrollee.setName("Rad");
		enrollee.setPhoneNumber("9908059344");
		enrollee.setBirth_date(new Date());
		ObjectMapper mapper = new ObjectMapper();
		String enrollJson = mapper.writeValueAsString(enrollee);

		mvc.perform(MockMvcRequestBuilders.put(UPDTE_PATH)
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(enrollJson))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void deleteEnroll() throws Exception {
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(DELETE_PATH)
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

		String content = mvcResult.getResponse().getContentAsString();
		assertNotNull(content);
	}
}
