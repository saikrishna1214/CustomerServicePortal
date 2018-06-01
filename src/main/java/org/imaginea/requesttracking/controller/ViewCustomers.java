package org.imaginea.requesttracking.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.imaginea.requesttracking.entity.Account;
import org.imaginea.requesttracking.service.ViewAllCustomers;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ViewCustomers extends HttpServlet {
	private static final long serialVersionUID = 1L;



	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
		ViewAllCustomers allcustomers = (ViewAllCustomers) context.getBean("viewallcustomers");
		List<Account> accounts = allcustomers.getAllCustomers();
		req.getSession().setAttribute("accounts", accounts);
		resp.sendRedirect("ViewCustomers.jsp");
	}
	
}
