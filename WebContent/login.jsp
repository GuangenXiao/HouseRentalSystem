<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Bootstrap Material Admin</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="robots" content="all,follow">
    <link rel="stylesheet" href="bootstrap.css">
  </head>
  <jsp:include page="/Navbars.jsp"></jsp:include>
  <body>
  <%
  String msg =null;
  if(request.getAttribute("msg")!=null)
  {
  	msg=request.getAttribute("msg").toString();
  }
  String id ="";
  if(request.getAttribute("userid")!=null)
  {
  	id=request.getAttribute("userid").toString();
  }
  String password ="";
  if(request.getAttribute("password")!=null)
  {
	password=request.getAttribute("password").toString();
  }
  %>

    <div class="page login-page">
      <div class="container d-flex align-items-center">
        <div class="form-holder has-shadow">
          <div class="row">
            <div class="col-lg-6">
              <div class="info d-flex align-items-center">
                <div class="content">
                  <div class="logo">
                    <h1>Welcome</h1>
                  </div>
                  <p>RHS</p>
                </div>
              </div>
            </div>
            <div class="col-lg-6 bg-white">
              <div class="form d-flex align-items-center">
                <div class="content">
                  <form method="post"  class="form-validate" id="loginFrom" action="${pageContext.request.contextPath}/LoginServlet">
                    <div class="form-group">
                      <input id="login-username" type="text" name="userName" required data-msg="Username" value="<%=id %>" placeholder="Username" class="input-material">
                    </div>
                    <div class="form-group">
                      <input id="login-password" type="password" name="passWord" required data-msg="Password" value="<%=password %>" placeholder="Password" class="input-material">
                    </div>
                    <table cellpadding="0" cellspacing="0" align="center">
    <tr>
    <td>
    RememberMe:&nbsp;&nbsp;
    </td>
          <td >
          <input type="radio"  name="autologin"  value="${60*60*24*31*6}"/>
                   halfYear&nbsp;
      </td>
            <td >
          <input type="radio" name="autologin"  value="${60*60*24*31*3 }"/>
                   ThreeMonth&nbsp;
      </td>
            <td >
          <input type="radio"  name="autologin"  value="${60*60*24*31*1 }"/>
                    OneMonth&nbsp;
      </td>
      </tr>
      </table>
                    
                    <button id="login" type="submit" class="btn btn-primary">Log in</button>

                  </form>
                    <c:if test="<%=msg!=null %>"><%=msg %></c:if>
                  <br />
                  <small>No Account?</small><a href="${pageContext.request.contextPath}/register.jsp" class="signup">&nbsp;Register</a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    
  </body>
</html>