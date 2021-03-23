package com.cg.onlineshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineshopping.entities.User;
import com.cg.onlineshopping.repository.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginRepository loginRepo;
	@Override
	public User addUser(User user) {
		loginRepo.save(user);
		return user;
	}

	@Override
	public User removeUser(User user) {
		loginRepo.delete(user);
		return user;
	}

	@Override
	public User validateUser(User user) {
		
		return loginRepo.findValidateUser(user.getUserId(),user.getPassword());
	}

	@Override
	public User signOut(User user) {
		return null;
	}

}
