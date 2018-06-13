<%@page import="org.imaginea.requesttracking.entity.Activities"%>
<%@page import="org.imaginea.requesttracking.entity.ServiceRequest"%>
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
<title>Home</title>
</head>
<body>
	<div class="header">
		<h2 style="color: white;">Customer Service Portal</h2>
	</div>
	<nav class="nav1 navbar navbar-default">
	<ul class="nav navbar-nav">
		<li class="active1"><a style="color: white;"
			href="http://localhost:8080/servicerequestassignment/LoginRedirect">Home</a></li>
		<li onclick="callViewCustomers()"><a style="color: white;"
			href="#">View Customers</a></li>
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
	<div>
		<% Collection<ServiceRequest> servicerequests = (Collection<ServiceRequest>)request.getSession().getAttribute("servicerequest");
	if(servicerequests.isEmpty())
	{
	%>
		<div class="text-center">No Service Requests to display</div>
		<% 
	}
	else{
	%>
		<div class="center">
			<h3>Recent Service Requests</h3>
			<div class="accordion" id="accord"></div>
			<table id="servicerequesttable"
				class="table table-hover table-striped">
				<thead style="background-color: rgb(40, 50, 100); color: white;">
					<tr>
						<td>ServiceId</td>
						<td>Name</td>
						<td>Email</td>
						<td>OpenDate</td>
						<td>title</td>
						<td>Status</td>
						<td>Description</td>
						<td>View/Hide Activity</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td colspan="9">
							<div class="collapse"></div>
						</td>
					</tr>
					<%
					for (ServiceRequest servicerequest : servicerequests) {
						Collection<Activities> activities = servicerequest.getActivity();
				%>

					<tr id="service<%=servicerequest.getSrnumber()%>">
						<td><%=servicerequest.getSrnumber()%></td>
						<td id="name<%=servicerequest.getSrnumber()%>"><%=servicerequest.getAccount().getFirstname()%></td>
						<td id="emailid<%=servicerequest.getSrnumber()%>"><%=servicerequest.getAccount().getEmailid()%></td>
						<td id="opendate<%=servicerequest.getSrnumber()%>"><%=servicerequest.getOpendate() %></td>
						<td id="title<%=servicerequest.getSrnumber()%>"><%=servicerequest.getTitle()%></td>
						<td id="status<%=servicerequest.getSrnumber()%>"><%=servicerequest.getStatus()%></td>
						<td id="description<%=servicerequest.getSrnumber()%>"><%=servicerequest.getDescription()%></td>
						<td align="center"><button data-toggle="collapse"
								data-target=".s<%=servicerequest.getSrnumber()%>"
								id="eye<%=servicerequest.getSrnumber()%>" value="view activity"
								type="button"
								onclick="buttonToggle(<%=servicerequest.getSrnumber()%>)">
								<span class="glyphicon glyphicon-eye-open"></span>
							</button></td>
					</tr>
					<tr style="overflow: hidden;">
						<td colspan="9">
							<div class="collapse s<%=servicerequest.getSrnumber()%>"
								data-parent="#accord">
								<div class="card card-body">
									<table style="margin: 0"
										class="table table-hover table-striped">
										<thead>
											<tr>
												<td>Activity Id</td>
												<td>Last Updated Date</td>
												<td>Description</td>
												<td>Status</td>
											</tr>
										</thead>
										<%
										for (Activities activity : activities) {
									%>
										<tbody>
											<tr>
												<td><%=activity.getActivityid()%></td>
												<td><%=activity.getUpdateddate()%></td>
												<td><%=activity.getUpdatedDescription()%></td>
												<td><%=activity.getStatusUpdate()%></td>
											</tr>
										</tbody>
										<%
										}
									%>
									</table>
								</div>
							</div>
						</td>
					</tr>
					<%
					}
				%>
				</tbody>
			</table>
			
			</div>
		</div>
		<%
	   }
	%>
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