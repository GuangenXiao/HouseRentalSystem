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
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/Navbars.jsp"></jsp:include>
<%
User user = (User)request.getSession().getAttribute("user");
Integer ID=user.getuId();
IRentService I = new RentService();
ArrayList<Rental> rentallist =I.findReantals(ID); 
int l=0;
%>
<div style="width: 80%;margin-left: auto;margin-right: auto;">
<table class="table table-hover" >
  <thead>
    <tr class="table-primary">
      <th scope="col">Tenant</th>
      <th scope="col">Voluntary housing</th>
      <th scope="col">Proposed amount</th>
      <th scope="col">Start time</th>
      <th scope="col">End time</th>
      <th scope="col">option</th>
    </tr>
  </thead>
<tbody>
  <c:if test="<%=rentallist!=null&&rentallist.size()>0 %>">
  <c:forEach var="book" items="<%=rentallist%>" >
      <% 
      Integer tenantId=null;
      Integer house=null;
      Integer amount=null;
      Date start=null;
      Date end=null;
      Integer rentalID=null;
      if(rentallist.get(l).getrDeal()==null){
      rentalID=rentallist.get(l).getrId();
      tenantId=rentallist.get(l).getrUId();
      house=rentallist.get(l).getrHId();
      amount=rentallist.get(l).getrPrice();
      start=rentallist.get(l).getrStart();
      end=rentallist.get(l).getrEnd();
      }
      l++;
      %>
      <tr>
      <td><%=tenantId %></td>
      <td><%=house %></td>
      <td><%=amount %></td>
      <td><%=start %></td>
      <td><%=end %></td>
      <td>
        <a href="${pageContext.request.contextPath}/SearchRentalSerclet?choose=accpet&rentalId=<%=rentalID %>"><button type="button">Accept</button></a>
        <a href="${pageContext.request.contextPath}/SearchRentalSerclet?choose=reject&rentalId=<%=rentalID %>"><button type="button">Reject</button></a>
      </td>
      </tr>
  </c:forEach>
  </c:if>
  </tbody>
</table> 
</div>
</body>
</html>