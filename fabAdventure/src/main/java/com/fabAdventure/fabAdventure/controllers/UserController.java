package com.fabAdventure.fabAdventure.controllers;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabAdventure.fabAdventure.service.UserService;
import com.fabAdventure.models.UsersRequest;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")

public class UserController {
	private UserService userService;
    @PostMapping("/fetch")
	public boolean fetchAccount(@RequestBody UsersRequest message) {
    	return userService.doesUserExist(message.getUser());
    }

	@PostMapping("/create")
	public String createAccount(@RequestBody UsersRequest message) {
    	System.out.println("Connecting to backend!!");
    	System.out.println("Message was: " + message.getUser());
		String message2 = "Connected to backend!";
		return message2;
    }

	@PostMapping("/card")
	public String addCard(@RequestBody UsersRequest message) {
    	System.out.println("Connecting to backend!!");
    	System.out.println("Message was: " + message.getUser());
		String message2 = "Connected to backend!";
		return message2;
    }

}
