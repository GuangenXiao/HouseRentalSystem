<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="java.util.*"%>
<%@page import="Entity.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<html> 
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="bootstrap.css" />
<link rel="stylesheet" href="style.default.css" id="theme-stylesheet">
<script src="d3.js"></script>
<title>Personal Page</title>
</head>
<body> 
<jsp:include page="/Navbars.jsp"></jsp:include>
<div style="width:100%;height:50px;"></div>
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
<% 
HttpSession httpSession = request.getSession();
User u =(User)httpSession.getAttribute("user");

String gender = null;
if(u.getuGender()!=null)
{
if(u.getuGender()==true)
{
	gender = "male";
}
if(u.getuGender()==false)
{
	gender = "female";
}
}
%>
<div class="golf" style="width:80%;margin-left: auto;margin-right:auto;">
	<div class="photo">
	     <img src="image/<%=u.getuIcon() %>" width="300px" height="350px">
	</div>
	
	
	
	 <form method="post"  class="form-validate" id="loginFrom" action="${pageContext.request.contextPath}/UpdateUserServlet">
	<div class="intro">
	   <div class="form-group row">
        <label for="staticEmail" class="col-sm-2 col-form-label" >User ID:</label>
        <div class="col-sm-10">
          <input type="text" readonly="" class="form-control-plaintext" id="staticEmail" name ="uId" value="<%=u.getuId()%>">
        </div>
        </div>
        
        
        
       <div class="form-group">

       <label for="exampleInputEmail1">Name:</label>
       <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name = "uName" value="<%=u.getuName()%>" placeholder="<%=u.getuName()%>">
       </div>
       
       
       <div class="form-group">
        <label for="exampleInputPassword1">Password:</label>
         <input type="password" class="form-control" id="exampleInputPassword1" name ="uPassword" value="<%=u.getuPassword()%>" placeholder="<%=u.getuPassword()%>">
                <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
       </div>
       
       <div class="form-group">
        <label for="exampleInputPassword1">Phone Number:</label>
         <input type="text" class="form-control" id="exampleInputPassword1" name= "uPhoneNumber" value="<%=u.getuPhoneNumber()%>"  placeholder="<%=u.getuPhoneNumber()%>">
       </div>
       
       <div class="form-group">
        <label for="exampleInputPassword1">Email:</label>
         <input type="email" class="form-control" id="exampleInputPassword1" name ="uEmail"  value="<%=u.getuEmail()%>"  placeholder="<%=u.getuEmail()%>">
       </div>
       
       
       	   <div class="form-group row">
        <label for="staticEmail" class="col-sm-2 col-form-label">Age:</label>
        <div class="col-sm-10">
          <input type="text" readonly="" class="form-control-plaintext" id="staticEmail" value="<%=u.getuAge()%>">
        </div>
    </div>
       
       	
	   <div class="form-group row">
        <label for="staticEmail" class="col-sm-2 col-form-label">Gender:</label>
        <div class="col-sm-10">
          <input type="text" readonly="" class="form-control-plaintext" id="staticEmail" value="<%=gender%>">
        </div>
        </div>
        
       
       
       <div class="form-group">
          <label for="exampleTextarea">Description:</label>
          <textarea class="form-control" id="exampleTextarea" rows="3" name="uDescription" placeholder="<%=u.getuDescription()%>"> <%=u.getuDescription()%></textarea>
       </div>
       
        <div class="form-group">
          <label for="exampleTextarea">Location:</label>
          <textarea class="form-control" id="exampleTextarea" rows="3" name="uLocation" placeholder="<%=u.getuLocation()%>"> <%=u.getuLocation()%></textarea>
       </div>
       
       <div class="form-group row">
        <label for="staticEmail" class="col-sm-2 col-form-label">Money:</label>
        <div class="col-sm-10">
          <input type="text" readonly="" class="form-control-plaintext" id="staticEmail" value="<%=u.getuMoney()%>">
        </div>
        </div>
        	<div style ="margin-bottom:30px;">
	<label>Modify Personal Information</label>
	<button id="login" type="submit" class="btn btn-primary">Submit</button>
	</div>
	</div>
	</form>
</div>
</body>
</html>