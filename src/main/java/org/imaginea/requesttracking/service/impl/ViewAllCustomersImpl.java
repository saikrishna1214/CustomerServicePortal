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

	public Account CreateAccount(String name, String emailid, String address1, String address2, String city,String state) {
		Account account = new Account();
		account.setName(name);
		account.setEmailid(emailid);
		account.setAddress1(address1);
		account.setAddress2(address2);
		account.setCity(city);
		account.setState(state);
		accountdao.createAccount(account);
		return account;
	}
	
	

}
