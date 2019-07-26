<!-- 
/**
 * @Student_ID : IT18178678
 * @Name : S.M.A.S.Senevirathne
 */
 -->

<%@page import="com.sis.model.Clases"%>
<%@page import="com.oop.service.ClassesServices"%>
<%@page import="com.oop.service.IClassServices"%>
<%@page import="com.sis.model.Teacher"%>
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

<link rel="stylesheet" href="search.css">
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
							Student student = (Student) request.getAttribute("student");
						%>


						<div class="text-center">
							<div class="card bg-dark text-white"
								style="background-color: #1C2331;">
								<div class="card-body">
									Enter Marks Of : Student Id =
									<%=student.getStudentID() %>, Student Name =
									<%=student.getName()%> 
								</div>
							</div>
						</div>



						<%
						MarkServices markServices = new MarkServices();
						List<Subjects> list = markServices.getSubjectList(clases.getYear());
						Iterator<Subjects> it_list = list.iterator();
						%>
						<form action="AddMarksServlet" method="POST"  >
						<table class="table table-hover table-dark">
							<thead>
								<tr>
									<th scope="col"></th>
									<th scope="col">Subject ID</th>
									<th scope="col">Subject Name</th>
									<th scope="col">Mark</th>
									
								</tr>
							</thead>
							<%
							while (it_list.hasNext()) {
								Subjects subjects = new Subjects();
								subjects = it_list.next();
							%>
							<tbody>
								<tr>
									<td></td>
									<td><%=subjects.getSubID()%></td>
									<td><%=subjects.getSubName()%></td>
									<td><input type="number" class="form-control"  name="subjectMark"></td>
									<td><input type="hidden" class="form-control" value="<%=subjects.getSubName()%>"  name="subjectName"></td>
									
									



								</tr>
								
							</tbody>

							<%
								}
							%>
						</table>
						
						<input type ="hidden" name="studentID" value="<%=student.getStudentID()%>">
						
						<div class="text-center">
								<button type="submit" class="btn btn-info">Add Marks</button>
							</div>
						</form>



						<!--body end here -->
					</div>
				</div>
			</div>


			<jsp:include page="/WEB-INF/views/teacher/Footer.jsp"></jsp:include>

		</div>
	</div>
	

</body>
</html>