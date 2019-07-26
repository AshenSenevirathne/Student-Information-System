<!-- 
/**
 * @Student_ID : IT18178678
 * @Name : S.M.A.S.Senevirathne
 */
 -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Upload Assignments</title>

</head>
<body>


<div class="wrapper">
		<div class="main-panel">

			<jsp:include page="/WEB-INF/views/teacher/SideBar.jsp"></jsp:include>


	<br><br>
	<form action="AddAssignmentServlet" method="POST">
	<div class="content">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-12">
					<div class="card">
						<div class="header">
							<h4 class="display-4">Upload Assignment</h4>
						</div>
						<div class="content">
							<form>
								<div class="row">
									<div class="col-md-5">
										<div class="form-group">
											<label>Assignment Name</label> <input type="text"
												class="form-control" name="assignmentName" placeholder="Assignment Name">
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group">
											<label>Subject ID</label> <input type="text"
												class="form-control" placeholder="Subject ID"
												name="subID">
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<label for="exampleInputEmail1">Deadline</label> <input
												type="date" class="form-control" placeholder="Deadline" name="deadline">
										</div>
									</div>
								</div>


								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
											<label>Description</label> <input type="text"
												class="form-control" placeholder="Description" name="description"
												>
										</div>
									</div>
								</div>




								<button type="submit" class="btn btn-info btn-fill pull-right">Add Assignment</button>
								<div class="clearfix"></div>
							</form>
						</div>
					</div>
				</div>


			</div>
		</div>
	</div>
</form>





	<jsp:include page="/WEB-INF/views/teacher/Footer.jsp"></jsp:include>

	</div>
	</div>






</body>
</html>