<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Registration Confirmation Page</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
<body>
<div class="generic-container">
	<%@include file="authheader.jsp" %>
	<div class="panel panel-default">
		<!-- Default panel contents -->
		<div class="panel-heading"><span class="lead">Office </span></div>
		<table class="table table-hover">
			<thead>
			<tr>
				<th>Title</th>
				<th>Address</th>
				<th>Phone 1</th>
				<th>Phone 2</th>
				<th>Postal Code</th>
				<th>Created</th>
				<th>Updated</th>

			</tr>
			</thead>
			<tbody>
			<form:form method="GET" modelAttribute="office" class="form-horizontal">
				<form:input type="hidden" path="id" id="id"/>
				<tr>
					<td>${office.title}</td>
					<td>${office.address}</td>
					<td>${office.phone1}</td>
					<td>${office.phone2}</td>
					<td>${office.postalCode}</td>
					<td>${office.createdTS}</td>
					<td>${office.updatedTS}</td>

				</tr>
			</form:form>
			<div class="well">
				<a href="<c:url value='/list' />">Users List</a>
				<br>
				<a href="<c:url value='/offices/list' />">Offices List</a>
			</div>
			</tbody>
		</table>
	</div>

</html>