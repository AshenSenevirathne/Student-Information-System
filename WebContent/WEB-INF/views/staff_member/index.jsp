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

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>



</head>
<body>


	<div class="container">
		<jsp:include page="/WEB-INF/views/staff_member/DashBoard.jsp"></jsp:include>

				
	  <div class="container-fluid">
    <div class="row mt-5 justify-content-center">
      <div class="row-md-3 mr-5">
        <button type="button" class="btn">
          <div class="card border-primary bg-gradient-1 static-top shadow" style="max-width: 18rem;">
              <div class="card-body">
                <h5 class="card-title"><b>Add subject</b></h5>
                <img src="images/admin/teacher.png" class="mainNavigationPhoto" style="width:200px; height:150px;">
              </div>
            </div>
          </button>
      </div>
      <div class="row-md-3 mr-5">
          <button type="button" class="btn">
          <div class="card border-primary bg-gradient-2 static-top shadow" style="max-width: 18rem;">
              <div class="card-body">
                <h5 class="card-title"><b>Add Students</b></h5>
                <img src="images/admin/question.png" class="mainNavigationPhoto" style="width:200px; height:150px;">
              </div>
          </div>
        </button>
      </div>
      <div class="row-md-3 mr-5">
          <button type="button" class="btn">
          <div class="card border-primary bg-gradient-3 static-top shadow" style="max-width: 18rem;">
              <div class="card-body">
                <h5 class="card-title"><b>Payment Details</b></h5>
                <img src="images/admin/payment.png" class="mainNavigationPhoto" style="width:200px; height:150px;">
              </div>
            </div>
          </button>
      </div>
      <div class="row-md-3 mr-5">
          <button type="button" class="btn">
          <div class="card border-primary bg-gradient-4 static-top shadow" style="max-width: 18rem;">
              <div class="card-body">
                <h5 class="card-title"><b>Service Info</b></h5>
                <img src="images/admin/payment.png" class="mainNavigationPhoto" style="width:200px; height:150px;">
              </div>
          </div>
        </button>
      </div>
    </div>
</div>

			
			


	</div>
	<script src="js/jquery-3.4.0.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

</body>
</html>