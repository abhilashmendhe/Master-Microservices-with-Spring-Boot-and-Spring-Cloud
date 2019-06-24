package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.rest.webservices.restfulwebservices.exception.UserNotFoundException;

@RestController
public class UserResource {

	@Autowired
	private UserDAO service;
	
	@GetMapping(value = "/users")
	public List<User> retrieveAllUsers()
	{
		return service.findAll();
	}
	
	@GetMapping(value = "/users/{id}")
	public User retrieveUser(@PathVariable int id)
	{
		User u = service.findOne(id);
		if(u==null)
		{
			throw new UserNotFoundException("id-"+id);
		}
		return u;
	}
	
	@PostMapping(value = "/users")
	public ResponseEntity<Object> createUser(@RequestBody User user)
	{
		User savedUser = service.save(user);
		
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(savedUser.getId())
			.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	
	
}
