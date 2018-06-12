package org.imaginea.requesttracking.service;

import java.util.List;

import org.imaginea.requesttracking.entity.Account;

public interface ViewAllCustomers {
	
	public List<Account> getAllCustomers();

	public Account CreateAccount(String emailid, String gender ,String lastname,String firstname);
	
	public Account CreateAccount(int accountid);
}
