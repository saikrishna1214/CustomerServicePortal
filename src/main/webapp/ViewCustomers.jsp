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
	<div class="col-sm-1"></div>
	<div class="col-sm-10">
		<ul class="nav navbar-nav">
			<li class="active1" onclick="callViewCustomers()"><a
				style="color: white;" href="#">View Customers</a></li>
			<li><a style="color: white;"
				href="http://localhost:8080/servicerequestassignment/CreateCustomerAccount.jsp">Create
					Account</a></li>
			<li onclick="callServiceRequest()"><a style="color: white;"
				href="#">View Service Requests</a></li>
			<li onclick="callActivity()"><a style="color: white;" href="#">View
					Activity</a></li>
		</ul>
	</div>
	<div class="col-sm-1"></div>
	</nav>
	<div class="center">
		<h3>Customer Accounts</h3>
		<form action='CreateServiceRequest.jsp' method="post">
			<table id="accountstable" class="table table-hover table-striped">
				<thead style="background-color: rgb(40, 50, 100); color: white;">
					<tr>
						<td>AccountId</td>
						<td>Name</td>
						<td>City</td>
						<td>Email</td>
						<td>Contact</td>
					</tr>
				</thead>
				<tbody>
					<%
						for (Account account : accounts) {
							Collection<Contact> contacts = account.getContact();
					%>

					<tr id="account<%=account.getAccountid()%>">
						<td class="accountid"><%=account.getAccountid()%></td>
						<td class="name"><%=account.getName()%></td>
						<td><%=account.getCity()%></td>
						<td><%=account.getEmailid()%></td>
						<td><input type="button" value="view contacts"
							id="showcontacts<%=account.getAccountid()%>"
							onclick="showContacts(<%=account.getAccountid()%>)"></td>
					</tr>
					<tr style="display: none" id="<%=account.getAccountid()%>">
						<td colspan="5">
							<table style="margin: 0px;" class="table">
								<thead>
									<tr>
										<td>Select Contact</td>
										<td>contactId</td>
										<td>phone</td>
										<td>first name</td>
										<td>last name</td>
									</tr>
								</thead>
								<tbody>
									<form>
										<%
											for (Contact contact : contacts) {
										%>

										<tr id="contact<%=contact.getContactid()%>">
											<td><input type="radio"
												value="<%=contact.getContactid()%>" name="optradio"></td>
											<td><%=contact.getContactid()%></td>
											<td><%=contact.getPhone()%></td>
											<td><%=contact.getFirstname()%></td>
											<td><%=contact.getLastname()%></td>
										</tr>
										<%
											}
										%>
										<tr>
											<td colspan="2" style="text-align: right;"><input
												type="button" value="generate issue"
												onclick="generateIssue(<%=account.getAccountid()%>)"></td>
											<td colspan="3"><button type="button"
													data-toggle="modal" data-target="#myModal">Add New
													Contact</button> <!-- Modal -->
												<div class="modal fade" id="myModal" role="dialog">
													<div class="modal-dialog">
														<!-- Modal content-->
														<div class="modal-content">
															<div class="modal-header">
																<button type="button" class="close" data-dismiss="modal">&times;</button>
																<h4 class="modal-title">Contact Info</h4>
															</div>
															<div class="modal-body">
																<img class="contactimage" alt="*" src="user1a.png">
																<div class="jumbotron">
																<div class="form-horizontal">
																<label>First Name </label>
																<input class="form-control" type="text">
																<label>Last Name </label>
																<input class="form-control" type="text">
																<label>Phone </label>
																<input class="form-control" type="number"><br>
																</div></div>
																<button type="button" class="btn btn-success">Submit</button>
																</div>
														</div>
													</div>
												</div></td>
										</tr>
									</form>
								</tbody>
							</table>
						</td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</form>
	</div>
	<script>
		function showContacts(id) {
			if(document.getElementById("showcontacts"+id).value=="view contacts")
				{
					var table = document.getElementById(id);
					table.style.display = "table-row";
					document.getElementById("showcontacts"+id).value="hide contacts";
				}
			else
				{
				document.getElementById(id).style.display = "none";
				document.getElementById("showcontacts"+id).value="view contacts";
				}
		}

		function generateIssue(accountinfo) {
				var accountrow = document.getElementById("account"+accountinfo);
				var accountcells = accountrow.getElementsByTagName("td");
				var accountid = accountcells[0].innerText;
				var name = accountcells[1].innerText;
				var radiovalue = $("input:radio[name='optradio']:checked").val();
				var contactrow = document.getElementById("contact"+radiovalue);
				var contactcells = contactrow.getElementsByTagName("td");
				var contactid = contactcells[1].innerText;
				var param = "?accountId=" + accountid + "&name=" + name +"&contactId=" + contactid;	
				window.open("http://localhost:8080/servicerequestassignment/CreateServiceRequest.jsp"+param,"_parent")
		 }
		
		function callViewCustomers() {
			document.location.href="ViewCustomers";
		}
		
		function modalDisplay(id) {
			
			var modal = document.getElementById('myModal');
			modal.style.display="block";
		}
	</script>
</body>
</html>