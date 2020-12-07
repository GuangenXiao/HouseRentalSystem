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
<meta charset="ISO-8859-1">
<meta name="description" content="rent a house">
<meta name="keywords" content="HTML,CSS,JavaScript">
<link rel="stylesheet" href="bootstrap0.css">
<title>HRsys</title>
</head>
<jsp:include page="/Navbars.jsp"></jsp:include>
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
<body>
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
<form method="post"class="form-validate" id="rentFrom" action="${pageContext.request.contextPath}/RentServlet">
  <fieldset>
    <div class="form-group" hidden="hidden">
      <input type="hidden" name="ID" value="<%=houseID%>" />
    </div>
    <div class="form-group">
      <label for="exampleInputName">Start Date</label>
      <input type="date" class="form-control" name="StartDate">
    </div>
    <div class="form-group">
      <label for="exampleInputName">End Date</label>
      <input type="date" class="form-control" name="EndDate">
    </div>
    <div class="form-group">
      <label for="exampleInputName">Amount to be paid (to houseOwner)</label>
      <input type="text" class="form-control" name="money">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
  </fieldset>
</form>
</div>
</body>
</html>