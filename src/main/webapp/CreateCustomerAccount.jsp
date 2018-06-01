<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="ServiceRequest.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="header">
		<h2 style="color: white">Customer Service Portal</h2>
	</div>
	<div class="nav">
		<ul>
			<li><a
				href="http://localhost:8080/servicerequestassignment/ViewCustomers.jsp">Viewcustomers</a></li>
			<li><a>CreatecustomerAccount</a></li>
			<li><a>ViewServiceRequests</a></li>
		</ul>
	</div>
	<div class="center">
		<h3>Service Request Creation</h3>
		<form action="CreateAccount" method="post">
			<div class="container">
				<div class="row">
					<div class="col-sm-6">
						<div class="container">
							<div class="jumbotron">
								Name :<input name="name" type="text" value=" " /><br>
								Email id:<input name="emailid" type="text" value=" " /><br>
								Address1 :<input name="address1" type="text" value=" " /><br>
								Address2 :<input name="address2" type="text" value=" " /><br>
								city :<input name="city" type="text" value=" " /><br>
								State :<input name="state" type="text" value=" " /><br>
								Zipcode :<input name="zipcode" type="text" value=" " /><br>
							</div>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="container">
							<div class="jumbotron">
								Last Name : <input name="lastname" type="text" value=" " /><br>
								First Name : <input name="firstname" type="text" value=" " /><br>
								Phone :<input name="phone" type="text" value=" " /><br>
							</div>
						</div>
					</div>
				</div>
			</div>
			<input type="submit" value="submit" />
		</form>
	</div>
</body>
</html>