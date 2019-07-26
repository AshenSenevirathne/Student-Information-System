<!-- /**
 * @Student_ID : IT18180626
 * @Name : H.M.A.N.Welagedara
 */
 -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>THis is Dashboard</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>

<script src="js/jquery-3.4.0.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid p-0">
      <nav class="navbar navbar-expand-lg navbar-light bg-white static-top shadow">
          <a class="navbar-brand" href="#"><b>Student Information System</b></a>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav ml-auto">
              <li class="nav-item active">
                <a class="nav-link" href="#">Dashboard <span class="sr-only">(current)</span></a>
              </li>
            
            
            <div class="md-form mt-0">
            	<form action="RedirectToDetailsByYear" method="POST">
 				 	<input type = "TEXT" name="year"  class="form-control"  placeholder="Search Year..." aria-label="Search">
				</form> 
			</div>
			 
              
              <li class="nav-item dropdown">
                  <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Services
                  </a>
                  <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item" href="#" data-toggle="modal"
			data-target="#myModal">Add Students </a>
                    <a class="dropdown-item" href="#" data-toggle="modal" data-target="#myModalsub">Add Subjects</a>
                  </div>
                </li>
                
                <li class="nav-item dropdown">
                  <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Views
                  </a>
                  <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                  	<form action="RedirectToStudentListServlet" method="POST">
                    <a class="dropdown-item"><button type="submit" class="btn btn-default">Student List</button></a>
                     </form>
                    <form action="RedirectToSubjectListServlet" method="POST">
                    <a class="dropdown-item" ><button type="submit" class="btn">Subject List</button></a>
                    </form>
                    <form action="RedirectToTimetableListServlet" method="POST">
                    <a class="dropdown-item"><button type="submit" class="btn btn-default">Timetable List</button></a>
                    </form>
                  </div>
                </li>
                
              <li class="nav-item">
                <a class="nav-link" href="#" data-toggle="modal" data-target="#myModaltimetable">Add TimeTables</a>
              </li>
              
              
              
              
              
              
              
              
              
            </ul>
            <div class="nav-item dropdown no-arrow ">
                <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                   <span class="badge badge-pill badge-primary">Anjnai Welagedara</span>
                  <img class="img-profile rounded-circle" src="images/admin/face.jpg" style="width:30px; height:30px;">
                </a>
                <!-- Dropdown - User Information -->
                <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                  <a class="dropdown-item" href="#">
                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                    Profile
                  </a>
                  <a class="dropdown-item" href="#">
                    <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                    Settings
                  </a>
                  <div class="dropdown-divider"></div>
                  <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                    Logout
                  </a>
                </div>
            </div>
          </div>
        </nav>
  </div>
	
	
	
	
	
		
	
		<!-- The Modal add Student-->
		<div class="modal fade" id="myModal">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">

					<!-- Modal Header -->
					<div class="modal-header">

						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>

					<!-- Modal body -->
					<div class="modal-body">

						<form action="AddStudentServlet" method="POST" name="addStudents" name="RegForm"
							onsubmit="return validations_StaffMember()">
							<div class="card border-primary rounded-0">
								<div class="card-header p-0">
									<div class="bg-info text-white text-center py-2">
										<h2>Add Student Details</h2>
									</div>
								</div>
								
								<div class="card-body p-3">

									<!--Body-->
									<div class="form-group">
										<div class="input-group mb-2">
											<div class="input-group-prepend">
												<div class="input-group-text">
													<i class="fa fa-user text-info"></i>
												</div>
											</div>
											<input type="text" class="form-control"
												placeholder="Enter Name"  name="name"  >
										</div>
									</div>
									
									<div class="form-group">
										<div class="input-group mb-2">
											<div class="input-group-prepend">
												<div class="input-group-text">
													<i class="fa fa-comment text-info"></i>
												</div>
											</div>

											<input type="number" class="form-control"
												placeholder="Enter Year" name="year">
										</div>
									</div>

									<div class="form-group">
										<div class="text-center">
											<input type="submit" value="Add Student"
												class="btn btn-info btn-block rounded-0 py-2">
										</div>
									</div>

								</div>
								</div>
						</form>
					</div>

					<!-- Modal footer -->
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
					</div>

				</div>
			</div>
		</div>
	



		<!-- The Modal add subjects-->
		<div class="modal fade" id="myModalsub">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">

					<!-- Modal Header -->
					<div class="modal-header">

						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>

					<!-- Modal body -->
					<div class="modal-body">

						<form action="AddSubjectServlet" method="POST" name="addSubjects"
							onsubmit="return subject_validation()">
							<div class="card border-primary rounded-0">
								<div class="card-header p-0">
									<div class="bg-info text-white text-center py-2">
										<h2>Add Subjects</h2>
									</div>
								</div>
								<div class="card-body p-3">

									<!--Body-->
									<div class="form-group">
										<div class="input-group mb-2">
											<div class="input-group-prepend">
												<div class="input-group-text">
													<i class="fa fa-user text-info"></i>
												</div>
											</div>
											<input type="text" class="form-control" 
												placeholder="Enter Subject Code"  name="subCode"  >
										</div>
									</div>
									<div class="form-group">
										<div class="input-group mb-2">
											<div class="input-group-prepend">
												<div class="input-group-text">
													<i class="fa fa-envelope text-info"></i>
												</div>
											</div>
											<input type="text" class="form-control" 
												 placeholder="Enter Subject Name" name="subName">
										</div>
									</div>

									<div class="form-group">
										<div class="input-group mb-2">
											<div class="input-group-prepend">
												<div class="input-group-text">
													<i class="fa fa-comment text-info"></i>
												</div>
											</div>

											<input type="text" class="form-control" placeholder="Enter Year" name="year">
										</div>
									</div>
									
									<div class="form-group">
										<div class="text-center">
											<input type="submit" value="Add Subject"
												class="btn btn-info btn-block rounded-0 py-2">
										</div>
									</div>

									

								</div>
								</div>
						</form>
					</div>

					<!-- Modal footer -->
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
					</div>

				</div>
			</div>
		</div>

		
			
			<!-- The Modal add Timetable-->
		<div class="modal fade" id="myModaltimetable">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">

					<!-- Modal Header -->
					<div class="modal-header">

						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>

					<!-- Modal body -->
					<div class="modal-body">

						<form action="AddTimeTableServlet" method="POST" name="addtimetables"
							onsubmit="return timeTable_validations()">
							<div class="card border-primary rounded-0">
								<div class="card-header p-0">
									<div class="bg-info text-white text-center py-2">
										<h2>Add Timetable</h2>
									</div>
								</div>
								<div class="card-body p-3">

									<!--Body-->
									<div class="form-group">
										<div class="input-group mb-2">
											<div class="input-group-prepend">
												<div class="input-group-text">
													<i class="fa fa-user text-info"></i>
												</div>
											</div>
											<input type="text" class="form-control" 
												placeholder="Enter Exam Name"  name="examName"  >
										</div>
									</div>
									<div class="form-group">
										<div class="input-group mb-2">
											<div class="input-group-prepend">
												<div class="input-group-text">
													<i class="fa fa-envelope text-info"></i>
												</div>
											</div>
											<input type="number" class="form-control" 
												 placeholder="Enter Year" name="year">
										</div>
									</div>

									
									
									<div class="form-group">
										<div class="text-center">
											<input type="submit" value="Add Timetable"
												class="btn btn-info btn-block rounded-0 py-2">
										</div>
									</div>

									

								</div>
								</div>
						</form>
					</div>

					<!-- Modal footer -->
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
					</div>

				</div>
			</div>
		</div>
</body>
</html>