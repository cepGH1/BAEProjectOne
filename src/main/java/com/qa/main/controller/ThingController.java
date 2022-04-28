package com.qa.main.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.main.domain.Thing;
import com.qa.main.service.ThingService;





@RestController  //indicates that this is a rest controller
@CrossOrigin     //indicates that external http requests are accepted
@RequestMapping("/Thing") 	//all requests are prefixed by User (like the database table)
public class ThingController {

	private ThingService service;

	public ThingController(ThingService service) {
		super();
		this.service = service;
	}
	
	//Get for a quick test
		@GetMapping("/hello") //localhost:8080/User/hello
		public String helloWorld() {
			return "project runs";
		}
	
	// get entry by Id
		@GetMapping("/getById/{id}")
		public ResponseEntity<Thing> getById(@PathVariable long id){
			return new ResponseEntity<Thing>( service.getById(id), HttpStatus.OK);
		}
	//get all the entries in the table
		@GetMapping("/getAll")
		public ResponseEntity<List<Thing>> getAll(){
			return  new ResponseEntity<List<Thing>>(service.getAll(), HttpStatus.OK);
		}
		
		//create a new entry in the table
		@PostMapping("/create") //localhost:8080/Thing/create
		public ResponseEntity<Thing> create(@RequestBody Thing thing){
			return new ResponseEntity<Thing>( service.create(thing), HttpStatus.CREATED);
		}
		
		//modify an entry in the table
		@PutMapping("/update/{id}")
		public ResponseEntity<Thing> update(@PathVariable long id, @RequestBody Thing thing ){
			return new ResponseEntity<Thing>(service.update(id, thing), HttpStatus.ACCEPTED);
		}
		
		//delete an entry in the table
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<?> delete(@PathVariable long id) {
			//ternary if statement
			return (this.service.delete(id))? new ResponseEntity<>(HttpStatus.NO_CONTENT): new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			
			}
			
		
		
	
}
