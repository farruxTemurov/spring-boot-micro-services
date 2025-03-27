package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Account;
import com.service.AccountService;

@RestController
@RequestMapping("account") // http://localhost:8383/account/*
public class AccountController { // // http://localhost:8383/transaction/*

	@Autowired
	AccountService accountService;

	// http://localhost:8383/account/create

	@PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String createAccount(@RequestBody Account account) {
		return accountService.createAccount(account);
	}

	// http://localhost:8383/account/findBalance/1122
	@GetMapping(value = "findBalance/{accno}")
	public String findBalance(@PathVariable("accno") int accnumber) {
		return accountService.findBalance(accnumber);
	}

	// http://localhost:8383/account/withdraw

	// json data : {"accno":1122,"amount":500}
	@PutMapping(value = "withdraw", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String withdrawAmount(@RequestBody Account account) {
		return accountService.withdrawn(account);
	}

	// http://localhost:8383/account/deposit
	// json data : {"accno":1122,"amount":500}
	@PutMapping(value = "deposit", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String depositeAmount(@RequestBody Account account) {
		return accountService.deposit(account);
	}

	// http://localhost:8383/account/findAccountNumber/steven@gmail.com 1122
	@GetMapping(value = "findAccountNumber/{emailid}")
	public Integer findAccountNumber(@PathVariable("emailid") String emailid) {
		return accountService.findAccountNumber(emailid);
	}
}