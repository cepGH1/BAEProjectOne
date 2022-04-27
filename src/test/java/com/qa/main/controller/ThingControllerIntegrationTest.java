package com.qa.main.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.main.domain.Thing;




@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:test_schema.sql", "classpath:test_data.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class ThingControllerIntegrationTest {
	@Autowired
	private MockMvc mvc;
	@Autowired
	private ObjectMapper mapper;
	
	
	// test getting a single item from the database
	@Test
	public void getByIdTest() throws Exception{
		Thing thing = new Thing(1L, "kid", "green army", "low");
		String stringOutput = mapper.writeValueAsString(thing);
		mvc.perform(get("/Thing/getById/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(content().json(stringOutput));
	}
	
	//test getting all the items from the thing table
	@Test
	public void getAllTest() throws Exception{
		Thing thing = new Thing(1L, "kid", "green army", "low");
		List<Thing> output = new ArrayList<>();
		output.add(thing);
		String stringOutput = mapper.writeValueAsString(output);	
		mvc.perform(get("/Thing/getAll").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(content().json(stringOutput));
		
	}
	
	//test the create method, make sure an item can be created in the test schema
	@Test
	public void createTest() throws Exception{
		Thing entry = new Thing("shoppingList", "bread, milk, butter", "high");
		String entryAsJSON = mapper.writeValueAsString(entry);
		
		Thing result = new Thing(2L, "shoppingList", "bread, milk, butter", "high");
		String resultAsJSON = mapper.writeValueAsString(result);
		
		mvc.perform(post("/Thing/create").contentType(MediaType.APPLICATION_JSON).content(entryAsJSON)).andExpect(status().isCreated()).andExpect(content().json(resultAsJSON));
		
	}
	
	//make sure that an entry in the test schema can be modified
	
	
	//make sure that an entry can be deleted from test schema
	@Test
	public void deleteTest() throws Exception {
		mvc.perform(delete("/Thing/delete/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNoContent());
	}
	
	//
}
