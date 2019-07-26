<!-- 
/**
 * @Student_ID : IT18178678
 * @Name : S.M.A.S.Senevirathne
 */
 -->

<%@page import="com.sis.model.Teacher"%>
<%@page import="com.oop.service.IClassServices"%>
<%@page import="com.sis.model.Clases"%>
<%@page import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>
<%@page import="com.oop.service.ClassesServices"%>
<%@page import="com.sis.model.Student"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add Students</title>

</head>
<body>


						<%
							Teacher teacher = (Teacher) session.getAttribute("User");
							int userName = teacher.getTeacherId();
							IClassServices iClassServices = new ClassesServices();
							String className = iClassServices.getClassName(userName);
							Clases clases = iClassServices.getClassDetails(className);
						%>

	


	<div class="wrapper">
		<div class="wrapper">
		<div class="main-panel">

			<jsp:include page="/WEB-INF/views/teacher/SideBar.jsp"></jsp:include>

			<div class="content">
				<div class="container-fluid">
					<div class="card">
						<!--body Start here -->
						<div class="container-fluid">

								<div class="col-md-12">
									<div class="text-center">

										<div class="text-center">
											<div class="card bg-dark text-white"
												style="background-color: #1C2331;">
												<div class="card-body">
													ADD Students To 
													<%=clases.getClassName()%> Class
												
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						


						
						<form method="POST" action="AddStudentsToClassServlet">
							<div class="text-center">
							<div class="card bg-dark text-white"
								style="background-color: #1C2331;">
								<div class="card-body">
									All Students In Year
									<%=clases.getYear()%></div>
							</div>
						</div>
							<%
								IClassServices classesServices = new ClassesServices();
								List<Student> list = classesServices.getStudentList(clases.getYear());
								Iterator<Student> it_list = list.iterator();
							%>

							<table class="table table-hover table-dark">
								<thead style="color: white">
									<tr>
										<th scope="col"></th>
										<th scope="col">Student ID</th>
										<th scope="col">Name</th>
										<th scope="col">Year</th>
										<th scope="col"></th>
									</tr>
								</thead>
								<%
									while (it_list.hasNext()) {
										Student student = new Student();
										student = it_list.next();
								%>
								<tbody>
									<tr>
										<td></td>

										<td><%=student.getStudentID()%></td>
										<td><%=student.getName()%></td>
										<td><%=student.getYear()%></td>

										<td><input type="checkbox" name="studentId"
											value="<%=student.getStudentID()%>"></td>
									</tr>

								</tbody>

								<%
									}
								%>



							</table >
								
								
							<input type="hidden" value="<%=clases.getClassName()%>" name="className">
							<div class="text-center">
								<button type="submit" class="btn btn-info" data-toggle="tooltip"
									title="Click To Add Students To <%=clases.getClassName()%>">
									Add Students To Class
									<%=clases.getClassName()%></button>
							</div>

						</form>
						<br> <br>



						<form method="POST" action="RemoveStudentFromClass">


							<div class="text-center">
							<div class="card bg-dark text-white"
								style="background-color: #1C2331;">
								<div class="card-body">
									Added Students To
									<%=clases.getClassName()%></div>
							</div>
						</div>

							<%
								List<Student> list1 = classesServices.getInsertedStudentList(clases.getClassName());
								Iterator<Student> it_list1 = list1.iterator();
							%>


							<table class="table table-hover table-dark">
								<thead style="color: white">
									<tr>
										<th scope="col"></th>
										<th scope="col"></th>
										<th scope="col"></th>
										<th scope="col"></th>
										<th scope="col">Student ID</th>
										<th scope="col">Name</th>
										<th scope="col">Year</th>
										<th scope="col"></th>
									</tr>
								</thead>
								<%
									while (it_list1.hasNext()) {
										Student student1 = new Student();
										student1 = it_list1.next();
								%>
								<tbody>
									<tr>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td><%=student1.getStudentID()%></td>
										<td><%=student1.getName()%></td>
										<td><%=student1.getYear()%></td>

										<td>


											<button type="submit" class="btn btn-outline-danger"
												name="removeStudentID" value="<%=student1.getStudentID()%>">
												Remove From
												<%=clases.getClassName()%></button>
										</td>
									</tr>

								</tbody>
								<%
									}
								%>


							</table>
						


						</form>
						<br> <br> <br>
						<form method="POST" action="FinalizedClassServlet">
							


							<div class="text-center">
								<button type="submit" class="btn btn-info" data-toggle="tooltip"
									title="Click To Finalize Class" name="classID"
									value="<%=clases.getClassID()%>">Finalize Class</button>
							</div>
						</form>
						<br>



						<!--body end here -->
					</div>
				</div>
			</div>


			<jsp:include page="/WEB-INF/views/teacher/Footer.jsp"></jsp:include>

		</div>
	</div>
	</div>
	

</body>
</html>