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
<form method="post"class="form-validate" id="registerFrom" action="${pageContext.request.contextPath}/HouseServlet" enctype="multipart/form-data">
  <fieldset>
 <font color="red" size="4"><c:if test="<%=msg!=null %>"><%=msg %></c:if></font>
    <legend>Please fill in house information</legend>
    <div class="form-group row">
      <label for="staticHead" class="col-sm-2 col-form-label">House picture</label>
	  <div class="aui-info">
        <img src="index.jpg" id="img-txz" style="width: 4rem" class="aui-img-round user-img"/>
        <input type="file" accept="image/*" id="file-txz" name="Picture of house" onchange="upload('#file-txz','#img-txz');"  class="fileInput"/>
       </div>
    </div>
    <div class="form-group">
      <label for="exampleSelect1">House Type Select</label>
      <select class="form-control" name="HouseType">
        <option value=1>apartment</option>
        <option value=2>compound apartment</option>
        <option value=3>low block</option>
        <option value=4>mansion</option>
        <option value=5>datcha</option>
      </select>
    </div>
     <div class="form-group">
      <label for="exampleSelect1">Energy consumption level</label>
      <select class="form-control" name="HouseEnergy">
        <option value=1>A1</option>
        <option value=2>A2</option>
        <option value=3>A3</option>
        <option value=4>B1</option>
        <option value=5>B2</option>
        <option value=6>B3</option>
        <option value=7>C1</option>
        <option value=8>C2</option>
        <option value=9>C3</option>
        <option value=10>D</option>
      </select>
    </div>
    <div class="form-group">
      <label for="exampleInputEmail1">House address</label>
      <input type="text" class="form-control" name="HouseAddress" aria-describedby="emailHelp" placeholder="Ireland,Limerick">
      <small id="emailHelp" class="form-text text-muted">The form of address should be:Country, city</small>
    </div>
    <div class="form-group">
      <label for="exampleInputName">House park number</label>
      <input type="text" class="form-control" name="HouseParknumber" placeholder="Enter park number">
      <small id="emailHelp" class="form-text text-muted">How many parking spaces can your house provide</small>
    </div>
    <div class="form-group">
      <label for="exampleInputName">House completion date</label>
      <input type="date" class="form-control" name="HouseBirthday">
    </div>
    <div class="form-group">
      <label for="exampleInputName">House equipment</label>
      <input type="text" class="form-control" name="houseEquipment" placeholder="Example:Refrigerator, kitchenware, TV">
      <small id="emailHelp" class="form-text text-muted">Please use "," to separate the infrastructure provided by your house</small>
    </div>
    <div class="form-group">
      <label for="exampleTextarea">Description of house</label>
      <textarea class="form-control" name="houseDescription" rows="5"></textarea>
    </div>
    <div class="form-group">
      <label for="exampleTextarea">House Size(square metre)</label>
      <input type="text" class="form-control" name="Housesize">
    </div>
    <button type="submit" class="btn btn-primary">Post</button>
  </fieldset>
</form>
</div>
</body>
</html>