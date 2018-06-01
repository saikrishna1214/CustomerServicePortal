package org.imaginea.requesttracking.dao.impl;

import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.imaginea.requesttracking.dao.AccountDao;
import org.imaginea.requesttracking.entity.Account;
import org.imaginea.requesttracking.util.SessionUtils;
import org.springframework.stereotype.Repository;

/**
 * creates Account object and save the Account details in 
 * tables by using Session class.
 * returns an object which maps with given primary key in
 *  the table.
 * @author saikrishnak
 *
 */

@Repository("accountDaoImpl")
public class AccountDaoImpl implements AccountDao{
	
	/**
	 * creates object of account type and places given
	 * data in Account table
	 * @param account will have details of account entity.
	 */
	
	public void createAccount(Account account)
	{
		Session session = SessionUtils.getSession();
		session.beginTransaction();
		session.save(account);
		session.getTransaction().commit();
		SessionUtils.closeSession(session);
	}
	
	/**
	 * gives account object which maps a row in Account
	 * table in database by Account id. 
	 * @param id has account id to map with required row.
	 * @return Account object of given id 
	 */
	
	public Account getAccount(int id)
	{
		Session session = SessionUtils.getSession();
		session.beginTransaction();
		Account acnt = (Account)session.get(Account.class,id);
		return acnt; 
	}

	public List<Account> getAllAccounts() {
		Session session = SessionUtils.getSession();
		session.beginTransaction();
		List<Account> accounts = session.createQuery("from Account").list();
		return accounts;
	}
	
	
}
