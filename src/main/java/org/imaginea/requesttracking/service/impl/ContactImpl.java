package org.imaginea.requesttracking.service.impl;

import org.imaginea.requesttracking.dao.impl.AccountDaoImpl;
import org.imaginea.requesttracking.dao.impl.ContactDaoImpl;
import org.imaginea.requesttracking.entity.Account;
import org.imaginea.requesttracking.entity.Contact;
import org.imaginea.requesttracking.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class ContactImpl implements ContactService {
	
	@Autowired
	private ContactDaoImpl contactdao;


	public void createContact(String phone, String firstname, String lastname, Account account) {
		
		Contact contact  = new Contact();
		contact.setPhone(phone);
		contact.setAccount(account);
		contact.setFirstname(firstname);
		contact.setLastname(lastname);
		account.getContact().add(contact);
		contactdao.createContactDao(contact);
		
	}

}
