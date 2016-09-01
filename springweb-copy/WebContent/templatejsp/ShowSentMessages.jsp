<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<%
	int i = 1;
%>
<br />
<table class="t1">
	<tr class="heading">
		<td>Serial No.</td>
		<td>Msg Id</td>
		<td>Message Title</td>
		<td>Message</td>
		
	</tr>
	<c:forEach var="msg" items="${msgList}">

		<tr id="mytable" class="t1">
			<td class="data"><%=i++%></td>
			<td class="data">${msg.id}</td>
			<td class="data">${msg.title}</td>
			<td class="data">${msg.msg}</td>
			
		</tr>
	</c:forEach>
</table>
<div class="submitbutton">
<%-- <a class="link_menu"
				href="${pageContext.request.contextPath}/editmsg/test">Test</a> --%>

</div>

