
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

 
<ul  class="menu"  >
<li><a class="link_menu" href="${pageContext.request.contextPath}/employees">View Employees</a></li>
<li><a class="link_menu" href="${pageContext.request.contextPath}/addEmp">Add Employee</a></li>
<li><sec:authorize access="hasAuthority('user')" ><a class="link_menu" href="${pageContext.request.contextPath}/showSendMsgPage">Send Message to Admin</a></sec:authorize></li>
<li><sec:authorize access="hasAuthority('user')" ><a class="link_menu" href="${pageContext.request.contextPath}/showAllMessagesFromUser">Show Sent Messages</a></sec:authorize></li>
<li><sec:authorize access="hasAuthority('admin')" ><a class="link_menu" href="${pageContext.request.contextPath}/showAllMessagesToAdmin">Received Messages <span id="messageCount" ></span> </a></sec:authorize>
</ul>
<script type="text/javascript">
function getMessagesCount(){
$.getJSON("<c:url value='/message'/>", function updateMessageLink(data){
		$("#messageCount").text( "(" +data.totalcount+")");
});}
$(document).ready(function load(){
	getMessagesCount();
	window.setInterval(getMessagesCount,5000);
});
</script>
<form id="f" action="<c:url value='/logout' />"  method="POST">
<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
</form>




<%-- <a  href="${pageContext.request.contextPath}/employees">Show Employees</a>
<p ><a  href="${pageContext.request.contextPath}/addEmp">Add Employee</a></p>
<sec:authorize access="isAuthenticated()" ><p><a href="javascript:submitF()" >logout</a></p></sec:authorize>
<sec:authorize access="hasAuthority('admin')" >Welcome Admin</sec:authorize>
 --%>
<%-- 
<p>Using JSTL : <c:out value="${name}"></c:out></p>
j_spring_security_logout
<sql:query var="rs" dataSource="jdbc/myoracle">
select empid, empname, iou from myemp order by 1
</sql:query>
<%int i=1; %>
<table>
<thead><td>Serial No</td><td>EMP Id</td><td>Emp Name</td></thead>
<c:forEach var="row" items="${rs.rows}">

<tr>
<td><%= i++ %></td><td>${row.empid}</td><td>${row.empname}</td>
</tr>
</c:forEach>
</table> --%>
