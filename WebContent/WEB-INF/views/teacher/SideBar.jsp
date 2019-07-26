<!-- 
/**
 * @Student_ID : IT18178678
 * @Name : S.M.A.S.Senevirathne
 */
 -->

<%@page import="com.sis.model.Teacher"%>
<%@page import="com.sis.model.Clases"%>
<%@page import="com.oop.service.ClassesServices"%>
<%@page import="com.oop.service.IClassServices"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>This Is Sidebar</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<link rel="icon" type="image/png" href="assets/img/favicon.ico">

<!-- Bootstrap core CSS     -->
<link href="assets/css/bootstrap.min.css" rel="stylesheet" />

<!--  Light Bootstrap Table core CSS    -->
 <link href="assets/css/light-bootstrap-dashboard.css?v=1.4.0" rel="stylesheet"/>

<!--     Fonts and icons     -->
<link href="assets/css/pe-icon-7-stroke.css" rel="stylesheet" />

<link rel="stylesheet" href="css/teacher/search.css">

<link rel="stylesheet" href="css/teacher/common.css">

<link rel="stylesheet" href="css/teacher/circle.css">

<script type="text/javascript" src="js/teacher/classValidation.js"></script>





</head>
<body>


	<%	
				Teacher teacher = (Teacher) session.getAttribute("User");
				int userName = teacher.getTeacherId();
				
				IClassServices iClassServices = new ClassesServices();
				String className = iClassServices.getClassName(userName);
				
		
	%>

	<div class="sidebar" data-color="blue"
		data-image="assets/img/sidebar-5.jpg">
		<div class="sidebar-wrapper"
			style="background-color: black; opacity: .85">

			<br>
			<ul class="nav">
			
				<%if(className.equals("None")){ %>
			
				<li><a><form method="POST" action="JspPageManagerServlet?action=CC"> <i class="pe-7s-add-user"></i>
					
						<button type="submit" class="btn btn-outline-light">Create CLass </button></form>
				</a></li>
				
				<%} %>
				<li><a> <form method="POST" action="JspPageManagerServlet?action=VC"><i class="pe-7s-users"></i>
						<button type="submit" class="btn btn-outline-light" name="viewClass" value="vc">View Class</button></form>
				</a></li>
				<li><a> <form method="POST" action="JspPageManagerServlet?action=MR"><i class="pe-7s-note2"></i>
						<button type="submit" class="btn btn-outline-light">Mark Register</button></form>
				</a></li>
				<li><a> <form method="POST" action="JspPageManagerServlet?action=VA"><i class="pe-7s-graph1"></i>
						<button type="submit" class="btn btn-outline-light" name="ViewAttendance" value="viewAtt">View Attendance</button></form>
				</a></li>
				<li><a> <form method="POST" action="JspPageManagerServlet?action=AM"><i class="pe-7s-id"></i>
						<button type="submit" class="btn btn-outline-light" name="Addmarks" value="addmarks">Add Marks</button></form>
				</a></li>
				<li><a><form method="POST" action="JspPageManagerServlet?action=VM"> <i class="pe-7s-graph3"></i>
						<button type="submit" class="btn btn-outline-light">View Marks</button></form>
				</a></li>
				<li><a ><form method="POST" action="JspPageManagerServlet?action=MO"> <i class="pe-7s-graph2"></i>
						<button type="submit" class="btn btn-outline-light">Marks Order</button></form>
				</a></li>
				<li class="active-pro"><a ><form method="POST" action="JspPageManagerServlet?action=UA"> <i class="pe-7s-notebook"></i>
						<button type="submit" class="btn btn-outline-light">Assignments</button></form>
				</a></li>
				
			</ul>
		</div>
	</div>


	<nav class="navbar navbar-default navbar-fixed">
		<div class="container-fluid">

			<div class="collapse navbar-collapse">

				<ul class="nav navbar-nav navbar-left">


					<li>
						<form method="POST" action="JspPageManagerServlet?action=SD">

							<div class="searchbar">
								<input class="search_input" type="text" name="studentID"
									placeholder="Search Student ID"> <a
									href="ShowAllStudentSetails.jsp?studentID" class="pe-7s-search"><i
									class="fas fa-search"></i></a>
							</div>

						</form>

					</li>
				</ul>



				<ul class="nav navbar-nav navbar-right">

					<li><a href="#">
							<p>Log out</p>
					</a></li>

				</ul>
			</div>
		</div>
	</nav>



</body>
</html>