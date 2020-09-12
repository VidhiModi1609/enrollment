package com.enroll.controller;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.enroll.model.Dependent;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DependentEndpointTest {
	public static final String POST_PATH = "/enrollment-api/dependent";
	public static final String UPDTE_PATH = "/enrollment-api/dependent";
	public static final String DELETE_PATH = "/enrollment-api/dependent/1";

	@Autowired
	private MockMvc mvc;

	@Test
	public void createDependent() throws Exception {
		Dependent dependentee = new Dependent();
		dependentee.setName("Sas");
		dependentee.setBirth_date(new Date());
		ObjectMapper mapper = new ObjectMapper();
		String dependentJson = mapper.writeValueAsString(dependentee);

		mvc.perform(MockMvcRequestBuilders.post(POST_PATH).contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(dependentJson)).andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void updateDependent() throws Exception {
		Dependent dependentee = new Dependent();
		dependentee.setName("Sas");
		dependentee.setBirth_date(new Date());
		ObjectMapper mapper = new ObjectMapper();
		String dependentJson = mapper.writeValueAsString(dependentee);

		mvc.perform(MockMvcRequestBuilders.put(UPDTE_PATH).contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(dependentJson)).andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void deleteDependent() throws Exception {

		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.delete(DELETE_PATH).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

		String content = mvcResult.getResponse().getContentAsString();
		assertNotNull(content);
	}
}
