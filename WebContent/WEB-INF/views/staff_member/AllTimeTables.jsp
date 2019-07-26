<!-- /**
 * @Student_ID : IT18180626
 * @Name : H.M.A.N.Welagedara
 */
 -->
 
 
<%@page import="com.sis.model.TimeTableDetails"%>
<%@page import="com.sis.model.TimeTableName"%>
<%@page import="com.oop.service.TimeTableServices"%>
<%@page import="com.oop.service.ITimeTableServices"%>
<%@page import="java.util.Iterator"%>

<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Time Tables</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">


<script src="js/jquery-3.4.0.min.js"></script>
  <script src="js/bootstrap.min.js"></script>

</head>
<body>

	<div class="container">
		<jsp:include page="/WEB-INF/views/staff_member/DashBoard.jsp"></jsp:include>

		<br> <br>
		<div class="card bg-light text-dark">
			<div class="card-body">
	
	<%
		ITimeTableServices iTimeTableServices = new TimeTableServices();
		ArrayList<TimeTableName> arrayList = iTimeTableServices.getTimetableNameList();
		Iterator<TimeTableName> it_list = arrayList.iterator();
		while (it_list.hasNext()) {
			TimeTableName timeTableName = new TimeTableName();
			timeTableName = it_list.next();
	%>



	

				<div class="text-center">
					<div class="card bg-dark text-white">
						<div class="card-body">
							<h3><%=timeTableName.getTimeTableName()%>
								- Year
								<%=timeTableName.getYear()%></h3>
						</div>
					</div>
				</div>

				<table class="table table-hover table-dark">
					<thead>
						<tr>
							<th scope="col">Day</th>
							<th scope="col">Subject</th>
							<th scope="col">Time</th>


						</tr>
					</thead>

					<%
						ArrayList<TimeTableDetails> arrayList1 = iTimeTableServices
									.getTimetableDetailsList(timeTableName.getTimeTableID());
							Iterator<TimeTableDetails> it_list1 = arrayList1.iterator();
							while (it_list1.hasNext()) {
								TimeTableDetails timeTableDetails = new TimeTableDetails();
								timeTableDetails = it_list1.next();
					%>

					<tbody>
						<tr>

							<td><%=timeTableDetails.getDate()%></td>

							<td><%=timeTableDetails.getSubject()%></td>
							<td><%=timeTableDetails.getStartTime()%> - <%=timeTableDetails.getEndTime()%></td>

						</tr>
						<%
							}
						%>
					</tbody>
				</table>
				<div class="text-center">
					<div class="row">
					
					<form method="POST" action="GetTimetableDetailsToEdit">
					<input type="hidden" name="ttID" value="<%=timeTableName.getTimeTableID()%>">
					
					

						<button type="submit" class="btn btn-info">Update</button>
					</form>

					<form action="DeleteTimetableServlet" method="POST">
						<input type="hidden" name="studentID">
						<button type="submit" class="btn btn-danger" name="ttID"
							value="<%=timeTableName.getTimeTableID()%>">Delete</button>
					</form>
					</div>
				</div>
				<br> <br>

				<%
					}
				%>
			</div>
		</div>
	</div>

<script src="js/jquery-3.4.0.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

</body>
</html>