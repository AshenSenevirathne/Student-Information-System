<!-- /**
 * @Student_ID : IT18180626
 * @Name : H.M.A.N.Welagedara
 */
 -->
 
 
<%@page import="com.sis.model.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="js/jquery-3.4.0.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
	
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.1.0/css/all.css"
	integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt"
	crossorigin="anonymous">

<title>Insert title here</title>
</head>
<body>

	<%
		Student student = (Student) request.getAttribute("student");
	%>
	
	<div class="container">
		<jsp:include page="/WEB-INF/views/staff_member/DashBoard.jsp"></jsp:include>

		<br><br>
		<div class="card bg-light text-dark">
			<div class="card-body">


		
			<form action="UpdateStudentServlet" method="POST" name="RegForm" onsubmit="return GEEKFORGEEKS()">
									<div class="card border-primary rounded-0">
								<div class="card-header p-0">
									<div class="bg-info text-white text-center py-2">
										<h2>Update Student Details</h2>
									</div>
								</div>
								
								<div class="card-body p-3">

									<!--Body-->
									<div class="form-group">
										<div class="input-group mb-2">
											<div class="input-group-prepend">
												<div class="input-group-text">
													<i class="fa fa-user text-info"></i>
												</div>
											</div>
											<input type="text" class="form-control"
												placeholder="Enter Name"  name="name"  value = "<%=student.getName()%>">
										</div>
									</div>
									
									<div class="form-group">
										<div class="input-group mb-2">
											<div class="input-group-prepend">
												<div class="input-group-text">
													<i class="fa fa-comment text-info"></i>
												</div>
											</div>

											<input type="number" class="form-control"
												placeholder="Enter Year" name="year" value = "<%=student.getYear()%>">
										</div>
									</div>

									<div class="form-group">
										<div class="text-center">
											<input type="hidden" name="StudentId" value="<%=student.getStudentID()%>">
											<input type="submit" value="Update Details"
												class="btn btn-info btn-block rounded-0 py-2">
										</div>
									</div>

								</div>
								</div>
						</form>

	</div>
	</div>
	</div>
	

</body>
</html>