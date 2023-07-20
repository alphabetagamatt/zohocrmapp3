<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>List All Leads..</h2>
	<table>
		<tr>
			<th>FirstName</th>
			<th>lastName</th>
			<th>Email</th>
			<th>Mobile</th>
         	<th>Action</th>
		</tr>
		 <c:forEach  var ="Lead" items ="${leads}" />
	

			<tr>
				    <td>${lead.firstName}</td>
				    <td>${lead.lastName}</td>
			    	<td>${lead.email}</td>
				    <td>${lead.mobile}</td>
				    <td><a href = "delete?id = ${lead.id}">delete</a></td>
					<td><a href = "update?id = ${lead.id}">update</a></td>
			</tr>
	</table>
</body>
</html>