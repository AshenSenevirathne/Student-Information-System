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
<%@page import="com.sis.model.Marks"%>
<%@page import="com.sis.model.Student"%>
<%@page import="com.oop.service.RegisterServices"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.sis.model.Subjects"%>
<%@page import="com.sis.model.ClassAttendance"%>
<%@page import="com.oop.service.MarkServices"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add Marks</title>

</head>
<body>


	<div class="wrapper">
		<div class="main-panel">

			<jsp:include page="/WEB-INF/views/teacher/SideBar.jsp"></jsp:include>


			<div class="content">
				<div class="container-fluid">
					<div class="card">
						<!--body Start here -->








						<div class="text-center">
							<div class="card bg-dark text-white"
								style="background-color: #1C2331;">
								<div class="card-body">All Students</div>
							</div>
						</div>



						<%
							
							Teacher teacher = (Teacher) session.getAttribute("User");
							int userName = teacher.getTeacherId();
							IClassServices iClassServices = new ClassesServices();
							String className = iClassServices.getClassName(userName);
							Clases clases = iClassServices.getClassDetails(className);

							MarkServices markServices = new MarkServices();
							List<Student> list2 = markServices.getClassStudentList(className);
							Iterator<Student> it_list2 = list2.iterator();
						%>

						<table class="table table-hover table-dark">
							<thead>
								<tr>
									<th scope="col"></th>
									<th scope="col">Student ID</th>
									<th scope="col">Name</th>
									<th scope="col"></th>
								</tr>
							</thead>
							<%
								while (it_list2.hasNext()) {
									Student student = new Student();
									student = it_list2.next();
							%>
							<tbody>
								<tr>
									<td></td>
									<td><%=student.getStudentID()%></td>
									<td><%=student.getName()%></td>


									<td><form action="GetSelectedStudentServlet" method="post">
											<input type="hidden" name="studentName"
												value="<%=student.getName()%>">
											<button type="submit" class="btn btn-info"
												value="<%=student.getStudentID()%>" name="studentId">Add
												Marks</button>
										</form></td>



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