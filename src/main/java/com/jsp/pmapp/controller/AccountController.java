package com.jsp.pmapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.pmapp.dao.AccountDao;
import com.jsp.pmapp.dto.Account;
import com.jsp.pmapp.service.AccountService;

import jakarta.servlet.http.HttpSession;
@RestController
public class AccountController {
	@Autowired
	AccountService service;
	@PostMapping("/accounts/{id}")
	public Account saveAccount( @RequestBody Account account,@PathVariable int id) {
		return service.saveAccount(account,id);
	}
	@PutMapping("/accounts/{id}")
	public Account updateAccount(@RequestBody Account account,@PathVariable int id) {
		
		return service.updateAccount(account,id) ;
	
	}
	@DeleteMapping("/accounts/{id}")
  public Account deleteAccount(@PathVariable int id) {
	  
	  return service.deleteAccount(id);
  }
	@GetMapping("/accounts/{id}")
  public Account getAccountByid(@PathVariable int id) {
	 
	  return service.getAccountByid(id);
  }
	@GetMapping("/accounts")
  public List<Account> getAccountByAll (){
	  return service.getAccountByAll();
  }
	@PatchMapping("/accounts/send")
	public Account sendAmount(@RequestParam("id") int id, @RequestParam("amt") double amt) {
		return service.sendAmount(id, amt);
	}
   @PatchMapping("/accounts/receive")
   public  Account RaAmount(@RequestParam("id") int id, @RequestParam("amt") double amt) {
	   return service.RAmount(id, amt);
   }
   @GetMapping("/accounts/display/{id}")
   public Account displayAccount(@PathVariable int id ) {
	   return service.displayAccount(id);
   }
}
