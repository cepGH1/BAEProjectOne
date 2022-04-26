package com.qa.main.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  //indicates that this is a rest controller
@CrossOrigin     //indicates that external http requests are accepted
@RequestMapping("/Thing") 	//all requests are prefixed by User (like the database table)
public class ThingController {

}
