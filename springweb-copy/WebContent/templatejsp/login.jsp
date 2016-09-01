<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<br/>
	<br/>
<div class="loginhead" > <label > Login with Username and Password </label> </div>
	<form name='f' action='${pageContext.request.contextPath}/login' method='POST'>
		
		<c:if test="${not empty errorMsg}">
		<div align="center" class="error">${errorMsg}</div>
		</c:if>
		<c:if test="${param.logout!=null}">
		<p align="center" >Logged out!!</p>
		</c:if>
	<br/>
	<br/>	
		<table align="center" class="t2" >
			<tr class="t2">
				<td class="t2">Username</td>
				<td class="t2"><input class="textbox" type='text' name='username' ></td>
			</tr>
			<tr class="t2">
				<td class="t2">Password</td>
				<td class="t2"><input class="textbox" type='password' name='password' /></td>
			</tr>
			<!-- <tr>
			<td></td>
				<td ><input name="remeber-me" type="checkbox" checked="checked" />Remeber me</td>
			</tr> -->
			<tr class="t2">
			<td class="t2"></td>
				<td class="t2"><input class="submit" name="submit" type="submit"
					value="Login" /></td>
			</tr>
			<tr class="t2" >
				<td class="t2"></td>
				<td class="t2"><p>
						<a class="link_menu" href="${pageContext.request.contextPath}/displayUserForm">Register</a>
					</p></td>
			</tr>
		</table>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
