<!-- /**
 * @Student_ID : IT18180626
 * @Name : H.M.A.N.Welagedara
 */
 -->

<%@page import="com.sis.model.Student"%>
<%@page import="com.oop.service.StudentServices"%>
<%@page import="com.oop.service.IStudentServices"%>
<%@page import="java.util.List"%>

<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>


<script src="js/jquery-3.4.0.min.js"></script>
  <script src="js/bootstrap.min.js"></script>

<title>Student List</title>



</head>
<body>

	<div class="container">
		<jsp:include page="/WEB-INF/views/staff_member/DashBoard.jsp"></jsp:include>
	
	<br><br>
	<div class="card bg-light text-dark">
			<div class="card-body">
			
				<div class="text-center">
		<div class="card bg-dark text-white">
			<div class="card-body">
				<h3>ALL Students</h3>
			</div>
		</div>
	</div>

	<%String cl = request.getParameter("classes"); %>

	<table class="table table-hover table-dark">
		<thead>
			<tr>
				<th scope="col">Student ID</th>
				<th scope="col">Name</th>
				<th scope="col">Year</th>
				<th scope="col"></th>
				<th scope="col"></th>
			</tr>
		</thead>


		<%
			IStudentServices iStudentServices = new StudentServices();
			ArrayList<Student> arrayList = iStudentServices.getStudentList();
			for (Student student : arrayList) {
		%>


		<tbody>
			<tr>
				<th scope="row"><%=student.getStudentID()%></th>
				<td><%=student.getName()%></td>
				<td><%=student.getYear()%></td>
				


				<td><form method="POST" action="GetStudentDetailsByIDServlet">
						<button type="submit" class="btn btn-outline-success"
							name="studentId" value="<%=student.getStudentID()%>">Edit</button>
					</form></td>




				<td><form method="POST" action="RemoveStudent">
						<button type="submit" class="btn btn-outline-danger"
							name="studentID" value="<%=student.getStudentID()%>">Remove</button>
					</form></td>

			</tr>

		</tbody>

		<%
			}
		%>
	</table>

	<div class="text-center">

		<div class="btn-group">
			<div class="col-sm-12">
				<div class="container">

					<!-- Button to Open the Modal -->
					<button type="button" class="btn btn-primary" data-toggle="modal"
						data-target="#myModal">Add Student</button>


					<!-- remove all Stdents -->

					<form method="POST" action="RemoveAllStudent">
						<button type="submit" class="btn btn-danger">Delete All
							Student</button>
					</form>

					</div>
				</div>
			</div>
	</div>
			
			
			
			</div>
		</div>
	</div>

	
	
	<!-- The Modal add Student-->
		<div class="modal fade" id="myModal">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">

					<!-- Modal Header -->
					<div class="modal-header">

						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>

					<!-- Modal body -->
					<div class="modal-body">

						<form action="AddStudentServlet" method="POST" name="addStudents" name="RegForm"
							onsubmit="return validations_StaffMember()">
							<div class="card border-primary rounded-0">
								<div class="card-header p-0">
									<div class="bg-info text-white text-center py-2">
										<h2>Add Student Details</h2>
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
												placeholder="Enter Name"  name="name"  >
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
												placeholder="Enter Year" name="year">
										</div>
									</div>

									<div class="form-group">
										<div class="text-center">
											<input type="submit" value="Add Student"
												class="btn btn-info btn-block rounded-0 py-2">
										</div>
									</div>

								</div>
								</div>
						</form>
					</div>

					<!-- Modal footer -->
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
					</div>

				</div>
			</div>
		</div>







	<script src="js/jquery-3.4.0.min.js"></script>
	<script src="js/bootstrap.min.js"></script>


</body>
</html>