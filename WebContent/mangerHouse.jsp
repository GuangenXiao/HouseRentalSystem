<%@page import="Util.Timeconverter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="Entity.*"%>
    <%@page import="Service.*"%>
    <%@page import="java.util.*"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
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
<%
           String houseID=request.getParameter("houseId");
		   IHouseService target = new HouseService();
		   House H= target.serachhouseById(houseID);
		   String HouseAddress=H.gethAddress();
		   Integer HouseTypecode=H.gethType();
		   Integer HouseOwner=H.gethOwnerId();
		   String HouseType=null;
		   if(HouseTypecode==1){
			   HouseType="apartment";
		   }else if(HouseTypecode==2){
			   HouseType="compound apartment";
		   }else if(HouseTypecode==3){
			   HouseType="low block";
		   }else if(HouseTypecode==4){
			   HouseType="mansion";
		   }else if(HouseTypecode==5){
			   HouseType="datcha";
		   }
		   Integer Housesize=H.gethSize();
		   Date Housedate=H.gethDate();
		   String Houselel=H.gethEnergy();
		   Integer Housepark=H.gethPark();
		   String HouseDec=H.gethDescription();
		   String HouseImage=H.gethPicture();
%>
<jsp:include page="/Navbars.jsp"></jsp:include>
<div style="width:100%;height:50px;"></div>

        
<div class="jumbotron" style ="margin-left:10%;width:80%;">
<div class="card mb-3">
  <h3 class="card-header">House details</h3>
  <div class="card-body">
    <h5 class="card-title">House image</h5>
  </div>
  <img src="image/<%=HouseImage %>" alt="<%=HouseImage %>"  width="800" height="250" >
  <ul class="list-group list-group-flush">
    <li class="list-group-item"><font color="red" size="4">House Address</font></li>
    <li class="list-group-item"><%=HouseAddress %></li>
  </ul>
  <ul class="list-group list-group-flush">
    <li class="list-group-item"><font color="red" size="4">House Type</font></li>
    <li class="list-group-item"><%=HouseType %></li>
  </ul>
  <ul class="list-group list-group-flush">
    <li class="list-group-item"><font color="red" size="4">House Size</font></li>
    <li class="list-group-item"><%=Housesize %></li>
  </ul>
   <ul class="list-group list-group-flush">
    <li class="list-group-item"><font color="red" size="4">House abbreviation date</font></li>
    <li class="list-group-item"><%=Housedate %></li>
  </ul>
   <ul class="list-group list-group-flush">
    <li class="list-group-item"><font color="red" size="4">House energy consumption level</font></li>
    <li class="list-group-item"><%=Houselel %></li>
  </ul>
  <ul class="list-group list-group-flush">
    <li class="list-group-item"><font color="red" size="4">Parking spaces provided</font></li>
    <li class="list-group-item"><%=Housepark %></li>
  </ul>
   <ul class="list-group list-group-flush">
    <li class="list-group-item"><font color="red" size="4">Introduction to the house</font></li>
    <li class="list-group-item"><%=HouseDec %></li>
  </ul>
</div>
      <form  method="post"class="form-validate" id="rentFrom" action="${pageContext.request.contextPath}/HouseMangeServlet" >
      <input name = "houseId"  hidden value ="<%=houseID%>" >
        <button class="btn btn-secondary my-2 my-sm-0" type="submit">Delete</button>
      </form> 	
</div>

</body>
</html>