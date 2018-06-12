<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="ServiceRequest.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
		<li onclick="callViewCustomers()"><a style="color: white;"
			href="#">View Customers</a></li>
		<li><a style="color: white;" class="active1"
			href="http://localhost:8080/servicerequestassignment/CreateCustomerAccount.jsp">Create
				Account</a></li>
		<li onclick="callServiceRequests()"><a style="color: white;"
			href="#">View Service Requests</a></li>
	</ul>
	<ul class="nav navbar-nav navbar-right">
		<li><a style="color: white !important; margin-right: 5px;"
			href="#"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
	</ul>
	</nav>
	<h3 class="text-center">Account Creation</h3>
	<div class="container">
		<div class="jumbotron">
			<form style="align-items: center;" action="CreateAccount"
				method="post">
				<div class="row">
					<div class="col-sm-6">
						<h4 class="text-center">Account Details</h4>
						<div class="form-group row">
							<span class="col-sm-3">First Name</span>
							<div class="col-sm-9">
								<input name="firstname" type="text" class="form-control" />
							</div>
						</div>
						<div class="form-group row">
							<span class="col-sm-3">Last Name</span>
							<div class="col-sm-9">
								<input name="lastname" type="text" class="form-control" />
							</div>
						</div>
						<div class="form-group row">
							<span class="col-sm-3">Email id</span>
							<div class="col-sm-9">
								<input name="emailid" type="email" class="form-control" />
							</div>
						</div>
						<div class="form-check row">
							<span class="col-sm-3">Gender</span>
							<div class="col-sm-9">
								<input name="gender" type="radio" value="Male"
									class="form-check-input" /> <label class="form-check-label">Male</label>
								<input name="gender" value="Female" type="radio"
									class="form-check-input" /> <label class="form-check-label">Female</label>
							</div>
						</div>
					</div>
					<div class="col-sm-6" style="border-left: 1px dashed black;">
						<h4 class="text-center">Contact Details</h4>
						<div class="form-group row">
							<span class="col-sm-2">Phone</span>
							<div class="col-sm-10">
								<input name="phone" type="number" class="form-control" />
							</div>
						</div>
						<div class="form-group row">
							<span class="col-sm-2">Address1</span>
							<div class="col-sm-10">
								<input name="address1" type="text" class="form-control" />
							</div>
						</div>
						<div class="form-group row">
							<span class="col-sm-2">Address2</span>
							<div class="col-sm-10">
								<input name="address2" type="text" class="form-control" />
							</div>
						</div>
						<div class="form-group row">
							<span class="col-sm-2">City</span>
							<div class="col-sm-10">
								<input name="city" type="text" class="form-control" />
							</div>
						</div>
						<div class="form-group row">
							<span class="col-sm-2">State</span>
							<div class="col-sm-10">
								<input name="state" type="text" class="form-control" />
							</div>
						</div>
						<div class="form-group row">
							<span class="col-sm-2">Zipcode</span>
							<div class="col-sm-10">
								<input name="zipcode" type="number" class="form-control" />
							</div>
						</div>
					</div>
				</div>
				<div class="text-center">
					<input type="submit" value="submit" class="btn btn-primary" />
				</div>
			</form>
		</div>
	</div>

	<script type="text/javascript">
		function callViewCustomers() {
			document.location.href = "ViewCustomers";
		}
		function callServiceRequests() {
			document.location.href = "ViewServiceRequests";
		}
	</script>
</body>
</html>