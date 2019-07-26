<!-- /**
 * @Student_ID : IT18180626
 * @Name : H.M.A.N.Welagedara
 */
 -->
 
 
<%@page import="com.sis.model.Subjects"%>
<%@page import="com.oop.service.SubjectServices"%>
<%@page import="com.oop.service.ISubjectsServices"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Subjects</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">


  <script src="js/jquery-3.4.0.min.js"></script>
  <script src="js/bootstrap.min.js"></script>

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
				<h3>ALL Subjects</h3>
			</div>
		</div>
	</div>
	
	
	
	<table class="table table-hover table-dark">
		<thead>
			<tr>
				<th scope="col">Subject Id</th>
				<th scope="col">Subject Code</th>
				<th scope="col">Subject Name</th>
				<th scope="col">Year</th>
				<th scope="col"></th>
				<th scope="col"></th>
				
			</tr>
		</thead>


		<%
			ISubjectsServices iSubjectsServices = new SubjectServices();
			ArrayList<Subjects> arrayList = iSubjectsServices.getSubjectList();
			for (Subjects subjects : arrayList) {
		%>


		<tbody>
			<tr>
				<th scope="row"><%=subjects.getSubID()%></th>
				<td><%=subjects.getSubCode()%></td>
				<td><%=subjects.getSubName()%></td>
				<td><%=subjects.getYear()%></td>
				

				<td><form method="POST" action="GetSubjectDetailsByIDServlet">
						<button type="submit" class="btn btn-outline-success"
							name="subjectId" value="<%=subjects.getSubID()%>">Edit</button>
					</form></td>




				<td><form method="POST" action="RemoveSubjectsServlet">
						<button type="submit" class="btn btn-outline-danger"
							name="subjectId" value="<%=subjects.getSubID()%>">Remove</button>
					</form></td>

			</tr>

		</tbody>

		<%
			}
		%>
	</table>
	
	
	<!-- The Modal add subjects-->
		<div class="modal fade" id="myModalsub">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">

					<!-- Modal Header -->
					<div class="modal-header">

						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>

					<!-- Modal body -->
					<div class="modal-body">

						<form action="AddSubjectServlet" method="POST" name="addSubjects"
							onsubmit="return subject_validation()">
							<div class="card border-primary rounded-0">
								<div class="card-header p-0">
									<div class="bg-info text-white text-center py-2">
										<h2>Add Subjects</h2>
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
												placeholder="Enter Subject Code"  name="subCode" required >
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
												 placeholder="Enter Subject Name" name="subName">
										</div>
									</div>

									<div class="form-group">
										<div class="input-group mb-2">
											<div class="input-group-prepend">
												<div class="input-group-text">
													<i class="fa fa-comment text-info"></i>
												</div>
											</div>

											<input type="text" class="form-control" placeholder="Enter Year" name="year">
										</div>
									</div>
									
									<div class="form-group">
										<div class="text-center">
											<input type="submit" value="Add Subject"
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
	
	
	
	
	<div class="text-center">

		<div class="btn-group">
			<div class="col-sm-12">
				<div class="container">

					<!-- Button to Open the Modal -->
					<button type="button" class="btn btn-primary" data-toggle="modal"
						data-target="#myModalsub">Add Subject</button>


					<!-- remove all Subjects -->

					<form method="POST" action="RemoveAllSubjectsServlet">
						<button type="submit" class="btn btn-danger">Delete All
							Subjects</button>
					</form>

					</div>
				</div>
			</div>
	</div>
	</div>
	</div>
	
	</div>
	<script src="js/jquery-3.4.0.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

</body>
</html>