<%@page import="org.imaginea.requesttracking.entity.Activities"%>
<%@page import="org.imaginea.requesttracking.entity.ServiceRequest"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	if (request.getSession().getAttribute("email") == null) {
		response.sendRedirect("login.jsp");
	}
else{
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css">

<link rel="stylesheet" type="text/css" href="ServiceRequest.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Service Requests</title>
</head>

<body>
	<%
		Collection<ServiceRequest> servicerequests = (Collection<ServiceRequest>) request.getSession()
				.getAttribute("servicerequests");
	%>
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
	<div class="center">
		<h3>Service Requests</h3>
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
					<td>Edit</td>
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
					<td><button type="button" data-toggle="modal"
							data-id="<%=servicerequest.getSrnumber()%>"
							data-target="#myModal">
							<span class="glyphicon glyphicon-pencil"></span>
						</button>
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
								<table style="margin: 0" class="table table-hover table-striped">
									<thead>
										<tr>
											<td>Activity Id</td>
											<td>Last Updated Date</td>
											<td>Description</td>
											<td>Status</td>
											<td>Updated By</td>
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
											<td><%=activity.getUpdatedemployee() %></td>
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
		<div class="modal fade bd-example-modal-lg" id="myModal" role="dialog">
			<div class="modal-dialog modal-lg">

				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title text-center">Service Request</h4>
					</div>
					<div class="modal-body">
						<div class="jumbotron">
							<form action="UpdateServiceRequest" method="post"
								style="padding: 8px;">
								<div class="row">
									<div class="col-sm-6">
										<div class="form-group row">
											<span class="col-sm-3">Service Id</span>
											<div class="col-sm-9">
												<input name="serviceId" type="number" id="serviceid"
													class="form-control" />
											</div>
										</div>
										<div class="form-group row">
											<span class="col-sm-3">Name</span>
											<div class="col-sm-9">
												<input name="name" id="name" type="text"
													class="form-control" />
											</div>
										</div>
										<div class="form-group row">
											<span class="col-sm-3">Email id</span>
											<div class="col-sm-9">
												<input name="emailid" id="emailid" type="email"
													class="form-control" />
											</div>
										</div>
									</div>
									<div class="col-sm-6" style="border-left: 1px dashed black;">
										<div class="form-group row">
											<span class="col-sm-2">Title</span>
											<div class="col-sm-10">
												<input name="title" id="title" type="text"
													class="form-control" />
											</div>
										</div>
										<div class="form-group row">
											<span class="col-sm-2">Status</span>
											<div class="col-sm-10">
												<input name="status" type="text" class="form-control" />
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
								<div class="text-center">
									<input type="submit" value="Update" class="btn btn-primary" />
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		$('#myModal').on('show.bs.modal', function(e) {
			var getRow = $(e.relatedTarget).data('id');
			$("#serviceid").val(getRow);
			$("#name").val(document.getElementById('name'+getRow).innerHTML);
			$("#emailid").val(document.getElementById('emailid'+getRow).innerHTML);
			$("#title").val(document.getElementById('title'+getRow).innerHTML);
		});

		function buttonToggle(id) {
		    $("#eye"+id).find('span').toggleClass('glyphicon-eye-open').toggleClass('glyphicon-eye-close');
		}
		
		    $('#servicerequesttable').DataTable();
		
		function callViewCustomers() {
			document.location.href = "ViewCustomers";
		}
		function callServiceRequests() {
			document.location.href = "ViewServiceRequests";
		}
		function logout() {
			document.location.href = "Logout";
		}
	</script>
</body>
</html>
<%}%>