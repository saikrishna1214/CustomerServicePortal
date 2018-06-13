<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>Service Requests</title>
</head>

<body>
	<div class="header">
		<h2 style="color: white;">Customer Service Portal</h2>
	</div>
	<nav class="nav1 navbar navbar-default">
	<ul class="nav navbar-nav">
		<li><a style="color: white;"
			href="http://localhost:8080/servicerequestassignment/LoginRedirect">Home</a></li>
		<li onclick="callViewCustomers()"><a style="color: white;"
			href="#">View Customers</a></li>
		<li><a style="color: white;"
			href="http://localhost:8080/servicerequestassignment/CreateCustomerAccount.jsp">Create
				Account</a></li>
		<li class="active1" onclick="callServiceRequests()"><a
			style="color: white;" href="#">View Service Requests</a></li>
	</ul>
	<ul class="nav navbar-nav navbar-right">
		<li onclick="logout()"><a
			style="color: white !important; margin-right: 5px;" href="#"><span
				class="glyphicon glyphicon-log-out"></span> Logout</a></li>
	</ul>
	</nav>
	<!-- service request form -->
	<form action="">
		<div class="row">
			<!-- divides form into two parts -->
			<div class="col-sm-6">
				<div class="form-group row">
					<span class="col-sm-2 col-form-label">Name</span>
					<div class="col-sm-10">
						<input type="text" class="form-control"
							value="<%=request.getParameter("name")%>">
					</div>
				</div>
				<div class="form-group row">
					<span class="col-sm-2 col-form-label">Email Id</span>
					<div class="col-sm-10">
						<input type="email" class="form-control"
							value="<%=request.getParameter("email")%>">
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>