package com.jsp.pmapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.pmapp.dto.Login;
import com.jsp.pmapp.dto.User;
import com.jsp.pmapp.repository.UserRepository;

@Repository
public class UserDao {
	@Autowired
	UserRepository repository;
	public User saveUser(User user) {
	return	repository.save(user);
		
	}
    public User updateUser(User user) {
    	Optional<User> optional=repository.findById(user.getId());
    	if(optional.isPresent()) {
    	return	repository.save(user);
    	}
    	return optional.get();
    }
    public User deleteUser(int id) {
    	Optional<User> optional=repository.findById(id);
    	if(optional.isPresent()) {
    		repository.delete(optional.get());
    	}
    	return optional.get();
    }
    public User getByUserId(int id) {
       	Optional<User> optional=repository.findById(id);
       	return optional.get();
    }
    public List<User> getByUserAll(){
    return	repository.findAll();
    }
    public User validateUser(Login login) {
    	return repository.validateUser(login.getEmail(), login.getPassword());
    }
    
}
