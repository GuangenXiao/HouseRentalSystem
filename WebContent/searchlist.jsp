<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/Navbars.jsp"></jsp:include>
<form action="${pageContext.request.contextPath }/SearchHouseServlet" method="post">
<div  style="width: 80%;margin-left: auto;margin-right: auto;">
<table class="table table-hover" style="text-align: center;font-size:20px;">
<tr>
<td>
      <label for="exampleSelect2">HOUSE INFO:</label></td>
      <td>
      <input type="text" placeholder="inoformation abuout house,such like location"  class="form-control-plaintext" name="HouseInfo"/></td>
      <td>
      <label for="exampleSelect1">HOUSE TYPE:</label>
      </td>
      <td>
      <select class="form-control" id="exampleSelect1" name="HouseTypeSelect">
      <option >0---general</option>
      </select>
      </td>
      <td>
    <button type="submit" class="btn btn-primary" >search</button>
    </td>
    </tr>
</table>
</div>
</form>
<div style="width: 80%;margin-left: auto;margin-right: auto;">
<table class="table table-hover" >
  <thead>
    <tr class="table-primary">
      <th scope="col">house ID</th>
      <th scope="col">House Type</th>
      <th scope="col">Owner</th>
      <th scope="col">Location</th>
    </tr>
  </thead>
  <tbody>
      <tr>
      <th scope="row">1</th>
      <td>apartement</td>
      <td>GuangenXIao</td>
      <td>Ireland Limerick</td>
    </tr>
  </tbody>
</table> 
</div>

</body>
</html>