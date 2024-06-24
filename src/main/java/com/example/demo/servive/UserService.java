package com.example.demo.servive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User findUserByPublicId(String publicId) {
		
		User user = userRepository.findByPublicId(publicId);
		
		if (user == null) {
			throw new UserNotFoundException(publicId);
		}
		
		return user;
	}
	
	public void saveUser(User user) {
		userRepository.save(user);
	}
	
	

}
