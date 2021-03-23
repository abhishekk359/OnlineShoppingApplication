package com.cg.onlineshopping.service;

import com.cg.onlineshopping.entities.User;

public interface LoginService {

	public User addUser(User user);
	
	public User removeUser(User user);
	
	public User validateUser(User user);
	
	public User signOut(User user);
}
