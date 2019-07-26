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
<%@page import="com.oop.service.MarkServices"%>
<%@page import="com.sis.model.Student"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.oop.service.RegisterServices"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Marks</title>

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
						
						
						
						
							MarkServices markServices = new MarkServices();
							List<Student> list2 = markServices.getClassStudentList(className);
							Iterator<Student> it_list2 = list2.iterator();
						
							while (it_list2.hasNext()) {
								Student student = new Student();
								student = it_list2.next();
								
								
								
								
								%>
								
								<div class="text-center">
							<div class="card bg-dark text-white"
								style="background-color: #1C2331;">
								<div class="card-body">Marks Of <%=student.getStudentID()%> : <%=student.getName() %></div>
							</div>
						</div>
								
								
								
								
								<% 
								
								List<Marks> list = markServices.getStudentMArk(student.getStudentID());
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
									<td><%=marks.getSubjectName() %></td>
									<td>
									
								<%if(SubjectMark >= 75){ %>
								<p class="text-warning">A</p>
								
								<% } else if(SubjectMark >= 65){%>
								
								<p class="text-info">B</p>
								 
								
								<% } else if (SubjectMark >= 55){%>
									<p class="text-success">C</p>
								
								
								<% } else if (SubjectMark >= 45){%>
									
								 <p class="text-secondary">S</p>
								
								<% }else{%>
								<p class="text-danger">F</p>
								
								
								<%} %>
									
									
									
									
									
									
									
									
									
									</td>
									<td>
									
								
								<%if(SubjectMark >= 75){ %>
								<div class="progress">
  								<div class="progress-bar bg-warning" role="progressbar" style="width: <%=marks.getMark() %>%;" aria-valuenow="25" 
  								aria-valuemin="0" aria-valuemax="100"><%=marks.getMark() %></div>
								</div>
						
								
								
								
								<% } else if(SubjectMark >= 65){%>
								<div class="progress">
  								<div class="progress-bar bg-info" role="progressbar" style="width: <%=marks.getMark() %>%;" aria-valuenow="25" 
  								aria-valuemin="0" aria-valuemax="100"><%=marks.getMark() %></div>
								</div>
								
								<% } else if (SubjectMark >= 55){%>
									<div class="progress">
  								<div class="progress-bar bg-success" role="progressbar" style="width: <%=marks.getMark() %>%;" aria-valuenow="25" 
  								aria-valuemin="0" aria-valuemax="100"><%=marks.getMark() %></div>
								</div>
								
								
								<% } else if (SubjectMark >= 45){%>
									<div class="progress">
  								<div class="progress-bar bg-secondary" role="progressbar" style="width: <%=marks.getMark() %>%;" aria-valuenow="25" 
  								aria-valuemin="0" aria-valuemax="100"><%=marks.getMark() %></div>
								</div>
								
								
								<% }else{%>
								
								<div class="progress">
  								<div class="progress-bar bg-danger" role="progressbar" style="width: <%=marks.getMark() %>%;" aria-valuenow="25" 
  								aria-valuemin="0" aria-valuemax="100"><%=marks.getMark() %></div>
								</div>
								
								<%} %>
						
									
									</td>


								</tr>

							</tbody>
							

							<%
								}
							%>
						</table>
						
						
						<div class="text-center">
								<form action="JspPageManagerServlet?action=ES" method="POST">
								<input type="hidden" name="studentID" value="<%=student.getStudentID()%>">
								<input type="hidden" name="studentName" value="<%=student.getName()%>">
								<button type="submit" class="btn btn-info">
									Update Marks Of <%=student.getName() %></button>
									</form>
									
								<form action="DeleteMarksOfStudent" method="POST">	
								<input type="hidden" name="studentID" value="<%=student.getStudentID()%>">
								<button type="submit" class="btn btn-danger">
									Delete Marks Of <%=student.getName() %></button>
									</form>
							</div>
							<br><br>
						
						
						<%}%>	
						<!--body end here -->
					</div>
				</div>
			</div>


			<jsp:include page="/WEB-INF/views/teacher/Footer.jsp"></jsp:include>

		</div>
	</div>
						
</body>
</html>