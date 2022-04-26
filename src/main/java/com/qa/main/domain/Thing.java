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
	
	@Column 
	private String priority;
	
	//constructors
	
	public Thing() {
		super();
	}

	public Thing(String name, String description, String priority) {
		super();
		this.name = name;
		this.description = description;
		this.priority = priority;
	}

	public Thing(long id, String name, String description, String priority) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.priority = priority;
	}
	
	//getters and setters

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}
	
	
	
	
}
