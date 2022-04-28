package com.qa.main.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.qa.main.domain.Thing;

import com.qa.main.repo.ThingRepo;


@Service
public class ThingService {
	// the repository used by this service
	private ThingRepo repo;

	//constructor
	public ThingService(ThingRepo repo) {
		super();
		this.repo = repo;
	}
	
	
	
	public ThingRepo getRepo() {
		return repo;
	}



	public void setRepo(ThingRepo repo) {
		this.repo = repo;
	}



	//to get a single entry from the database table using the id written long hand to remind me this is an optional
	public Thing getById(long id) {
		Optional<Thing> thingOptional = this.repo.findById(id);
		if(thingOptional.isPresent()) {
			Thing thing = thingOptional.get();
			return thing;
		} else {
			throw new EntityNotFoundException("no entry with this id: " + id);
		}
	}
	
		//for returning all the entries on the table user
		public List<Thing> getAll(){
			return repo.findAll();
		}
	
		//to add a user to the table
		public Thing create( Thing thing){
			return repo.saveAndFlush(thing); //save and flush to clean the stream, everything happens immediately
		}
		
		//to modify a thing in the table
		public Thing update(Long id, Thing thing) {
			Thing existing = repo.findById(id).get();
			existing.setName(thing.getName());
			existing.setDescription(thing.getDescription());
			existing.setPriority(thing.getPriority());
		
			return repo.saveAndFlush(existing);
		}
		
		//to delete an entry to the Thing table and return true if no longer in the database
		public boolean delete(long id) {
			
			repo.deleteById(id);
			return !repo.existsById(id);
			
		}
}
