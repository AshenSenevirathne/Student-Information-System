<!-- 
/**
 * @Student_ID : IT18178678
 * @Name : S.M.A.S.Senevirathne
 */
 -->

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
<title>Edit Marks</title>




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
	
					  <%String studentID = request.getParameter("studentID");
					  String studentName = request.getParameter("studentName");
						MarkServices markServices = new MarkServices();
						
						
						List<Marks> list = markServices.getStudentMArk(studentID);
						Iterator<Marks> it_list = list.iterator();
					
					%>
					
					<div class="text-center">
							<div class="card bg-dark text-white"
								style="background-color: #1C2331;">
								<div class="card-body">Edit Marks Of <%=studentName %></div>
							</div>
						</div>
							
						<form action="EditStudentMarksServlet" method="POST">
						<table class="table table-hover table-dark">
							<thead>
								<tr>
									<th scope="col"></th>
									<th scope="col">Subject Name</th>
									<th scope="col">Mark</th>
									
								</tr>
							</thead>
							<%
							while (it_list.hasNext()) {
								Marks marks = new Marks();
								marks = it_list.next();
								
							%>
							<tbody>
								<tr>
									<td><input type ="hidden" name="markID" value="<%=marks.getMarkID()%>"></td>
									<td><%=marks.getSubjectName()%></td>
									<td><input type="number" class="form-control"  name="subjectMark" value="<%=marks.getMark()%>"></td>
									
									



								</tr>
								
							</tbody>
							
							<%
								}
							%>
						</table>
						
						
						
						<div class="text-center">
								<button type="submit" class="btn btn-info">Update Marks Of <%=studentName %></button>
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