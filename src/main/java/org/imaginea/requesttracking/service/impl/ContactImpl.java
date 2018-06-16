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
	@Autowired
	private AccountDaoImpl accountdao;

	public Contact createContact(int phone, String address1,String address2,String state ,String city,int Zipcode, Account account) {
		
		Contact contact  = new Contact();
		contact.setPhone(phone);
		contact.setAddress1(address1);
		contact.setAddress2(address2);
		contact.setCity(city);
		contact.setState(state);               
		contact.setZipcode(Zipcode);
		contact.setAccount(account);
		account.getContact().add(contact);
		return(contactdao.createContactDao(contact));
		
	}


	
	

}
