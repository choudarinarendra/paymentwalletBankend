package com.jsp.pmapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Account {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String accNo;
private double minBal;
private double intAmt;
private double amount;
private String password;

@OneToOne
@JoinColumn
@JsonIgnore
private User user;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public String getAccNo() {
	return accNo;
}
public void setAccNo(String accNo) {
	this.accNo = accNo;
}
public double getMinBal() {
	return minBal;
}
public void setMinBal(double minBal) {
	this.minBal = minBal;
}
public double getIntAmt() {
	return intAmt;
}
public void setIntAmt(double intAmt) {
	this.intAmt = intAmt;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}
