<%@page import="org.imaginea.requesttracking.entity.Account"%>
<%@page import="org.imaginea.requesttracking.entity.Contact"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
	if(request.getSession().getAttribute("email")==null)
	{
		response.sendRedirect("login.jsp");
	}
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="ServiceRequest.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Customer Accounts</title>
</head>
<body>
	<div class="header">
		<h2 style="color: white;">Customer Service Portal</h2>
	</div>
	<nav class="nav1 navbar navbar-default">
	<ul class="nav navbar-nav">
		<li><a style="color: white;"
			href="http://localhost:8080/servicerequestassignment/LoginRedirect">Home</a></li>
		<li onclick="callViewCustomers()" class="active1"><a
			style="color: white;" href="#">View Customers</a></li>
		<li><a style="color: white;"
			href="http://localhost:8080/servicerequestassignment/CreateCustomerAccount.jsp">Create
				Account</a></li>
		<li onclick="callServiceRequests()"><a style="color: white;"
			href="#">View Service Requests</a></li>
	</ul>
	<ul class="nav navbar-nav navbar-right">
		<li onclick="logout()"><a
			style="color: white !important; margin-right: 5px;" href="#"><span
				class="glyphicon glyphicon-log-out"></span> Logout</a></li>
	</ul>
	</nav>
	<%
		int accountid, contactid;
		String name;
		if (request.getParameter("accountid") != null) {
			accountid = Integer.parseInt(request.getParameter("accountid"));
			String key = request.getParameter("optradio");
			contactid = Integer.parseInt(key);
			name = request.getParameter("firstname") + " " + request.getParameter("lastname");
		} else {
			accountid = (Integer) (request.getSession().getAttribute("accountId"));
			contactid = (Integer) (request.getSession().getAttribute("contactId"));
			name = (String) request.getSession().getAttribute("Name");
		}
	%>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6 offset-md-3 text-center">
				<div class="jumbotron">
					<div>
						<h3>Service Request</h3>
					</div>
					<form method="POST" action="ServiceRequest">
						<div class="form-group row">
							<span class="col-sm-3">Account Id</span>
							<div class="col-sm-9">
								<input class="form-control" name="accountid" type="number"
									value="<%=accountid%>" >
							</div>
						</div>
						<div class="form-group row">
							<span class="col-sm-3">Contact Id</span>
							<div class="col-sm-9">
								<input class="form-control" name="contactid" type="text"
									value="<%=contactid%>">
							</div>
						</div>
						<div class="form-group row">
							<span class="col-sm-3">Title</span>
							<div class="col-sm-9">
								<input class="form-control" name="title" type="text" value=" ">
							</div>
						</div>
						<div class="form-group row">
							<span class="col-sm-3">Description</span>
							<div class="col-sm-9">
								<input class="form-control" name="description" type="text"
									value=" ">
							</div>
						</div>
						<div class="text-center">
							<input type="submit" class="btn btn-primary" value="submit">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function callViewCustomers() {
			document.location.href = "ViewCustomers";
		}
		function logout() {
			document.location.href = "Logout";
		}
		function callServiceRequests() {
			document.location.href = "ViewServiceRequests";
		}
	</script>
</body>
</html>