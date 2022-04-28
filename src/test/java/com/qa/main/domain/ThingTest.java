package com.qa.main.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ThingTest {

	@Test
	public void constructorTest() {
		Thing thing = new Thing();
		assert(thing instanceof Thing);
	}
	
	//don't need to test generated code, but if I had written my own constructors...
	@Test
	public void constructorTest2() {
		Thing thing = new Thing("kid", "green army", "low");
		assert(thing instanceof Thing);
	}
}
