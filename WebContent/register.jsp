<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="description" content="regisgter for new user">
<meta name="keywords" content="HTML,CSS,JavaScript">
<meta name="author" content="Hao Yuan">
<link rel="stylesheet" href="bootstrap0.css">
<title>HRsys</title>
</head>
<jsp:include page="/Navbars.jsp"></jsp:include>
<script type="text/javascript">
    var upload = function (c, d) {
        "use strict";
        var $c = document.querySelector(c),
            $d = document.querySelector(d),
            file = $c.files[0],
            reader = new FileReader();
        reader.readAsDataURL(file);
        reader.onload = function (e) {
            $d.setAttribute("src", e.target.result);
        };
    };
</script>
<%
  String msg =null;
  if(request.getAttribute("msg")!=null)
  {
  	msg=request.getAttribute("msg").toString();
  }
  %>
<body>
<div class="jumbotron" style ="margin-left:10%;width:80%;">
<c:if test="<%=msg!=null %>"><%=msg %></c:if>
<form method="post"class="form-validate" id="registerFrom" action="${pageContext.request.contextPath}/RegisterServlet" enctype="multipart/form-data">
  <fieldset>
    <legend>Please fill in your basic information</legend>
    <div class="form-group row">
      <label for="staticHead" class="col-sm-2 col-form-label">Head-portrait</label>
	  <div class="aui-info">
        <img src="index.jpg" id="img-txz" style="width: 4rem" class="aui-img-round user-img"/>
        <input type="file" accept="image/*" id="file-txz" name="newPicture" onchange="upload('#file-txz','#img-txz');"  class="fileInput"/>
       </div>
    </div>
    <div class="form-group">
      <label for="exampleInputName">User name</label>
      <input type="text" class="form-control" name="userName" placeholder="Enter Username">
      <small id="emailHelp" class="form-text text-muted">The user name should be a combination of 8-16 digits</small>
    </div>
    <div class="form-group">
      <label for="exampleInputName">User Phonenumber</label>
      <input type="tel" class="form-control" name="userphonenumber" placeholder="Enter phonenumber">
    </div>
    <div class="form-group">
      <label for="exampleInputName">User Birthday</label>
      <input type="date" class="form-control" name="userBirthday">
    </div>
    <div class="form-group">
      <label for="exampleInputEmail1">Email address</label>
      <input type="email" class="form-control" name="userEmail" aria-describedby="emailHelp" placeholder="Enter email">
      <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
    </div>
    <div class="form-group">
      <label for="exampleInputPassword1">Password</label>
      <input type="password" class="form-control" name="userPassword" placeholder="Password">
    </div>
    <div class="form-group">
      <label for="exampleTextarea">Your short description</label>
      <textarea class="form-control" name="userDescription" rows="5"></textarea>
    </div>
    <div class="form-group">
      <label for="exampleTextarea">Your location</label>
      <textarea class="form-control" name="userLocation" rows="2"></textarea>
    </div>
    <fieldset class="form-group">
      <legend>Select your gender</legend>
      <div class="form-check">
        <label class="form-check-label">
          <input type="radio" class="form-check-input" name="Gender" id="optionsRadios1" value="1" checked="">
          male
        </label>
      </div>
      <div class="form-check">
        <label class="form-check-label">
          <input type="radio" class="form-check-input" name="Gender" id="optionsRadios2" value="0">
          female
        </label>
      </div>
    </fieldset>
   <fieldset class="form-group">
      <legend>Select your user type</legend>
      <div class="form-check">
        <label class="form-check-label">
          <input type="radio" class="form-check-input" name="userType" id="optionsRadios1" value="user" checked="">
          Tenant
        </label>
      </div>
      <div class="form-check">
        <label class="form-check-label">
          <input type="radio" class="form-check-input" name="userType" id="optionsRadios2" value="owner">
          HouseOwner
        </label>
      </div>
    </fieldset>
    <button type="submit" class="btn btn-primary">Submit</button>
  </fieldset>
</form>
</div>
</body>
</html>