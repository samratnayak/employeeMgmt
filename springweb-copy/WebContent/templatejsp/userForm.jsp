<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<br />
<br />
<div class="loginhead">Register Here</div>
<br />
<div style="margin-left: 35%;">
	<form:form method="post"
		action="${pageContext.request.contextPath}/createUser"
		commandName="user">

		<table class="t2">
			<tr class="t2">
				<td class="t2">User Name</td>
				<td class="t2"><form:input cssClass="textbox" path="username"
						name="name" type="text" /></td>
				<td><form:errors path="username" cssClass="error"></form:errors></td>
			</tr>
			<tr class="t2">
				<td class="t2">Password</td>
				<td class="t2"><form:input path="password" cssClass="textbox"
						id="password" name="password" type="password" /></td>
				<td><form:errors path="password" cssClass="error"></form:errors></td>
			</tr>
			<tr class="t2">
				<td class="t2">Confirm Password</td>
				<td class="t2"><input onchange="javascript:checkPass()"
					class="textbox" id="cpassword" type="password" /></td>
				<td><p id="confirm" class="error"></p></td>
			</tr>
			<tr class="t2">
				<td class="t2">Email</td>
				<td class="t2"><form:input cssClass="textbox" path="email"
						name="email" type="text" /></td>
				<td><form:errors path="email" cssClass="error"></form:errors></td>
			</tr>
			<tr class="t2">
				<td class="t2">Authority</td>
				<td class="t2"><form:select cssClass="drpdwn" path="authority"
						name="authority">
						<form:option name="user" value="1">User</form:option>
						<form:option name="admin" value="2">Administrator</form:option>
					</form:select></td>
			</tr>

			<tr class="t2">
				<td class="t2"></td>
				<td class="t2"><input value="create" class="submit"
					type="submit"></td>
			</tr>
		</table>

	</form:form>
</div>
