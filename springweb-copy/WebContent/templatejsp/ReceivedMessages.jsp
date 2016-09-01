<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<script type="text/javascript">
function getMessagesCount(){
$.getJSON("<c:url value='/message'/>", function updateMessageLink(data){
	$("table#showmsg").html("");
	for(var i = 0; i< data.msg.length;i++){
	var msg = data.msg[i];	
	$("table#showmsg").
	append("<tr id='mytable' class='t1'><td class='data'>"+(i+1)+"</td><td class='data'>"+msg.title+"<br/></td><td class='data'>"+msg.msg+"</td></tr>");
			
	}
});}
$(document).ready(function load(){
	getMessagesCount();
	window.setInterval(getMessagesCount,5000);
});

</script>

<%
	int i = 1;
%>
<br />
<table id="showmsg" class="t1">
	<tr class="heading">
		<td>Serial No.</td>
		<td>Message Title</td>
		<td>Message</td>
	</tr>
</table>
<div class="submitbutton">
<%-- <a class="link_menu"
				href="${pageContext.request.contextPath}/editmsg/test">Test</a> --%>

</div>
<div id="showMsg">

</div>


