<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entity.*"%>
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
HttpSession httpSession = request.getSession();
User u =(User)httpSession.getAttribute("user");
String msg =null;
if(request.getAttribute("msg")!=null)
{
	msg=request.getAttribute("msg").toString();
}
%>
<div class="jumbotron" style=" width: 80%; margin: auto;margin-top: 50px;">
  <font color="red" size="4"><c:if test="<%=msg!=null %>"><%=msg %></c:if></font>
  <c:choose>
  <c:when test="<%=u==null %>"><h1 class="display-3">Welcome to lark Online</h1></c:when>
  <c:otherwise><h1 class="display-3">Welcome,<%=u.getuName() %></h1></c:otherwise>
  </c:choose> 
  <p class="lead">Simple but not simple style, to provide you with a better experience.</p>
  <hr class="my-4">
  <p>If you want to know more about larks, please click the button below!</p>
  <p class="lead">
    <c:choose>
    <c:when test="<%=u==null %>">
    <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath }/login.jsp" role="button">Learn more</a>
  	</c:when>
    <c:otherwise>
  	    <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath }/searchlist.jsp" role="button">Post house</a>
  	</c:otherwise>
  	   </c:choose>
  	</p>
</div>


</body>
</html>