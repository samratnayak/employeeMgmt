<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<div class="loginhead" >
<p  align="center">AN ERROR OCCURRED </p> </div> <br/>
<c:if test="${not empty error}">
<p  align="center" style="color:red"><b> ${error}</b>  </p>
<p  align="center" style="color:blue"> <a class="link_menu" href="<c:url value='/mylogin' />">Go to Login</a></p>
</c:if>
