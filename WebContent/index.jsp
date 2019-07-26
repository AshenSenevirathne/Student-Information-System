<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <link rel="stylesheet" href="css/style.css">
  
  <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
</head>
<body>
<div class="container-fluid">
<div class="row">
<div class="col-md-8">
 <div class="shadow p-6 mb-5 bg-white rounded form-signin text-center p-5">
 
 <%
 
 String x = request.getParameter("submit");
 if(x!=null && x.equals("confirm"))
 {
 %>

	 <div class="alert alert-warning alert-dismissible fade show" role="alert">
	  Please Re Enter Your Login Credentials
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
	    <span aria-hidden="true">&times;</span>
	  </button>
	</div>
	
<%
 }
%>
	
	  <form action="Login" method="POST">
	  <img class="mb-4 rounded-circle" src="images/admin/face.jpg" width="80" height="80">
	  <h1 class="h3 mb-3 font-weight-normal">Sign in to System</h1>
	  
	  <label for="inputEmail" class="sr-only">Email address</label>
	  <input type="text" id="inputEmail" class="form-control mb-4 mt-4" placeholder="User Name" name = "username" required autofocus>
	  
	  <label for="inputPassword" class="sr-only">Password</label>
	  <input type="password" id="inputPassword" class="form-control mb-4" placeholder="Password" name="password" required>
	  
	  <button class="btn btn-lg btn-primary btn-block" type="submit" name="submit" value="confirm">Sign in</button>
	  
	  <p class="mt-5 mb-3 text-muted">&copy;Student Information System</p>
	  
	</form>
</div> 
</div>

</div>
</div>
  <script src="js/jquery-3.4.0.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  
</body>
</html>