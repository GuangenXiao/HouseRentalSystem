<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>House information</title>
<jsp:include page="/Navbars.jsp"></jsp:include>
<style type = "text/css">
  .back
  {
  width:100%;
  height:100%;
  background:url('image/back.jpg');
  background-repeat: no-repeat;
  background-position: 0px, 0px;
  background-size:cover;
  background-attachment:fixed;
 }
</style>
</head>
<body>
<div class = "back">
<div class="progress">
  <div class="progress-bar progress-bar-striped progress-bar-animated" role="progressbar" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100" style="width: 75%;">
  </div>
</div>
		<div class="card mb-3" style ="margin-left:10%;width:80%;">
  		<h3 class="card-header">Basic information</h3>
  		<p class = "card-header">House picture</p>
  		<div class="aui-info">
        	<img src="index.jpg" id="img-txz" style="width: 20rem" class="aui-img-round user-img"/>
        	<img src="index.jpg" id="img-txz" style="width: 20rem" class="aui-img-round user-img"/>
        	<img src="index.jpg" id="img-txz" style="width: 20rem" class="aui-img-round user-img"/>
   		</div>
  		<ul class="list-group list-group-flush">
  		<li class="list-group-item">Owner email: </li>
  		<li class="list-group-item">Owner phone number: </li>
    	<li class="list-group-item">House equipment: </li>
    	<li class="list-group-item">House parking number: </li>
        <li class="list-group-item">House description: </li>
    	<li class="list-group-item">House location: </li>
    	<li class="list-group-item">Valid period: </li>
    	<li class="list-group-item">Fee per month: </li>
  		</ul>
		</div>
</div>
</body>
</html>