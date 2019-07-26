<!-- 
/**
 * @Student_ID : IT18178678
 * @Name : S.M.A.S.Senevirathne
 */
 -->

<%@page import="com.sis.model.Teacher"%>
<%@page import="com.oop.service.IClassServices"%>
<%@page import="com.sis.model.ClassAttendance"%>
<%@page import="com.sis.model.Clases"%>
<%@page
	import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>
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
<title>Class View</title>
</head>
<body>


	<div class="wrapper">
		<div class="main-panel">

			<jsp:include page="/WEB-INF/views/teacher/SideBar.jsp"></jsp:include>

			<div class="content">
				<div class="container-fluid">
					<div class="card">
						<!--body Start here -->



						<br>

						<%
							Teacher teacher = (Teacher) session.getAttribute("User");
							int userName = teacher.getTeacherId();
							
							IClassServices iClassServices = new ClassesServices();
							String className = iClassServices.getClassName(userName);
							Clases clases = iClassServices.getClassDetails(className);
						%>




						<div class="text-center">
							<div class="card bg-dark text-white"
								style="background-color: #1C2331;">
								<div class="card-body">
									Update Class
									<%=className%>
									Details
								</div>
							</div>
						</div>

						<br> <br>



						<form method="POST" action="UpdateClassServlet" name="RegForm"
							onsubmit="return classValidations()">
							<div class="content">
								<div class="container-fluid">
									<div class="row">
										<div class="col-md-11">
											<div class="card">

												<div class="content">

													<div class="row">
														<div class="col-md-5">




															<div class="form-group">
																<label>Year</label> <input id="disabledInput"
																	type="number" class="form-control"
																	value = "<%=clases.getYear()%>" name="year"
																	disabled>
															</div>

														</div>
														<div class="col-md-3">
															<div class="form-group">
																<label>Class name</label> <input type="text"
																	class="form-control"
																	value="<%=clases.getClassName()%>"
																	name="className"> <input type="hidden"
																	class="form-control" value="<%=clases.getClassName()%>"
																	name="oldClassName">


															</div>
														</div>
														<div class="col-md-4">
															<div class="form-group">
																<label for="exampleInputEmail1">No Of Students</label> <input
																	type="number" class="form-control"
																	value="<%=clases.getNoOfStudents()%>"
																	name="studentNo">
															</div>
														</div>
													</div>

													<div class="row">
														<div class="col-md-6">
															<div class="form-group">
																<label>Teacher Name</label> <input type="text"
																	class="form-control"
																	value = "<%=clases.getTeacher()%>"
																	name="teacherName">
															</div>
														</div>
														<div class="col-md-6">
															<div class="form-group">
																<label>Hall</label> <input type="text"
																	class="form-control"
																	value="<%=clases.getHall()%>" name="hall">
															</div>
														</div>
													</div>


													<input type="hidden" name="userName" value="<%=userName%>">
													<input type="hidden" name="previousClassName"
														value="<%=className%>">
													<button type="submit"
														class="btn btn-info btn-fill pull-right"
														value="<%=clases.getClassID()%>" name="classID">Update</button>
													<div class="clearfix"></div>

												</div>
											</div>
										</div>


									</div>
								</div>
							</div>

						</form>

						<br>


						<form method="POST" action="RemoveStudentFromClass">



							<div class="text-center">
								<div class="card bg-dark text-white"
									style="background-color: #1C2331;">
									<div class="card-body">
										Added Students To
										<%=className%>
									</div>
								</div>
							</div>

							<%
								List<Student> list1 = iClassServices.getInsertedStudentList(className);
								Iterator<Student> it_list1 = list1.iterator();
							%>


							<table class="table table-hover table-dark">
								<thead>
									<tr>
										
										<th scope="col"></th>
										<th scope="col"></th>
										<th scope="col"></th>
										<th scope="col">Student ID</th>
										<th scope="col">Name</th>
										<th scope="col">Year</th>
										<th scope="col"></th>
										<th scope="col"></th>
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
										<td><%=student1.getStudentID()%></td>
										<td><%=student1.getName()%></td>
										<td><%=student1.getYear()%></td>
										<td></td>
										<td></td>
										<td><input type="hidden" name="removeStudentID"
											value="<%=student1.getStudentID()%>" />
											<button type="submit"
												class="btn btn-danger">
												Remove From
												<%=clases.getClassName()%></button></td>
									</tr>

								</tbody>
								<%
									}
								%>

								
							</table>
							<input type="hidden" name="className"
								value="<%=clases.getClassName()%>" /> <input type="hidden"
								name="year" value="<%=clases.getYear()%>" /> <input
								type="hidden" name="numberOfStudents"
								value="<%=clases.getNoOfStudents()%>" /> <input type="hidden"
								name="teacherName" value="<%=clases.getTeacher()%>" /> <input
								type="hidden" name="hall" value="<%=clases.getHall()%>" />


						</form>
						<br>
						
						<div class="text-center">
						
							
							<form action="JspPageManagerServlet?action=AS" method="POST"> 
							
								
									<button type="submit" class="btn btn-outline-info" name="addStudentsToClass" value="ad">Add Students</button>
							</form>
							
							<form method="POST" action="RemoveClassServlet">

								<input type="hidden" value="<%=userName%>" name ="userName">
								<input type="hidden" name="className"
									value="<%=clases.getClassName()%>"/>
								<button type="submit" class="btn btn-outline-danger"
									value="<%=clases.getClassID()%>" name="classID">
									Remove
									<%=className%>
									Class
								</button>
							</form>
						</div>
						<br>

						<!--body end here -->
					</div>
				</div>
			</div>


			<jsp:include page="/WEB-INF/views/teacher/Footer.jsp"></jsp:include>

		</div>
	</div>

</body>
</html>