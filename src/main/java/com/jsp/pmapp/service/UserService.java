package com.jsp.pmapp.service;

import java.net.http.HttpRequest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.pmapp.dao.UserDao;
import com.jsp.pmapp.dto.Login;
import com.jsp.pmapp.dto.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class UserService {
	@Autowired
	UserDao dao;
  public User saveUser(User user) {
	  
	  return dao.saveUser(user);
  }
  public User updateUser(User user) {
	  return dao.updateUser(user);
	  
  }
  public User deleteUser(int id) {
	  return dao.deleteUser(id);
  }
  public User getByUserId(int id) {
	  return dao.getByUserId(id);
  }
  public  List<User> getByUserAll(){
	  return dao.getByUserAll();
  }
  public User valiadateUser(Login login) {
	  
	 return dao.validateUser(login);
  }
}
