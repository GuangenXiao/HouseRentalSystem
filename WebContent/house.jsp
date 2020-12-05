<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="description" content="post house">
<meta name="keywords" content="HTML,CSS,JavaScript">
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
<form method="post"class="form-validate" id="registerFrom" action="${pageContext.request.contextPath}/HouseServlet" enctype="multipart/form-data">
  <fieldset>
    <legend>Please fill in house information</legend>
    <div class="form-group row">
      <label for="staticHead" class="col-sm-2 col-form-label">House picture</label>
	  <div class="aui-info">
        <img src="index.jpg" id="img-txz" style="width: 4rem" class="aui-img-round user-img"/>
        <input type="file" accept="image/*" id="file-txz" name="newPicture" onchange="upload('#file-txz','#img-txz');"  class="fileInput"/>
       </div>
    </div>
    <div class="form-group">
      <label for="exampleInputName">Your Phonenumber</label>
      <input type="tel" class="form-control" name="phonenumber" placeholder="Enter ownerphonenumber">
    </div>
    <div class="form-group">
      <label for="exampleInputEmail1">Email address</label>
      <input type="email" class="form-control" name="Email" aria-describedby="emailHelp" placeholder="Enter email">
      <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
    </div>
    <div class="form-group">
      <label for="exampleInputName">House park</label>
      <input type="tel" class="form-control" name="parknumber" placeholder="Enter park number">
    </div>
    <div class="form-group">
      <label for="exampleInputName">House equipment</label>
      <input type="tel" class="form-control" name="houseEquipment" placeholder="Enter house equipment">
    </div>
    <div class="form-group">
      <label for="exampleInputName">House verification</label>
      <input type="date" class="form-control" name="houseVerification">
    </div>
    <div class="form-group">
      <label for="exampleTextarea">Description of house</label>
      <textarea class="form-control" name="houseDescription" rows="5"></textarea>
    </div>
    <div class="form-group">
      <label for="exampleTextarea">House location</label>
      <textarea class="form-control" name="houseLocation" rows="2"></textarea>
    </div>
    <div class="form-group">
      <label for="exampleTextarea">House fee</label>
      <textarea class="form-control" name="houseFee" rows="2"></textarea>
    </div>
    <button type="submit" class="btn btn-primary">Post</button>
  </fieldset>
</form>
</div>
</body>
</html>