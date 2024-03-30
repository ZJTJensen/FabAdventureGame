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
    	return userService.doesUserExist(message.getSlug());
    }

	@PostMapping("/create")
	public boolean createAccount(@RequestBody UsersRequest message) {
    	return userService.creteUser(message.getPhone(), message.getDeck());
    }

	@PostMapping("/card")
	public boolean addCard(@RequestBody UsersRequest message) {
    	return userService.addCardToUserDeck(message.getCard());
    }
	@PostMapping("/usersInBracket")
	public boolean getUsersInBracket(@RequestBody UsersRequest message) {
    	return userService.getUsersInBracket(message.getSlug());
    }

}
