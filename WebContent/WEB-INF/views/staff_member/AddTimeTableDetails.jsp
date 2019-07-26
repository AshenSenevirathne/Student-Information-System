<!-- /**
 * @Student_ID : IT18180626
 * @Name : H.M.A.N.Welagedara
 */
 -->
 
 
<%@page import="com.sis.model.Subjects"%>
<%@page import="com.oop.service.SubjectServices"%>
<%@page import="com.oop.service.ISubjectsServices"%>
<%@page import="com.sis.model.TimeTableName"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Time Table Details</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">




<script src="js/jquery-3.4.0.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
</head>
<body>

	<%
		TimeTableName timeTableName = (TimeTableName) request.getAttribute("timeTableName");
	%>

	<div class="container">
		<jsp:include page="/WEB-INF/views/staff_member/DashBoard.jsp"></jsp:include>

		<br>
		<br>
		<div class="card bg-light text-dark">
			<div class="card-body">

				<div class="text-center">
					<div class="card bg-dark text-white">
						<div class="card-body">
							<h3><%=timeTableName.getTimeTableName()%>
								- Grade
								<%=timeTableName.getYear()%>
							</h3>
						</div>
					</div>
				</div>

				<form action="AddTimeTableDetailsServlet" method="POST">
					<table class="table table-hover table-dark">
						<thead>
							<tr>
								<th scope="col">Subject</th>
								<th scope="col">Date</th>
								<th scope="col">Start Time</th>
								<th scope="col">End Time</th>

							</tr>
						</thead>

						<%
							ISubjectsServices iSubjectsServices = new SubjectServices();
							ArrayList<Subjects> arrayList = iSubjectsServices.getSubjectList(timeTableName.getYear());
							for (Subjects subjects : arrayList) {
						%>


						<tbody>

							<tr>

								<th scope="row"><%=subjects.getSubName()%> <input
									type="hidden" name="subject" value="<%=subjects.getSubName()%>"></th>
								<td><input type="date" class="form-control"
									placeholder="Enter Date" name="day"></td>
								<td><input type="time" class="form-control"
									placeholder="Enter Start Time" name="startTime"></td>
								<td><input type="time" class="form-control"
									placeholder="Enter End Time" name="endTime"></td>



							</tr>

						</tbody>

						<%
							}
						%>
					</table>
					<div class="text-center">
					<button type="submit" class="btn btn-primary" name="timeTableID"
						value="<%=timeTableName.getTimeTableID()%>">Add Details</button>
					</div>
				</form>

			</div>
		</div>
	</div>


</body>
</html>