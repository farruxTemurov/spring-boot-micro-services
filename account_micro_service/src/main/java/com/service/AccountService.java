package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Account;
import com.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepository;

	public String createAccount(Account account) {
		Optional<Account> result = accountRepository.findById(account.getAccno());
		if (result.isPresent()) {
			return "Account number must be unique";
		} else {
			accountRepository.save(account);
			return "Account created successfully";
		}
	}

	public String findBalance(int accno) {
		Optional<Account> result = accountRepository.findById(accno); // passing account number
		if (result.isPresent()) {
			Account account = result.get(); // account object holds that account details.
			return "Your balance amount is " + account.getAmount();
		} else {
			return "Account doesn't exist with number" + accno;
		}
	}

	public String withdrawn(Account account) { // which contains accno and amount
		Optional<Account> result = accountRepository.findById(account.getAccno()); // passing account number
		if (result.isPresent()) {
			Account existsAccount = result.get();
			float oldAmount = existsAccount.getAmount();
			float updateNewAmount = oldAmount - account.getAmount();
			if (updateNewAmount < 0) {
				return "Insufficient amount, can't withdraw";
			} else {
				existsAccount.setAmount(updateNewAmount);
				accountRepository.saveAndFlush(existsAccount);
				return "Amount withdrawn successfully";
			}
		} else {
			return "Account doesn't exist";
		}
	}

	public String deposit(Account account) {

		Optional<Account> result = accountRepository.findById(account.getAccno()); // passing account number
		if (result.isPresent()) {
			Account existsAccount = result.get();
			float oldAmount = existsAccount.getAmount();
			float updateNewAmount = oldAmount + account.getAmount();
			existsAccount.setAmount(updateNewAmount);
			accountRepository.saveAndFlush(existsAccount);
			return "Amount deposited successfully";
		} else {
			return "Account doesn't exist";
		}
	}

	public int findAccountNumber(String emailid) {
		try {
			return accountRepository.findAccountNumber(emailid);
		} catch (Exception e) {
			System.err.println(e);
			return -1;
		}
	}
}