<!-- /**
 * @Student_ID : IT18180626
 * @Name : H.M.A.N.Welagedara
 */
 -->

<%@page import="java.util.Iterator"%>
<%@page import="com.sis.model.TimeTableDetails"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.oop.service.TimeTableServices"%>
<%@page import="com.oop.service.ITimeTableServices"%>
<%@page import="com.sis.model.TimeTableName"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit TimeTable</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">


<script src="js/jquery-3.4.0.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
</head>
<body>
	<%
		TimeTableName timeTableName = (TimeTableName) request.getAttribute("tableName");

		ITimeTableServices iTimeTableServices = new TimeTableServices();
		timeTableName = iTimeTableServices.getTimeTableNameById(timeTableName.getTimeTableID());
	%>

	<div class="container">
		<jsp:include page="/WEB-INF/views/staff_member/DashBoard.jsp"></jsp:include>

		<br> <br>
		<div class="card bg-light text-dark">
			<div class="card-body">

				<form action="EditTimeTableServelet" method="POST">
					<div class="card border-primary rounded-0">
						<div class="card-header p-0">
							<div class="bg-info text-white text-center py-2">
								<h2>Edit Timetable <%=timeTableName.getTimeTableName()%> - <%=timeTableName.getYear() %></h2>
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
										placeholder="Enter Exam Name" name="examName"
										value="<%=timeTableName.getTimeTableName()%>">
								</div>
							</div>
							<div class="form-group">
								<div class="input-group mb-2">
									<div class="input-group-prepend">
										<div class="input-group-text">
											<i class="fa fa-envelope text-info"></i>
										</div>
									</div>
									<input type="number" class="form-control"
										placeholder="Enter Year" name="year"
										value="<%=timeTableName.getYear()%>">
								</div>
							</div>
							<input type="hidden" name="ttID" value="<%=timeTableName.getTimeTableID()%>">
							<%
							ArrayList<TimeTableDetails> arrayList1 = iTimeTableServices.getTimetableDetailsList(timeTableName.getTimeTableID());
							Iterator<TimeTableDetails> it_list1 = arrayList1.iterator();
							
					%>
					
					<table class="table table-striped">
						<thead>
							<tr>
								<th scope="col">Subject</th>
								<th scope="col">Date</th>
								<th scope="col">Start Time</th>
								<th scope="col">End Time</th>

							</tr>
						</thead>

						<%
						while (it_list1.hasNext()) {
							TimeTableDetails timeTableDetails = new TimeTableDetails();
							timeTableDetails = it_list1.next();
						%>


						<tbody>

							<tr>
								
								<th scope="row"><input type="hidden" name="ttDID" value="<%=timeTableDetails.getTtDetailsId()%>"><%=timeTableDetails.getSubject() %></th>
								<td><input type="date" class="form-control"
									placeholder="Enter Date" name="day" value="<%=timeTableDetails.getDate()%>"></td>
								<td><input type="time" class="form-control"
									placeholder="Enter Start Time" name="startTime" value="<%=timeTableDetails.getStartTime()%>"></td>
								<td><input type="time" class="form-control"
									placeholder="Enter End Time" name="endTime" value="<%=timeTableDetails.getEndTime()%>"></td>



							</tr>

						</tbody>

						<%
							}
						%>
					</table>
					


							<div class="form-group">
								<div class="text-center">
									<input type="submit" value="Edit Timetable"
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