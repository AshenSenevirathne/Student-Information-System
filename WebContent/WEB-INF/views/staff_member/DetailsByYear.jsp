<!-- /**
 * @Student_ID : IT18180626
 * @Name : H.M.A.N.Welagedara
 */
 -->

<%@page import="com.sis.model.TimeTableName"%>
<%@page import="com.oop.service.TimeTableServices"%>
<%@page import="com.oop.service.ITimeTableServices"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.sis.model.TimeTableDetails"%>
<%@page import="com.sis.model.Subjects"%>
<%@page import="com.oop.service.SubjectServices"%>
<%@page import="com.oop.service.ISubjectsServices"%>
<%@page import="com.sis.model.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.oop.service.StudentServices"%>
<%@page import="com.oop.service.IStudentServices"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details By year</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">


<script src="js/jquery-3.4.0.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
<style>

/* Style the tab */
.tab {
	float: left;
	border: 1px solid #ccc;
	background-color: #263238;
	width: 20%;
	height: auto;
}

/* Style the buttons inside the tab */
.tab button {
	display: block;
	background-color: inherit;
	color: white;
	padding: 22px 16px;
	width: 100%;
	border: none;
	outline: none;
	text-align: left;
	cursor: pointer;
	transition: 0.3s;
	font-size: 17px;
}

/* Change background color of buttons on hover */
.tab button:hover {
	background-color: gray;
}

/* Create an active/current "tab button" class */
.tab button.active {
	background-color: #1C2331;
}

/* Style the tab content */
.tabcontent {
	float: left;
	padding: 0px 12px;
	border: 1px solid #ccc;
	width: 80%;
	border-left: none;
	height: auto;
}
</style>


</head>
<body>

	<%
		int year = Integer.parseInt(request.getParameter("year"));
	%>

	<div class="container">
		<jsp:include page="/WEB-INF/views/staff_member/DashBoard.jsp"></jsp:include>

		<br> <br>
		<div class="card bg-light text-dark">
			<div class="card-body">


				<div class="tab">
					<button class="tablinks" onclick="openCity(event, 'London')"
						id="defaultOpen">Students</button>
					<button class="tablinks" onclick="openCity(event, 'Paris')">Subjects</button>
					<button class="tablinks" onclick="openCity(event, 'Tokyo')">Time Tables</button>
				</div>

				<div id="London" class="tabcontent">
					<div class="text-center">
						<div class="card bg-dark text-white">
							<div class="card-body">
								<h3>
									Grade
									<%=year%>
									Students
								</h3>
							</div>
						</div>
					</div>

					<table class="table table-hover table-dark">
						<thead>
							<tr>
								<th scope="col">Student ID</th>
								<th scope="col">Name</th>
								<th scope="col">Year</th>
						</thead>


						<%
							IStudentServices iStudentServices = new StudentServices();
							ArrayList<Student> arrayList = iStudentServices.getStudentByYear(year);
							for (Student student : arrayList) {
						%>


						<tbody>
							<tr>
								<th scope="row"><%=student.getStudentID()%></th>
								<td><%=student.getName()%></td>
								<td><%=student.getYear()%></td>




							</tr>

						</tbody>

						<%
							}
						%>
					</table>

				</div>

				<div id="Paris" class="tabcontent">
					<div class="text-center">
						<div class="card bg-dark text-white">
							<div class="card-body">
								<h3>
									Grade
									<%=year%>
									Subjects
								</h3>
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


							</tr>
						</thead>


						<%
							ISubjectsServices iSubjectsServices = new SubjectServices();
							ArrayList<Subjects> arrayList1 = iSubjectsServices.getSubjectsByYear(year);
							for (Subjects subjects : arrayList1) {
						%>


						<tbody>
							<tr>
								<th scope="row"><%=subjects.getSubID()%></th>
								<td><%=subjects.getSubCode()%></td>
								<td><%=subjects.getSubName()%></td>
								<td><%=subjects.getYear()%></td>

							</tr>

						</tbody>

						<%
							}
						%>
					</table>

				</div>

				<div id="Tokyo" class="tabcontent">
					<%
						ITimeTableServices iTimeTableServices = new TimeTableServices();
						ArrayList<TimeTableName> arrayList3 = iTimeTableServices.getTimetableNameListByYear(year);
						Iterator<TimeTableName> it_list = arrayList3.iterator();
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
							ArrayList<TimeTableDetails> arrayList2 = iTimeTableServices.getTimetableDetailsList(timeTableName.getTimeTableID());
							Iterator<TimeTableDetails> it_list1 = arrayList2.iterator();
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
					
					<br> <br>

					<%
						}
					%>
				</div>
			</div>
		</div>

	</div>

	<script>
		function openCity(evt, cityName) {
			var i, tabcontent, tablinks;
			tabcontent = document.getElementsByClassName("tabcontent");
			for (i = 0; i < tabcontent.length; i++) {
				tabcontent[i].style.display = "none";
			}
			tablinks = document.getElementsByClassName("tablinks");
			for (i = 0; i < tablinks.length; i++) {
				tablinks[i].className = tablinks[i].className.replace(
						" active", "");
			}
			document.getElementById(cityName).style.display = "block";
			evt.currentTarget.className += " active";
		}

		// Get the element with id="defaultOpen" and click on it
		document.getElementById("defaultOpen").click();
	</script>


	</div>
	</div>
	</div>

</body>
</html>