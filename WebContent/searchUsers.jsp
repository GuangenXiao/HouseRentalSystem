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

<form action="${pageContext.request.contextPath }/SearchUserServlet" method="post">
<div  style="width: 80%;margin-left: auto;margin-right: auto;">
<table class="table table-hover" style="text-align: center;font-size:20px;">
<tr>
<td>
      <label for="exampleSelect2">USER INFO:</label></td>
      <td>
      <input type="text" placeholder="inoformation abuout house,such like location"  class="form-control-plaintext" name="UserInfo"/></td>
      <td>
      <label for="exampleSelect1">USER TYPE:</label>
      </td>
      <td>
      <select class="form-control" id="exampleSelect1" name="UserTypeSelect">
      <option >General</option>
      <option >Normal User</option>
      <option >Houser Owner</option>
      <option >Administrator</option>
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
ArrayList<User> userlist =null; 
if(request.getAttribute("userlist")!=null)
{
	userlist =(ArrayList<User>)request.getAttribute("userlist");
}
int l=0;
%>
<div style="width: 80%;margin-left: auto;margin-right: auto;">
<table class="table table-hover" >
  <thead>
    <tr class="table-primary">
      <th scope="col">UserId</th>
      <th scope="col">UserName</th>
      <th scope="col">Email</th>
      <th scope="col">PhoneNumber</th>
      <th scope="col">Location</th>
      <th scope="col">Description</th>
    </tr>
  </thead>
<tbody>
  <c:forEach var="book" items="<%=userlist%>" >
        <% 
      Integer UserId=userlist.get(l).getuId();
      String UserName =userlist.get(l).getuName();
      String Email =userlist.get(l).getuEmail();
      String PhoneNumber =userlist.get(l).getuPhoneNumber();
      String Location = userlist.get(l).getuLocation();
      String Description = userlist.get(l).getuDescription();
      l++;
      %>
      <tr>
      <th scope="row"><%=UserId %></th>
      <td><%=UserName %></td>
      <td><%=Email %></td>
      <td><%=PhoneNumber %></td>
      <td><%=Location %></td>
      <td><%=Description %></td>
    </tr>
  </c:forEach>
  </tbody>
</table> 
</div>

</body>
</html>