package org.imaginea.requesttracking.service;

import java.util.List;

import org.imaginea.requesttracking.entity.Account;

public interface ViewAllCustomers {
	
	public List<Account> getAllCustomers();

	public Account CreateAccount(String name,String emailid,String address1,String address2,String city,String state);
}
