package org.imaginea.requesttracking.service.impl;

import java.util.List;

import org.imaginea.requesttracking.dao.AccountDao;
import org.imaginea.requesttracking.entity.Account;
import org.imaginea.requesttracking.service.ViewAllCustomers;
import org.springframework.beans.factory.annotation.Autowired;

public class ViewAllCustomersImpl implements ViewAllCustomers {

	@Autowired
	private AccountDao accountdao;
	
	public List<Account> getAllCustomers() {
		return accountdao.getAllAccounts();
	}

	public Account CreateAccount( String emailid, String gender ,String firstname,String lastname) {
		Account account = new Account();
		account.setEmailid(emailid);
		account.setFirstname(firstname);
		account.setLastname(lastname);
		account.setGender(gender);
		accountdao.createAccount(account);
		return account;
	}
	
	public Account GetAccount(int accountid) {
		return accountdao.getAccount(accountid);
	}

}
