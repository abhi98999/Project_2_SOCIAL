package com.social.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.social.backend.model.User;
import com.social.backend.DAO.UserDAO;
@RestController
public class UserController {
	
	@Autowired
	UserDAO userdao;
	
	@RequestMapping("/hello")
	public String hello()
	{
		return "test rest controller";
		
	}
	
	
	@RequestMapping(value="/adduser",method=RequestMethod.POST)
	public ResponseEntity<User> createUser(@RequestBody User user)
	{
		System.out.print("restcontroller createuser");
		
		if(userdao.addUser(user))
			System.out.print("create user success"); 
			return new ResponseEntity<User> (user,HttpStatus.OK); 
	}
	
	
	
	
}
