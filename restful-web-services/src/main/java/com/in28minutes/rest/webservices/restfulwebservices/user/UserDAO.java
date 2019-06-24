package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDAO {

	private static List<User> users = new ArrayList<User>();
	
	private static int usercount = 3;
	static
	{
		users.add(new User(1,"Abhilash", new Date()));
		users.add(new User(2,"Shubham", new Date()));
		users.add(new User(3,"Nikhil", new Date()));
	}
	
	public List<User> findAll()
	{
		return users;
	}
	
	public User save(User user)
	{
		if(user.getId()==null)
		{
			user.setId(++usercount);
		}
		users.add(user);
		return user;
	}
	
	public User findOne(int id)
	{
		for(int i=0; i<users.size(); i++)
		{
			if(users.get(i).getId() == id)
			{
				return users.get(i);
			}
		}
		return null;
	}
	
	public User deleteById(int id)
	{
		for(int i=0; i<users.size(); i++)
		{
			User u = users.get(i);
			if(id==u.getId())
			{
				users.remove(u);
				return u;
			}
		}
		return u;
	}
}