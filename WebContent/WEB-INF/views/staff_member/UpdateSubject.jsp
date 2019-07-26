<!-- /**
 * @Student_ID : IT18180626
 * @Name : H.M.A.N.Welagedara
 */
 -->
 
 
<%@page import="com.sis.model.Subjects"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Subject</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">


<script src="js/jquery-3.4.0.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
</head>
<body>

	<%
		Subjects subjects = (Subjects) request.getAttribute("subject");
	%>
	<div class="container">
		<jsp:include page="/WEB-INF/views/staff_member/DashBoard.jsp"></jsp:include>
	
	<br><br>
	<div class="card bg-light text-dark">
			<div class="card-body">

	<form action="EditSubjectServlet" method="POST">
		<div class="card border-primary rounded-0">
			<div class="card-header p-0">
				<div class="bg-info text-white text-center py-2">
					<h2>Edit Subjects</h2>
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
							placeholder="Enter Subject Code"
							value="<%=subjects.getSubCode()%>" name="subCode" required>
					</div>
				</div>
				<div class="form-group">
					<div class="input-group mb-2">
						<div class="input-group-prepend">
							<div class="input-group-text">
								<i class="fa fa-envelope text-info"></i>
							</div>
						</div>
						<input type="text" class="form-control"
							placeholder="Enter Subject Name"
							value="<%=subjects.getSubName()%>" name="subName">
					</div>
				</div>

				<div class="form-group">
					<div class="input-group mb-2">
						<div class="input-group-prepend">
							<div class="input-group-text">
								<i class="fa fa-comment text-info"></i>
							</div>
						</div>

						<input type="text" class="form-control" placeholder="Enter Year"
							value="<%=subjects.getYear()%>" name="year">
					</div>
				</div>

				<div class="form-group">
					<div class="text-center">
						<input type="hidden" value="<%=subjects.getSubID()%>" name="subID">
						<input type="submit" value="Edit Subject"
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