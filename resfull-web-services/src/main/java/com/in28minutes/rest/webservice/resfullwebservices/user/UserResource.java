package com.in28minutes.rest.webservice.resfullwebservices.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition;

@RestController
public class UserResource {
	@Autowired
	private UserDaoService userDaoService;
	// find all user

	@GetMapping("/users")
	public List<User> retriveAllusers() {
		return userDaoService.findAll();

	}

	// find user by id
	@GetMapping("/users/{id}")
	public Resource retriveUSer(@PathVariable int id) {
		User user=userDaoService.findOne(id);
       if(user==null)
    	   throw new UserNotFoundException("ID-"+id);
       
       //Heatoes
       Resource<User> resource=new Resource<User>(user);
       ControllerLinkBuilder linkTo=ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).retriveAllusers());
       resource.add(linkTo.withRel("all-users"));
       return resource;
		
	}
	
	// delete user by id
		@DeleteMapping("/users/{id}")
		public void removeUSer(@PathVariable int id) {
			User user=userDaoService.deleteByID(id);
	       if(user==null)
	    	   throw new UserNotFoundException("ID-"+id);
		}


	// create a user
	@PostMapping("/users")
	public ResponseEntity<Object> saveUser(@Valid @RequestBody User user) {
		User users = userDaoService.saveUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(users.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}

}
