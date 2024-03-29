package com.in28minutes.rest.webservice.resfullwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.usertype.UserType;
import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private int userCount=3;
	private static List<User> users= new ArrayList();
	
	static {
		users.add(new User(1,"Bibhu1",new Date()));
		users.add(new User(2,"Bibhu2",new Date()));
		users.add(new User(3,"Bibhu3",new Date()));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User saveUser(User user) {
		if(user.getId()==null) {
			user.setId(++userCount);
		}
		users.add(user);
		
		return user;
	}
	
	
	public User findOne(int id) {
		for(User user:users) {
			if(user.getId()==id) {
				return user;
			}
		}
		return null;
	}
	
	public User deleteByID(int id) {
		
		Iterator<User> iterator=users.iterator();
		while (iterator.hasNext()) {
	       User user=iterator.next();  
	       if(user.getId()==id) {
	    	   iterator.remove();
				return user;
			}
		}
		return null;
	}
	
	

}
