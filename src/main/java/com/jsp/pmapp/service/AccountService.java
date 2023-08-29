package com.jsp.pmapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.pmapp.dao.AccountDao;
import com.jsp.pmapp.dao.UserDao;
import com.jsp.pmapp.dto.Account;
import com.jsp.pmapp.dto.User;
import com.jsp.pmapp.repository.AccountRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class AccountService {
	@Autowired
	AccountDao dao;
	@Autowired
	UserDao dao2;
	
	public Account saveAccount(Account account,int id) {
		if(account !=null && id>0) {
//			
			String str="";
			User user = dao2.getByUserId(id);
			for(int i=0;i<user.getName().length();i++) {
				if(i<=3) {
					str+=user.getName().charAt(i);
				}
			}
			str=str+1000+user.getId();
			account.setAccNo(str);
			account.setIntAmt(account.getAmount());
			account.setUser(user);
			Account account2= dao.saveAccount(account);

			return account2;
		}
		return null;
	}
	public Account updateAccount(Account account,int id) {
		if(account!=null) {
			User user=dao2.getByUserId(id);
			account.setUser(user);
			account.setIntAmt(account.getAmount());
			return dao.updateAccount(account);
		}
		
		return null ;
	
	}
  public Account deleteAccount(int id) {
	  
	  return dao.deleteAccount(id);
  }
  public Account getAccountByid(int id) {
	 
	  return dao.getAccountByid(id);
  }
  public List<Account> getAccountByAll (){
	  return dao.getAccountByAll();
  }
  public Account sendAmount(int id,double amt) {
	  if(amt>0) {
		  Account account=dao.getAccountByid(id);
		  if(account!=null) {
			  double amount=account.getAmount();
			  if(amount>amt) {
				  amount-=amt;
			  account.setAmount(amount);
			  return dao.updateAccount(account);
			  }
			  return null;
		  }
	  }
	  return null;
  }
  public Account RAmount(int id,double amt) {
	  if(amt>0) {
		  Account account=dao.getAccountByid(id);
		  if(account!=null) {
			  double amount=account.getAmount()+amt;
			  account.setAmount(amount);
			  return dao.updateAccount(account);
			  
		  }
	  }
	  return null;
  }
  public Account displayAccount(int id) {
	  
	  return dao.getAccountByid(id);
  }
}
