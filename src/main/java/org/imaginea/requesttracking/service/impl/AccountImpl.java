package org.imaginea.requesttracking.service.impl;

import org.imaginea.requesttracking.dao.impl.AccountDaoImpl;
import org.imaginea.requesttracking.entity.Account;
import org.imaginea.requesttracking.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 
 * @author saikrishnak
 *
 */
@Service (value="accountservice")
public class AccountImpl implements AccountService {

	@Autowired
	private AccountDaoImpl accountdao;
	
	public void createAccount() {
		
		Account account1 = new Account();
		account1.setAccountid(1234);
		account1.setName("abc");
		account1.setCity("Hyderabad");
		accountdao.createAccount(account1);
		
		Account account2 = new Account();
		account2.setAccountid(1235);
		account2.setName("xyz");
		account2.setCity("visakhapatnam");
		accountdao.createAccount(account2);
		
		Account account3 = new Account();
		account3.setAccountid(1236);
		account3.setName("pqr");
		account3.setCity("vijayawada");
		accountdao.createAccount(account3);
	}

}
