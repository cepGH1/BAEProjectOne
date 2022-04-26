package com.qa.main.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Thing {
	// private attributes of the entity will the schema table columns
	
	// primary key of table, id value
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	//database table column must have a value 
		@Column( nullable = false)
		private String name;
		
	@Column
	private String description;
	
	//constructors
	
	public Thing() {
		super();
	}

	public Thing(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public Thing(long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	
	
}
