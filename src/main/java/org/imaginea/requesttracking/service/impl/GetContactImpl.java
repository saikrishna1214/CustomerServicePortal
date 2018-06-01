package org.imaginea.requesttracking.service.impl;

import org.imaginea.requesttracking.dao.AccountDao;
import org.imaginea.requesttracking.entity.Account;
import org.imaginea.requesttracking.service.GetContact;
import org.springframework.beans.factory.annotation.Autowired;

public class GetContactImpl implements GetContact {
	
	@Autowired
	private AccountDao accountdao;

	public Account getContactDetails(int accountid) {
		
		Account account = accountdao.getAccount(accountid);
		return account;
	}

}
