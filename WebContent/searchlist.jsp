<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="Entity.*"%>
    <%@page import="Service.*"%>
    <%@page import="java.util.ArrayList"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/Navbars.jsp"></jsp:include>
<%
IHouseService ibs = new HouseService();
ArrayList<HouseType> typelist =ibs.findHTypes(); 
int i=0;
%>
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
      <c:forEach var="HouseType" items="<%=typelist%>" >
      <% 
      String tName=typelist.get(i).gettContext();
      i++;
      tName=i+"---"+tName;
      %>
      <option ><%=tName %></option>
      </c:forEach>
      </select>
      </td>
      <td>
    <button type="submit" class="btn btn-primary" >search</button>
    </td>
    </tr>
</table>
</div>
</form>


<%  
ArrayList<House> houselist =null; 
HttpSession httpSession =request.getSession();
houselist =(ArrayList<House>)httpSession.getAttribute("houselist");
int l=0;
%>
<div style="width: 80%;margin-left: auto;margin-right: auto;">
<table class="table table-hover" >
  <thead>
    <tr class="table-primary">
      <th scope="col">Picture</th>
      <th scope="col">Address</th>
      <th scope="col">Equipment</th>
      <th scope="col">Description</th>
    </tr>
  </thead>
<tbody>
  <c:if test="<%=houselist!=null&&houselist.size()>0 %>">
  <c:forEach var="book" items="<%=houselist%>" >
        <% 
      Integer hId=houselist.get(l).gethId();
      String hPicture=houselist.get(l).gethPicture();
      String hAddress =houselist.get(l).gethAddress();
      String hEquipment =""+houselist.get(l).gethEquipment();
      String hDes =houselist.get(l).gethDescription();
      l++;
      %>
      <tr>
      <th scope="row"><a href="${pageContext.request.contextPath}/houserent.jsp?houseId=<%=hId %>"><img src="image/<%=hPicture %>" alt="<%=hPicture %>"  width="80" height="50" ></a></th>
      <td><%=hAddress %></td>
      <td><%=hEquipment %></td>
      <td><%=hDes %></td>
    </tr>
  </c:forEach>
  </c:if>
  </tbody>
</table> 
</div>

</body>
</html>