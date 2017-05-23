package com.social.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.social.backend.DAO.BlogDAO;


@RestController
public class BlogController {

	@Autowired
	private BlogDAO blogdao;
	
	
		
		
	
}
