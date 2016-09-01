<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="<c:url value='/templatejsp/jQuery/jquery-3.1.0.js'/>" type="text/javascript"></script>
<script type="text/javascript">
	function submitF() {
		document.getElementById("f").submit();
	}
	function multRow(){
		alert("checked");
		document.getElementById("mytable").className="checkedBg";
	}
	function checkPass(){
		var p = document.getElementById("password").value;
		var p1 = document.getElementById("cpassword").value;
		var valid=false;
		if(p==p1)
		{
		 document.getElementById("confirm").style.color = "green";
		 document.getElementById("confirm").innerHTML = "Passwords Match :)";
		 valid=true;
		}
		else{
			document.getElementById("confirm").innerHTML = "Passwords do not Match :( ";
		}
		
	 return valid;
	}
	function confirmDelete(){
		var decision = confirm("Are you sure?");
		return decision;
	}
	function deleteSuccess(){
		alert("Success");
	}
	
</script>
<style type="text/css">
.error {
	color: red;
	font-size: 10px;
}
div.error {
	font-family: sans-serif;
	color: #EC7063;
	font-size: 15px;
}
a.login {
	color: #34495E;
	font-family: fantasy;
	text-decoration: blink;
}

a.login:hover {
	color: #16A085;
}

div.workarea {
	background-color: #D0ECE7;
	width: 80%;
	margin-left: 10%;
	position: relative;
	height: 1000px;
}

div.header {
	background-color: grey;
	width: 80%;
	height: 10%;
	margin-left: 10%;
}

p.title {
	padding: 2% 3% 2% 25%;
	font-family: sans-serif;
	color: white;
	font-size: 20px;
}

label.user{
	font-family: sans-serif;
	color: #B7950B;
	font-size: 15px;
}
div.hr {
	position: relative;
	margin-left: 10%;
	width: 80%;
}

a.link_menu {
	text-transform: capitalize;
	text-decoration: none;
	font-family: Papyrus, fantasy;
}

a.link_menu:hover {
	color: green;
}

div.menu {
	width: 5%;
	float: left;
	margin-right: 6%;
}

div.content {
	padding-bottom: 10%;
	float: left;
	width: 70%;
	margin-left: 5%;
}

table.t1 {
	width: 95%;
	border-collapse: collapse;
}

td.data {
	border-bottom: 1px solid grey;
	padding: 8px;
}

div.loginhead {
	font-size: medium;
	font-family: "Century Gothic", CenturyGothic, AppleGothic, sans-serif;
	font-weight: bolder;
	text-align: center;
}

td.t2 {
	padding: 6px;
}
.checkedBg{
	background-color: #76D7C4;
}
tr.heading {
	font-size: medium;
	font-family: "Century Gothic", CenturyGothic, AppleGothic, sans-serif;
	font-weight: bolder;
}

tr.t1 {
	font-family: "Century Gothic", CenturyGothic, AppleGothic, sans-serif;
}
p.t1 {
	font-family: "Century Gothic", CenturyGothic, AppleGothic, sans-serif;
}
tr.t2 {
	font-family: "Century Gothic", CenturyGothic, AppleGothic, sans-serif;
}

tr.t1:hover {
	background-color: #76D7C4
}

ul.menu {
	list-style: none;
	letter-spacing: 2px;
}

li {
	margin-bottom: 35px;
}

div.footer {
	position: relative;
	background-color: #F5CBA7;
	width: 80%;
	height: 5%;
	margin-left: 10%;
}

p.footer {
	font-family: cursive;
	font-size: x-small;
	font-weight: lighter;
	color: grey;
}

div.logindiv {
	float: left;
}
div.submitbutton{
text-align: center;
padding-top: 6%;
}
input.deleteEmp{
border-style: none;
font-family: "Century Gothic", CenturyGothic, AppleGothic, sans-serif;
background-color: #EC7063  ;
font-weight:600;
color: #154360;
width: 65px;
height: 25px;
border-radius: 4px;
moz-border-radius: 4px;
webkit-border-radius: 4px;
}
input.deleteEmp:hover,input.submit:hover {
	color: white;
}
input.submit{
border-style: none;
text-align:center;
font-family: "Century Gothic", CenturyGothic, AppleGothic, sans-serif;
background-color: #2ECC71;
font-weight:600;
color: #34495E;
width: 55px;
height: 20px;
}
input.textbox{
font-family: "Century Gothic", CenturyGothic, AppleGothic, sans-serif;
font-weight: 500;
}
select.drpdwn{
font-family: "Century Gothic", CenturyGothic, AppleGothic, sans-serif;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><tiles:insertAttribute name="title"></tiles:insertAttribute></title>
</head>
<body>
	<div id="parent">
		<div class="header">
			<tiles:insertAttribute name="header"></tiles:insertAttribute>
		</div>
		<div class="workarea">
			<div class="menu">
				<tiles:insertAttribute name="menu"></tiles:insertAttribute>
			</div>
			<div class="content">
				<tiles:insertAttribute name="content"></tiles:insertAttribute>
			</div>
			<div class="logindiv">
				<tiles:insertAttribute name="logintext"></tiles:insertAttribute>
			</div>
		</div>
		<div class="hr">
			<hr class="hr" />
		</div>
		<div class="footer">
			<tiles:insertAttribute name="footer"></tiles:insertAttribute>
		</div>
	</div>
</body>
</html>