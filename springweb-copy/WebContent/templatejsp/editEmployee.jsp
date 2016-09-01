<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   

<br/>
<br/> 
<div class="loginhead" ><label >Edit an Employee</label></div>
<br/>
<br/> 
<form:form method="post" action="${pageContext.request.contextPath}/createEmp" commandName="employee" >
<table class="t2" align="center" >
<c:if test="${!empty employee.name}">
<tr class="t2"><td class="t2">Emp Id</td><td class="t2"><form:label path="id" readonly="true" size="8" >${employee.id}</form:label><form:hidden path="id"/></td></tr></c:if>
<tr class="t2"><td class="t2">Emp Name</td><td class="t2"><form:input cssClass="textbox" path="name" name="name" type="text"/></td>
<td class="t2"><form:errors path="name" cssClass="error"></form:errors></td></tr>
<tr class="t2"><td class="t2">Email</td><td class="t2"><form:input cssClass="textbox" path="email" name="email" type="text"/></td>
<td class="t2"><form:errors path="email"  cssClass="error"></form:errors></td></tr>
<tr class="t2"><td class="t2">Dept</td><td class="t2"><form:select cssClass="drpdwn" path="iou" name="iou">
<c:forEach var="iou" items="${ious}" >
<c:choose>
	<c:when test="${iou.id eq employee.iou}">
		<form:option  value= "${iou.id}" selected="true">${iou.getName()}</form:option>
	</c:when>	
	<c:otherwise>
		<form:option value="${iou.id}">${iou.getName()}</form:option>
	</c:otherwise>
</c:choose>
</c:forEach>

</form:select></td>
<td class="t2"><form:errors path="iou" cssClass="error"></form:errors></td></tr>
<tr class="t2"><td class="t2"></td><td class="t2"><input value="Update" class="submit" type="submit"></td></tr>
</table>
</form:form>