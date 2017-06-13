<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>




<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SimpliBank Scheduler</title>

</head>
<body>
<center>

<table class="table" border="2">
			<thead>
				<tr>
					<th colspan="7" align="center"> <center> SimliBank Scheduler </center></th>
				</tr>
				<tr>
					<th>Task ID</th>
					<th>Task name</th>
					<th>Task Group</th>
					<th>Task Start Time</th>
					<th>Task End Time</th>
					<th> Schedule </th>
					<th> Unschedule</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${simplijobs}" var="simplijob">
					<tr>
						<td><c:out value="${simplijob.id}" /></td>
						<td><c:out value="${simplijob.name}" /></td>
						<td><c:out value="${simplijob.simpliGroup}" /></td>
			
		<td><fmt:formatDate type="both" dateStyle="full" value="${simplijob.startTime.time}" var="sTime" />
				<c:out value="${sTime}" /></td>
		<td><fmt:formatDate type="both" dateStyle="full" value="${simplijob.endtime.time}" var="eTime" />
				<c:out value="${eTime}" /></td>
		<td><a href="<spring:url value="/simplijob/schedule/${simplijob.id}.html" />" class="btn btn-lg btn-primary">Schedule </a> </td>
		<td><a href="<spring:url value="/simplijob/unschedule/${simplijob.id}.html" />"	class="btn btn-lg btn-danger btn-primary">Unschedule </a> </td>
					</tr>
				</c:forEach>
			</tbody>
		</table></center>
	
	<!--   <a href="<spring:url value="/blog/remove/${blog.id}.html" />" class="btn btn-danger triggerRemove">Delete this Blog</a>   -->
	
		
	</body>
</html>