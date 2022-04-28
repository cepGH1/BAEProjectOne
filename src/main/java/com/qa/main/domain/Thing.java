package com.qa.main.domain;

import java.util.Objects;

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

	@Override
	public String toString() {
		return "Thing [id=" + id + ", name=" + name + ", description=" + description + ", priority=" + priority + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, id, name, priority);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Thing other = (Thing) obj;
		return Objects.equals(description, other.description) && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(priority, other.priority);
	}
	
	
	
	
}
