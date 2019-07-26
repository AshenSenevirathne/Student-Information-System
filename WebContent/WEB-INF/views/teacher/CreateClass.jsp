<!-- 
/**
 * @Student_ID : IT18178678
 * @Name : S.M.A.S.Senevirathne
 */
 -->

<%@page import="com.sis.model.Teacher"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Create Class</title>
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
						%>

						<form method="POST" action="AddClassServlet" name="RegForm"
							onsubmit="return classValidations()">
							<div class="content">
								<div class="container-fluid">
									<div class="row">
										<div class="col-md-12">

											<div class="header">
												<h4 class="display-3">Create A Class</h4>
											</div>
											<div class="content">

												<div class="row">
													<div class="col-md-3">
														<div class="form-group">
															<label>Year</label> <input type="number"
																class="form-control" placeholder="Enter Year"
																name="year">
														</div>
													</div>
													<div class="col-md-5">
														<div class="form-group">
															<label>Class name</label> <input type="text"
																class="form-control" placeholder="Enter Name"
																name="className">
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label for="exampleInputEmail1">No Of Students</label> <input
																type="number" class="form-control"
																placeholder="Enter Count" name="studentNo">
														</div>
													</div>
												</div>

												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label>Teacher Name</label> <input type="text"
																class="form-control" placeholder="Enter Name"
																name="teacherName">
														</div>
													</div>
													<div class="col-md-6">
														<div class="form-group">
															<label>Hall</label> <input type="text"
																class="form-control" placeholder="Enter Hall"
																name="hall">
														</div>
													</div>
												</div>


												<input type="hidden" name="userName" value="<%=userName%>">
												<button type="submit"
													class="btn btn-info btn-fill pull-right">Create</button>
												<div class="clearfix"></div>

											</div>
										</div>
									</div>



								</div>
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