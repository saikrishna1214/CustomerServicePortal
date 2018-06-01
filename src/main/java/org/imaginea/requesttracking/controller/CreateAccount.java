package org.imaginea.requesttracking.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.imaginea.requesttracking.entity.Account;
import org.imaginea.requesttracking.service.ViewAllCustomers;
import org.imaginea.requesttracking.service.impl.ContactImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Servlet implementation class CreateAccount
 */
public class CreateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
		ViewAllCustomers allcustomers = (ViewAllCustomers) context.getBean("viewallcustomers");
		ContactImpl contacts = (ContactImpl) context.getBean("createcontact");
		String name = (String) request.getParameter("name");
		String emailid = (String) request.getParameter("emailid");
		String address1 = (String) request.getParameter("address1");
		String address2 = (String) request.getParameter("address2");
		String city = (String) request.getParameter("city");
		String state = (String) request.getParameter("state");
		Account account =  allcustomers.CreateAccount(name, emailid, address1, address2, city, state);
		String phone = (String) request.getParameter("phone");
		String firstname = (String) request.getParameter("firstname");
		String lastname = (String) request.getParameter("lastname");
		contacts.createContact(phone, firstname, lastname, account);
	}

}
