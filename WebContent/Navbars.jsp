<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
<%@page import="Entity.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap.css" />
<link rel="stylesheet" href="style.default.css" id="theme-stylesheet">
<script src="${pageContext.request.contextPath}/d3.js"></script>

<title>Nav</title>
</head>
<body>
<% 
HttpSession httpSession = request.getSession();
User u =(User)httpSession.getAttribute("user");
boolean owner=false ,user=false ,admin=false;
if(u!=null)
{
	if(u.getuType().equals("admin"))admin=true;
	if(u.getuType().equals("owner"))owner=true;
	if(u.getuType().equals("user"))user=true;
}
%>

<nav class="navbar navbar-expand-lg navbar-light bg-light" >
    <a style="margin-left: 20px;" class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">Navbar</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor03" aria-controls="navbarColor03" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarColor03">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
          <a class="nav-link" href="${pageContext.request.contextPath}/index.jsp">Home
            <span class="sr-only">(current)</span>
          </a>
        </li>
        
        <c:if test="<%=u!=null%>">
        <c:if test="<%=owner%>">
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/house.jsp">New House</a>
        </li>
        </c:if>
        </c:if>
        <c:if test="<%=u!=null %>">
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/view.jsp">Office</a>
        </li>
        </c:if>
        
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/searchlist.jsp">House</a>
        </li>
        <c:if test="<%=u!=null%>">
        <c:if test="<%=admin%>">
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/searchUsers.jsp">Users</a>
        </li>
        </c:if>
        </c:if>
        <c:if test="<%=u==null %>">
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/login.jsp">Login</a>
        </li>
        </c:if>
        <c:if test="<%=u!=null %>">
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/LogoutServlet">Logout</a>
        </li>
        </c:if>
      </ul>
       <c:if test="<%=u!=null %>">        
         <p   style="margin-right:50px;color:black;font-size:25px;">Welcome,<%=u.getuName() %></p>
        </c:if>
      <form style="margin-right: 20px;" class="form-inline my-2 my-lg-0">
        <input class="form-control mr-sm-2" type="text" placeholder="Search">
        <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
      </form> 
    </div>
  </nav>
  <div style="width: 100%;height: 80px;" ></div>
</body>
</html>