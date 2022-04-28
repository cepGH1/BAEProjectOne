package com.qa.main.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ThingTest {

	@Test
	public void constructorTest() {
		Thing thing = new Thing();
		assertThat(thing instanceof Thing);
	}
	
	//don't need to test generated code, but if I had written my own constructors...
	@Test
	public void constructorTest2() {
		Thing thing = new Thing("kid", "green army", "low");
		assertThat(thing instanceof Thing);
	}
}
