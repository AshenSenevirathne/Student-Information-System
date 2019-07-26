<!-- 
/**
 * @Student_ID : IT18178678
 * @Name : S.M.A.S.Senevirathne
 */
 -->

<%@page import="com.sis.model.Clases"%>
<%@page import="com.oop.service.IClassServices"%>
<%@page import="com.sis.model.Teacher"%>
<%@page import="com.sis.model.ClassPlaceList"%>
<%@page import="com.sis.model.Student"%>
<%@page import="com.oop.service.ClassesServices"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.oop.service.RegisterServices"%>
<%@page import="com.sis.model.Marks"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.oop.service.MarkServices"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show All Details</title>
</head>
<body>


	<div class="wrapper">
		<div class="main-panel">

			<jsp:include page="/WEB-INF/views/teacher/SideBar.jsp"></jsp:include>


			<div class="content">
				<div class="container-fluid">
					<div class="card">
						<!--body Start here -->


						<%
						Teacher teacher = (Teacher) session.getAttribute("User");
						int userName = teacher.getTeacherId();
						
						IClassServices iClassServices = new ClassesServices();
						String className = iClassServices.getClassName(userName);
						Clases clases = iClassServices.getClassDetails(className);
							
						
							String studentId = request.getParameter("studentID");
							ClassesServices classesServices = new ClassesServices();
							Student student = new Student();
							student = classesServices.getStudentByID(studentId);
						%>

						<div class="text-center">
							<div class="card bg-dark text-white"
								style="background-color: #1C2331;">
								<div class="card-body"><%=student.getName()%>
									Details
								</div>
							</div>
						</div>

						<table class="table table-hover table-dark">



							<tbody>
								<tr>

									<td>Student ID</td>
									<td><%=student.getStudentID()%></td>
								</tr>

								<tr>

									<td>Student Name</td>
									<td><%=student.getName()%></td>
								</tr>

								<tr>
									<td>Student Year</td>
									<td><%=student.getYear()%></td>
								</tr>
								<tr>
									<td>Student Class Name</td>
									<td><%=student.getClassName()%></td>
								</tr>


							</tbody>
						</table>






						<%
							RegisterServices register = new RegisterServices();

							int totalDays = register.getTotalDays(clases.getClassName());
						%>


						<br> <br>
						<div class="text-center">
							<div class="card bg-dark text-white"
								style="background-color: #1C2331;">
								<div class="card-body">Attendance</div>
							</div>
						</div>



						<table class="table table-hover table-dark">
							<thead>
								<tr>

									<th scope="col">Student ID</th>
									<th scope="col">Name</th>
									<th scope="col">Present Days</th>
									<th scope="col">Absent Days</th>
									<th scope="col">Presentage State</th>
									<th scope="col">Presentage Value</th>

								</tr>
							</thead>
							<%
								int totalPrasentDays = register.getTotalPrasentDays(studentId);
								int totalAbsentDays = totalDays - totalPrasentDays;

								float persentageValue = ((float) totalPrasentDays / totalDays) * 100;
								DecimalFormat form = new DecimalFormat("0.0");
							%>
							<tbody>
								<tr>

									<td><%=student.getStudentID()%></td>
									<td><%=student.getName()%></td>
									<td><%=totalPrasentDays%></td>
									<td><%=totalAbsentDays%></td>
									<td>
										<%
											if (persentageValue >= 80) {
										%> <span class="badge badge-pill badge-info">Percentage
											Good</span> <%
 								} else {
 										%> <span class="badge badge-pill badge-warning">Percentage Bad</span> <%
								 	}
								 %>
									</td>

									<td>
										<%
											if (persentageValue >= 80) {
										%>

										<div class="clearfix">



											<div class="c100 p100 small">
												<span><%=form.format(persentageValue)%>%</span>
												<div class="slice">
													<div class="bar"></div>
													<div class="fill"></div>
												</div>
											</div>

										</div> <%
												 	} else {
												 %>
										<div class="clearfix">



											<div class="c100 p100 small orange">
												<span><%=form.format(persentageValue)%>%</span>
												<div class="slice">
													<div class="bar"></div>
													<div class="fill"></div>
												</div>
											</div>

										</div> <%
												 	}
												 %>
									</td>



								</tr>

							</tbody>



						</table>













						<br> <br>
						<div class="text-center">
							<div class="card bg-dark text-white"
								style="background-color: #1C2331;">
								<div class="card-body">Marks</div>
							</div>
						</div>


						<%
							MarkServices markServices = new MarkServices();
							List<Marks> list = markServices.getStudentMArk(studentId);
							Iterator<Marks> it_list = list.iterator();
						%>


						<table class="table table-hover table-dark">
							<thead>
								<tr>

									<th scope="col">Subject</th>
									<th scope="col">Pass</th>
									<th scope="col">Mark</th>
								</tr>
							</thead>
							<%
								while (it_list.hasNext()) {
									Marks marks = new Marks();
									marks = it_list.next();
									float SubjectMark = marks.getMark();
							%>


							<tbody>
								<tr>
									<td><%=marks.getSubjectName()%></td>
									<td>
										<%
											if (SubjectMark >= 75) {
										%>
										<p class="text-warning">A</p> <%
											 	} else if (SubjectMark >= 65) {
											 %>

										<p class="text-info">B</p> <%
											 	} else if (SubjectMark >= 55) {
											 %>
											<p class="text-success">C</p> <%
										 	} else if (SubjectMark >= 45) {
										 %>

										<p class="text-secondary">S</p> <%
										 	} else {
										 %>
										<p class="text-danger">F</p> <%
										 	}
										 %>









									</td>
									<td>
										<%
											if (SubjectMark >= 75) {
										%>
										<div class="progress">
											<div class="progress-bar bg-warning" role="progressbar"
												style="width: <%=marks.getMark()%>%;" aria-valuenow="25"
												aria-valuemin="0" aria-valuemax="100"><%=marks.getMark()%></div>
										</div> <%
										 	} else if (SubjectMark >= 65) {
										 %>
										<div class="progress">
											<div class="progress-bar bg-info" role="progressbar"
												style="width: <%=marks.getMark()%>%;" aria-valuenow="25"
												aria-valuemin="0" aria-valuemax="100"><%=marks.getMark()%></div>
										</div> <%
										 	} else if (SubjectMark >= 55) {
										 %>
										<div class="progress">
											<div class="progress-bar bg-success" role="progressbar"
												style="width: <%=marks.getMark()%>%;" aria-valuenow="25"
												aria-valuemin="0" aria-valuemax="100"><%=marks.getMark()%></div>
										</div> <%
												 	} else if (SubjectMark >= 45) {
												 %>
										<div class="progress">
											<div class="progress-bar bg-secondary" role="progressbar"
												style="width: <%=marks.getMark()%>%;" aria-valuenow="25"
												aria-valuemin="0" aria-valuemax="100"><%=marks.getMark()%></div>
										</div> <%
												 	} else {
												 %>

										<div class="progress">
											<div class="progress-bar bg-danger" role="progressbar"
												style="width: <%=marks.getMark()%>%;" aria-valuenow="25"
												aria-valuemin="0" aria-valuemax="100"><%=marks.getMark()%></div>
										</div> <%
										 	}
										 %>


									</td>


								</tr>

							</tbody>


							<%
								}
							%>
						</table>



						<div class="text-center">
							<div class="card bg-dark text-white"
								style="background-color: #1C2331;">
								<div class="card-body">Class Place List</div>
							</div>
						</div>

						<%
							ClassPlaceList classPlaceList = new ClassPlaceList();
							classPlaceList = markServices.getSelectedStudentPlaceList(studentId);

							DecimalFormat form1 = new DecimalFormat("0.00");
						%>

						<table class="table table-hover table-dark">
							<thead style="color: white">
								<tr>

									<th scope="col">Student ID</th>
									<th scope="col">Name</th>
									<th scope="col">Total Marks</th>
									<th scope="col">Total Subjects</th>
									<th scope="col">Average</th>

								</tr>
							</thead>
							<%
								
							%>
							<tbody>
								<tr>


									<td><%=classPlaceList.getStudentID()%></td>
									<td><%=classPlaceList.getName()%></td>
									<td><%=classPlaceList.getSum()%></td>
									<td><%=classPlaceList.getTotalSubject()%></td>
									<td><%=form1.format(classPlaceList.getAvg())%></td>
							</tbody>





						</table>






						<!--body end here -->
					</div>
				</div>
			</div>


			<jsp:include page="/WEB-INF/views/teacher/Footer.jsp"></jsp:include>

		</div>
	</div>


</body>
</html>