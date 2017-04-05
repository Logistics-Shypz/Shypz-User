package com.shypz.shypzuser.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@RequestMapping("/hello")
	public String getHello(){
		return "hello";
	}

}
