<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	if (request.getSession().getAttribute("email") != null) {
		response.sendRedirect("LoginRedirect");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Employee Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="ServiceRequest.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body background="bg.jpg">

	
	<div class="header">
		<h2 style="color: white;">Customer Service Portal</h2>
	</div>
	<div class="container" >

		<div class="col-sm-3"></div>
		<div class="col-sm-6" align="center">
			<h3 style="color: white; margin-top: 20px; margin-bottom: 40px;">Employee Login</h3>
			
				<div align="center">
					<form action="LoginRedirect" method="post"  >

						<img src="2.png" alt=" " class="contactimage" /> <br><input
							type="email" name="email" placeholder="Email"
							required="" /><br><br><input type="password" name="password"
							placeholder="Password" required="" /><br><br><input class="btn btn-success" type="submit"
							value="login">
					</form>
				</div>
			</div>
		</div>
		<div class="col-sm-3"></div>
	<script src="js/jquery-2.1.4.min.js"></script>
</body>

</html>
