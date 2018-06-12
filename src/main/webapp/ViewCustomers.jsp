
<%@page import="org.imaginea.requesttracking.entity.Contact"%>
<%@page import="org.imaginea.requesttracking.service.ViewAllCustomers"%>
<%@page import="java.util.List"%>
<%@page import="org.imaginea.requesttracking.entity.Account"%>
<%@page import="java.util.Collection"%>
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
<title>Customer Accounts</title>
</head>

<body>
	<%
		List<Account> accounts = (List<Account>) request.getSession().getAttribute("accounts");
	%>
	<div class="header">
		<h2 style="color: white;">Customer Service Portal</h2>
	</div>
	<nav class="nav1 navbar navbar-default">
	<ul class="nav navbar-nav">
		<li><a style="color: white;"
			href="http://localhost:8080/servicerequestassignment/LoginRedirect">Home</a></li>
		<li class="active1" onclick="callViewCustomers()"><a
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
	<div class="center">
		<h3>Customer Accounts</h3>
		<form action='CreateServiceRequest.jsp' method="post">
			<table id="accountstable" class="table table-hover table-striped">
				<thead style="background-color: rgb(40, 50, 100); color: white;">
					<tr>
						<td>AccountId</td>
						<td>FirstName</td>
						<td>LastName</td>
						<td>Email</td>
						<td>Gender</td>
						<td>Contact</td>
					</tr>
				</thead>
				<tbody>
					<%
						for (Account account : accounts) {
							Collection<Contact> contacts = account.getContact();
					%>

					<tr>
						<td><%=account.getAccountid()%></td>
						<td id="firstname<%=account.getAccountid()%>"><%=account.getFirstname()%></td>
						<td id="lastname<%=account.getAccountid()%>"><%=account.getLastname()%></td>
						<td id="emailid<%=account.getAccountid()%>"><%=account.getEmailid()%></td>
						<td id="gender<%=account.getAccountid()%>"><%=account.getGender() %></td>
						<td><button data-target="#<%=account.getAccountid()%>"
								type="button" data-toggle="collapse">
								<span class="glyphicon glyphicon-eye-open"></span>
							</button></td>
					</tr>
					<tr>
						<td colspan="6">
							<div class="collapse" id="<%=account.getAccountid()%>">
								<table style="margin: 0; text-align: center;" class="table">
									<thead>
										<tr>
											<td>AccountId</td>
											<td>contactId</td>
											<td>phone</td>
											<td>Address1</td>
											<td>Address2</td>
											<td>City</td>
											<td>State</td>
											<td>ZipCode</td>
											<td>Generate Issue</td>
										</tr>
									</thead>
									<tbody>
										<%
											for (Contact contact : contacts) {
										%>

										<tr>
											<td id="account<%=contact.getContactid()%>"><%=account.getAccountid()%></td>
											<td><%=contact.getContactid()%></td>
											<td id="phone<%=contact.getContactid()%>"><%=contact.getPhone()%></td>
											<td id="address1<%=contact.getContactid()%>"><%=contact.getAddress1()%></td>
											<td id="address2<%=contact.getContactid()%>"><%=contact.getAddress2()%></td>
											<td id="city<%=contact.getContactid()%>"><%=contact.getCity()%></td>
											<td id="state<%=contact.getContactid()%>"><%=contact.getState()%></td>
											<td id="zipcode<%=contact.getContactid()%>"><%=contact.getZipcode()%></td>
											<td><button type="button"
													data-id="<%=contact.getContactid()%>" data-toggle="modal"
													data-target="#myModal">
													<span class="glyphicon glyphicon-plus-sign"></span>
												</button></td>
										</tr>
										<%
											}
										%>
										<tr>
											<td colspan="9"><button type="button" data-id="<%=account.getAccountid() %>"
													data-toggle="modal" data-target="#myContactModal">Add
													New Contact</button>
										</tr>
									</tbody>
								</table>
							</div>
						</td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</form>
		<div class="modal fade bd-example-modal-lg" id="myModal" role="dialog">
			<div class="modal-dialog modal-lg">

				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Service Request</h4>
					</div>
					<div class="modal-body">
						<div class="jumbotron">
							<form action="ServiceRequest" method="post">
								<div class="row">
									<div class="col-sm-6">
										<div class="form-group row">
											<span class="col-sm-3">Account Id</span>
											<div class="col-sm-9">
												<input name="accountid" type="number" id="serviceaccountid"
													class="form-control" readonly />
											</div>
										</div>
										<div class="form-group row">
											<span class="col-sm-3">Name</span>
											<div class="col-sm-9">
												<input name="name" id="servicename" type="text"
													class="form-control" readonly/>
											</div>
										</div>
										<div class="form-group row">
											<span class="col-sm-3">Email id</span>
											<div class="col-sm-9">
												<input name="emailid" id="serviceemailid" type="email"
													class="form-control" readonly/>
											</div>
										</div>
									</div>
									<div class="col-sm-6" style="border-left: 1px dashed black;">

										<div class="form-group row">
											<span class="col-sm-2">Contact Id</span>
											<div class="col-sm-10">
												<input name="contactid" id="servicecontactid" type="text"
													class="form-control" readonly/>
											</div>
										</div>
										<div class="form-group row">
											<span class="col-sm-2">Title</span>
											<div class="col-sm-10">
												<input name="title" id="title" type="text"
													class="form-control" />
											</div>
										</div>
										<div class="form-group row">
											<span class="col-sm-2">Description</span>
											<div class="col-sm-10">
												<input name="description" type="text" class="form-control" />
											</div>
										</div>
									</div>
								</div>
						</div>
						<button type="submit" class="btn btn-success">Generate
							Issue</button>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div class="modal fade bd-example-modal-lg" id="myContactModal"
			role="dialog">
			<div class="modal-dialog modal-lg">

				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Contact Info</h4>
					</div>
					<div class="modal-body">
						<img class="contactimage" alt="*" src="user1a.png">
						<div class="jumbotron">
							<form action="CreateContacts" method="post">
								<div class="row">
									<div class="col-sm-6">
										<div class="form-group row">
											<span class="col-sm-3">Account Id</span>
											<div class="col-sm-9">
												<input name="accountid" type="number" id="contactaccountid"
													class="form-control" readonly />
											</div>
										</div>
										<div class="form-group row">
											<span class="col-sm-3">Phone</span>
											<div class="col-sm-9">
												<input name="phone" id="phone" type="number"
													class="form-control" />
											</div>
										</div>
										<div class="form-group row">
											<span class="col-sm-3">Address1</span>
											<div class="col-sm-9">
												<input name="address1" id="address1" type="text"
													class="form-control" />
											</div>
										</div>
										<div class="form-group row">
											<span class="col-sm-3">Address2</span>
											<div class="col-sm-9">
												<input name="address2" id="address2" type="text"
													class="form-control" />
											</div>
										</div>
									</div>
									<div class="col-sm-6" style="border-left: 1px dashed black;">

										<div class="form-group row">
											<span class="col-sm-2">City</span>
											<div class="col-sm-10">
												<input name="city" id="city" type="text"
													class="form-control" />
											</div>
										</div>
										<div class="form-group row">
											<span class="col-sm-2">State</span>
											<div class="col-sm-10">
												<input name="state" id="state" type="text"
													class="form-control" />
											</div>
										</div>
										<div class="form-group row">
											<span class="col-sm-2">ZipCode</span>
											<div class="col-sm-10">
												<input name="zipcode" id="zipcode" type="number" class="form-control" />
											</div>
										</div>
									</div>
								</div>
								<button type="submit" class="btn btn-success">Add Contact</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		
		
		$("#myModal").on('show.bs.modal',function(e) {
							var getRow = $(e.relatedTarget).data('id');
							var a = document.getElementById('account' + getRow).innerHTML;
							$("#serviceaccountid").val(document.getElementById('account'+getRow).innerHTML);
							$("#servicename").val(document.getElementById('firstname'+a).innerHTML);
							$("#serviceemailid").val(document.getElementById('emailid'+a).innerHTML);
							$("#servicecontactid").val(getRow);
						});
		$("#myContactModal").on('show.bs.modal',function(e){
			var getRow = $(e.relatedTarget).data('id');
			$("#contactaccountid").val(getRow);
		});

		function callViewCustomers() {
			document.location.href = "ViewCustomers";
		}
		function callServiceRequests() {
			document.location.href = "ViewServiceRequests";
		}
		function modalDisplay(id) {

			var modal = document.getElementById('myModal');
			modal.style.display = "block";
		}
	</script>
</body>
</html>

