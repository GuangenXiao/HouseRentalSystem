<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="bootstrap.css" />
<link rel="stylesheet" href="style.default.css" id="theme-stylesheet">
<script src="d3.js"></script>
<title>Personal Page</title>
</head>
<body> 
<div class="jumbotron">
  <h1 class="display-3">Personal Information</h1>
  <p class="lead">There is your personal information and you can change it here.</p>
  <hr class="my-4">
</div>
<style>
.photo{
    float:left;
    width:30%;
}
.intro{
    float:right;
    width:60%;
}
</style>
<div class="golf">
	<div class="photo">
	     <img src="zly.jpg" width="300" height="350">
	</div>
	
	
	<div class="intro">
	   <div class="form-group row">
        <label for="staticEmail" class="col-sm-2 col-form-label">ID:</label>
        <div class="col-sm-10">
          <input type="text" readonly="" class="form-control-plaintext" id="staticEmail" value="123123123">
        </div>
        </div>
        
        
       <div class="form-group">

       <label for="exampleInputEmail1">Name:</label>
       <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Liying Zhao">
       </div>
       
       
       <div class="form-group">
        <label for="exampleInputPassword1">Password:</label>
         <input type="password" class="form-control" id="exampleInputPassword1" placeholder="123">
                <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
       </div>
       
       <div class="form-group">
        <label for="exampleInputPassword1">Phone Number:</label>
         <input type="password" class="form-control" id="exampleInputPassword1" placeholder="911">
       </div>
       
       <div class="form-group">
        <label for="exampleInputPassword1">Emil:</label>
         <input type="password" class="form-control" id="exampleInputPassword1" placeholder="125478@qq.com">
       </div>
       
       <div class="form-group">
        <label for="exampleInputPassword1">Age:</label>
         <input type="password" class="form-control" id="exampleInputPassword1" placeholder="28">
       </div>
       
       <div class="form-group">
        <label for="exampleInputPassword1">Gender:</label>
         <input type="password" class="form-control" id="exampleInputPassword1" placeholder="female">
       </div>
       
       <div class="form-group">
          <label for="exampleTextarea">Description:</label>
          <textarea class="form-control" id="exampleTextarea" rows="3">I am super star!</textarea>
       </div>
       
        <div class="form-group">
          <label for="exampleTextarea">Location:</label>
          <textarea class="form-control" id="exampleTextarea" rows="3">New York!</textarea>
       </div>
       
       <div class="form-group row">
        <label for="staticEmail" class="col-sm-2 col-form-label">Money:</label>
        <div class="col-sm-10">
          <input type="text" readonly="" class="form-control-plaintext" id="staticEmail" value="300">
        </div>
        </div>
	</div>
</div>
</body>
</html>