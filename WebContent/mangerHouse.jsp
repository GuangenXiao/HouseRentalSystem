<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="bootstrap.css" />
<link rel="stylesheet" href="style.default.css" id="theme-stylesheet">
<link rel="stylesheet" href="view.css" id="view">
<script src="d3.js"></script>
<title>House Page for manager</title>
</head>
<body> 
<div style="width:100%;height:50px;"></div>

        
<div class="golf" style="width:80%;margin-left: auto;margin-right:auto;">
	<div class="photo">
	     <img src="shu.jpg" width="300" height="350">
	     
	</div>
	
	
	
	<div class="intro">
	   <div class="form-group row">
        <label for="staticEmail" class="col-sm-2 col-form-label">House ID:</label>
        <div class="col-sm-10">
          <input type="text" readonly="" class="form-control-plaintext" id="staticEmail" value="123123123">
        </div>
        </div>
        
        
       <div class="form-group">
       <label for="exampleInputEmail1">House owner ID:</label>
       <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" value="liying zhao" placeholder="Liying Zhao">
       </div>
       
       
       <div class="form-group">
        <label for="exampleInputPassword1">House address:</label>
         <input type="text" class="form-control" id="exampleInputPassword1" value = "123" placeholder="123">
                <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
       </div>
       
       <div class="form-group">
        <label for="exampleInputPassword1">House type:</label>
         <input type="text" class="form-control" id="exampleInputPassword1" value = "911" placeholder="911">
       </div>
       
       <div class="form-group">
        <label for="exampleInputPassword1">House Size:</label>
         <input type="text" class="form-control" id="exampleInputPassword1" value = "125478@qq.com" placeholder="125478@qq.com">
       </div>
       
       <div class="form-group">
        <label for="exampleInputPassword1">House equipment:</label>
         <input type="text" class="form-control" id="exampleInputPassword1" value = "28" placeholder="28">
       </div>
       
       <div class="form-group">
        <label for="exampleInputPassword1">House park:</label>
         <input type="text" class="form-control" id="exampleInputPassword1" value = "28" placeholder="28">
       </div>
       
        <div class="form-group">
        <label for="exampleInputPassword1">House building date:</label>
         <input type="text" class="form-control" id="exampleInputPassword1" value = "28" placeholder="28">
       </div>
       
       <div class="form-group">
        <label for="exampleInputPassword1">House description:</label>
         <textarea class="form-control" id="exampleTextarea" rows="3">I am super star!</textarea>
       </div>
       
       <div class="form-group">
        <label for="exampleInputPassword1">House energy:</label>
         <input type="text" class="form-control" id="exampleInputPassword1" value = "28" placeholder="28">
       </div>
       
       <div class="form-group">
          <label for="exampleTextarea">00 : 00</label>
          <input type="checkbox" onclick="chose(this)" name="c" value="YES"/>Yes
          <input type="checkbox" onclick="chose(this)" name="d" value="NO"/>No
              
       </div>
       
        <button type="button">submit</button> 
       <div style="width:100%;height:100px;"></div>
	</div>
	
</div>

</body>
</html>