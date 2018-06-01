package org.imaginea.requesttracking.dao;

import java.util.Collection;
import java.util.List;

import org.imaginea.requesttracking.entity.Account;

public interface AccountDao {
	
	public void createAccount(Account account);
	
	public Account getAccount(int id);
	
	public List<Account> getAllAccounts();

}
