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
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.oop.service.MarkServices"%>
<%@page import="com.sis.model.ClassPlaceList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Place List</title>

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
								<div class="card-body">Class Place List</div>
							</div>
						</div>

						<%
							Teacher teacher = (Teacher) session.getAttribute("User");
							int userName = teacher.getTeacherId();
						
							IClassServices iClassServices = new ClassesServices();
							String className = iClassServices.getClassName(userName);
							Clases clases = iClassServices.getClassDetails(className);

							MarkServices markServices = new MarkServices();
							List<ClassPlaceList> list = markServices.getStudentPlaceList(className);
							Iterator<ClassPlaceList> it_list = list.iterator();
							int count = 1;
							DecimalFormat form = new DecimalFormat("0.00");
						%>

						<table class="table table-hover table-dark">
							<thead style="color: white">
								<tr>

									<th scope="col">Student ID</th>
									<th scope="col">Name</th>
									<th scope="col">Total Marks</th>
									<th scope="col">Total Subjects</th>
									<th scope="col">Average</th>
									<th scope="col">Place</th>
								</tr>
							</thead>
							<%
								while (it_list.hasNext()) {
									ClassPlaceList classPlaceList = new ClassPlaceList();
									classPlaceList = it_list.next();
							%>
							<tbody>
								<tr>


									<td><%=classPlaceList.getStudentID()%></td>
									<td><%=classPlaceList.getName()%></td>
									<td><%=classPlaceList.getSum()%></td>
									<td><%=classPlaceList.getTotalSubject()%></td>
									<td><%=form.format(classPlaceList.getAvg())%></td>
									<td><%=count%></td>
							</tbody>

							<%
								count++;
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