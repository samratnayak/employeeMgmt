<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<%
	int i = 1;
%>
<br /><c:url var="del"  value='/delete'/>
<c:if test="${not empty delete}"> <p class="t1" onload="javascript:deleteSuccess()" >Successfully deleted : ${delete}</p> </c:if>
<form:form action="${del}" method="post" onsubmit="return confirmDelete()" >
<table class="t1">
	<tr class="heading">
		<td>S.No</td>
		<td>EMP Id</td>
		<td>Emp Name</td>
		<td>Email</td>
		<td>IOU</td>
		<td>Delete</td>
	</tr>
	<c:forEach var="emp" items="${empList}">

		<tr id="mytable" class="t1">
			<td class="data"><%=i++%></td>
			<td class="data"><a class="link_menu"
				href="${pageContext.request.contextPath}/editEmp/${emp.id}">${emp.id}</a></td>
			<td class="data">${emp.name}</td>
			<td class="data">${emp.email}</td>
			<td class="data">${emp.iou}</td>
			<td class="data"><input type="checkbox" value="${emp.id}" name="deleteCheck"
				onclick=""></td>
		</tr>
	</c:forEach>
</table>
<div class="submitbutton">
<%-- <a class="link_menu"
				href="${pageContext.request.contextPath}/editEmp/test">Test</a> --%>
<sec:authorize access="hasAuthority('admin')" >
<input name="deleteEmp" class="deleteEmp" type="submit" value="Delete" />
</sec:authorize>
</div>
</form:form>
