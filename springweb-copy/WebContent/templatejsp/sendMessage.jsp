<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   

<br/>
<br/> 
<div class="loginhead" ><label >Send a Message</label></div>
<br/>
<br/> <c:url var="url" value="/sendMessageToAdmin"/>
<form:form method="post" action="${url}" commandName="message" >
<table class="t2" align="center" >
<tr class="t2"><td class="t2">Message Title</td><td class="t2"><form:input  path="title" name="title" type="text"/></td>
<td class="t2"><form:errors path="title" cssClass="error"></form:errors></td></tr>
<tr class="t2"><td class="t2">Body</td><td class="t2"><form:textarea  path="msg" name="msg" /></td>
<td class="t2"><form:errors path="msg"  cssClass="error"></form:errors></td></tr>

<tr class="t2"><td class="t2"></td><td class="t2"><input class="submit" value="send" type="submit"></td></tr>
</table>
</form:form>