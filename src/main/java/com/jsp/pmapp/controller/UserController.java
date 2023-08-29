package com.jsp.pmapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.pmapp.dto.Login;
import com.jsp.pmapp.dto.User;
import com.jsp.pmapp.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class UserController {
	@Autowired
	UserService service;

	@PostMapping("/users")
	public User saveUser(@RequestBody User user) {
		return service.saveUser(user);
	}

	@PutMapping("/users")
	public User updateUser(@RequestBody User user) {
		return service.updateUser(user);
	}

	@DeleteMapping("/users/{id}")
	public User deleteUser(@PathVariable int id) {
		return service.deleteUser(id);
	}

	@GetMapping("/users/{id}")
	public User getByUserId(@PathVariable int id) {
		return service.getByUserId(id);
	}

	@GetMapping("/users")
	public List<User> getByUserAll() {
		return service.getByUserAll();
	}

	@PostMapping("users/login")
	public User loginUser(@RequestBody Login login) {
		return service.valiadateUser(login);
	}
}
