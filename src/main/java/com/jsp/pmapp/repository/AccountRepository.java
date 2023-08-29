package com.jsp.pmapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.pmapp.dto.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{

}
