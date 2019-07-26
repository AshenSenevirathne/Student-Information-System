<!-- 
/**
 * @Student_ID : IT18178678
 * @Name : S.M.A.S.Senevirathne
 */
 -->

<%@page import="com.sis.model.Clases"%>
<%@page import="com.sis.model.Teacher"%>
<%@page import="com.oop.service.ClassesServices"%>
<%@page import="com.oop.service.IClassServices"%>
<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.sis.model.ClassAttendance"%>
<%@page import="com.oop.service.RegisterServices"%>
<%@page import="com.sis.model.Student"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>View Persentage</title>

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
							RegisterServices register = new RegisterServices();
							List<Student> list2 = register.getRegister(className);
							Iterator<Student> it_list2 = list2.iterator();
							int totalDays = register.getTotalDays(className);
						%>



						<div class="text-center">
							<div class="card bg-dark text-white"
								style="background-color: #1C2331;">
								<div class="card-body">
									Total Days =
									<%=totalDays%></div>
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
								while (it_list2.hasNext()) {
									Student student = new Student();
									student = it_list2.next();
									int totalPrasentDays = register.getTotalPrasentDays(student.getStudentID());
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
										 %> <span class="badge badge-pill badge-warning">Percentage
											Bad</span> <%
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


							<%
								}
							%>
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