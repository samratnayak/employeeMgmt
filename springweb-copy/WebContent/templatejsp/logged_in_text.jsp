<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authorize access="hasAuthority('user')" >
<sec:authentication property="principal.username" var="user" />
 <label class="user" > Hello ${user}<br/>(User) </label> </sec:authorize>
<sec:authorize access="hasAuthority('admin')" >

 <label class="user" > Hello ${user}<br/>(Admin) </label> </sec:authorize><br>
<sec:authorize access="isAuthenticated()" ><a class="login" href="javascript:submitF()" >Logout</a></sec:authorize>


