<%@page import="org.imaginea.requesttracking.entity.Account"%>
<%@page import="org.imaginea.requesttracking.entity.Contact"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="ServiceRequest.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="header">
		<h2 style="color: white">Customer Service Portal</h2>
	</div>
	<div class="nav">
		<p>
			<b> Services </b>
		</p>
		<ul>
			<li><a
				href="http://localhost:8080/servicerequestassignment/ViewCustomers.jsp">Viewcustomers</a></li>
			<li><a>CreatecustomerAccount</a></li>
			<li><a>ViewServiceRequests</a></li>
		</ul>
	</div>
	<div class="center">
		<h3>Service Request Creation</h3>
		<%
			int accountid = Integer.parseInt(request.getParameter("accountId"));
			int contactid = Integer.parseInt(request.getParameter("contactId"));
		%>
		<form name="create" method="POST" action="ServiceRequest">
			<table>
				<tr>
					<td align="right">Account Id :</td>
					<td><input name="accountid" type="text" value="<%=accountid%>"></td>
				</tr>
				<tr>
					<td align="right">Name :</td>
					<td><input name="name" type="text"
						value="<%=request.getParameter("name")%>"></td>
				</tr>
				<tr>
					<td align="right">Contact Id :</td>
					<td><input name="contactid" type="text" value="<%=contactid%>"></td>
				</tr>
				<tr>
					<td align="right">Title :</td>
					<td><input name="title" type="text" value=""></td>
				</tr>
				<tr>
					<td align="right">Description :</td>
					<td><input name="description" type="text" value=""></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="submit"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>