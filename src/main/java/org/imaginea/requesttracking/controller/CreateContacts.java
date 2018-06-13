package org.imaginea.requesttracking.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.imaginea.requesttracking.entity.Account;
import org.imaginea.requesttracking.entity.Contact;
import org.imaginea.requesttracking.service.ViewAllCustomers;
import org.imaginea.requesttracking.service.impl.ContactImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sun.java.swing.plaf.windows.resources.windows;

/**
 * Servlet implementation class CreateContacts
 */
public class CreateContacts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
		ViewAllCustomers allcustomers = (ViewAllCustomers) context.getBean("viewallcustomers");
		ContactImpl contacts = (ContactImpl) context.getBean("createcontact");
		/*PrintWriter out = response.getWriter();
		out.println(request.getParameter("accountid"));*/
		int accountid = Integer.parseInt(request.getParameter("accountid"));
		String name = request.getParameter("firstname")+" "+request.getParameter("lastname");
		Account account =  allcustomers.GetAccount(accountid);
		String address1 = (String) request.getParameter("address1");
		String address2 = (String) request.getParameter("address2");
		String city = (String) request.getParameter("city");
		String state = (String) request.getParameter("state");
		int zipcode =  Integer.parseInt(request.getParameter("zipcode"));
		int phone = Integer.parseInt((String) request.getParameter("phone"));
		Contact contact =  contacts.createContact(phone, address1, address2, city, state, zipcode, account);
		int contactid = contact.getContactid();
		request.getSession().setAttribute("Name", name);
		request.getSession().setAttribute("accountId",accountid);
		request.getSession().setAttribute("contactId",contactid);
		response.sendRedirect("CreateServiceRequest.jsp");
	}

}
