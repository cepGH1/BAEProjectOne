package com.qa.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.main.domain.Thing;
import com.qa.main.repo.ThingRepo;

@SpringBootTest
public class ThingServiceUnitTest {
	
	

		@Autowired
		private ThingService service;
		
		@MockBean
		private ThingRepo repo;
		
		
		@Test
		public void constructorTest() {
			assert(service instanceof ThingService);
		}
		
		@Test
		public void setRepoTest() {
			assert(service.getRepo().equals(repo));
		}
		
		@Test
		public void getAllTest() {
			List<Thing> output = new ArrayList<>();
			output.add(new Thing("kid", "green army", "low"));
			
			Mockito.when(this.repo.findAll()).thenReturn(output);
			
			assert(output == this.service.getAll());
			
			Mockito.verify(this.repo, Mockito.times(1)).findAll();
		}
		
		@Test
		public void getByIdTest() {
			Optional<Thing> OptionalOutput = Optional.of(new Thing(1L, "kid", "green army", "low"));
			Thing output = new Thing(1L, "kid", "green army", "low");
			
			Mockito.when(this.repo.findById(1L)).thenReturn(OptionalOutput);
			
			assert(output.equals( this.service.getById(1L)));
			
			Mockito.verify(this.repo, Mockito.times(1)).findById(1L);
		}
		
		@Test
		public void createTest() {
			Thing input = new Thing("kid", "green army", "low");
			Thing output = new Thing(1L, "kid", "green army", "low");
			
			Mockito.when(this.repo.saveAndFlush(input)).thenReturn(output);
			
			assert(output == this.service.create(input));
			
			Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(input);
		}
		
		@Test
		public void updateTest() {
			Thing input = new Thing("kid", "green army", "low");
			Optional<Thing> existing = Optional.of(new Thing(1L, "Jim", "Jones", "jjones1"));
			Thing output = new Thing(1L, "kid", "green army", "low");
			
			Mockito.when(this.repo.findById(1L)).thenReturn(existing);
			Mockito.when(this.repo.saveAndFlush(output)).thenReturn(output);
			
			assert(output == this.service.update(1L, input));
			
			Mockito.verify(this.repo, Mockito.times(1)).findById(1L);
			Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(output);
		}
		
		@Test
		public void deleteTest() {
			Mockito.when(this.repo.existsById(1L)).thenReturn(false);
			
			assert(this.service.delete(1L) == true);
			
			Mockito.verify(this.repo, Mockito.times(1)).deleteById(1L);
			Mockito.verify(this.repo, Mockito.times(1)).existsById(1L);
		}
}

