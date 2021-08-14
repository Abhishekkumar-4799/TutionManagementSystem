<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Instructor</title>
<link type="text/css" 
	  rel="stylesheet" 
	  href="${pageContext.request.contextPath}/resources/css/instructorlist.css" /> 
</head>
<body>
	<div id="header">
		<h2> List of Instructors in Tution Center </h2>
	</div>
	<div>
		<button type="button" onclick="window.location.href='showformforadd'; return false;"> Add Instructor </button>>
	</div>
	<div id="container">
		<table>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Date of Birth</th>
				<th>Email</th>
				<th>LinkedIn Profile</th>
				<th>Insta profile</th>
				<th>Action</th>
			</tr>
			<c:forEach var="tempInstructor" items="${instructorsInfo}">
			<!-- Construct an update link -->
			<c:url var="updateLink" value="/instructor/updateInstructorForm">
				<c:param name="instructorDigitalId" value="${tempInstructor.instructorDigitalInfo.id}" />
			</c:url>
			
			<c:url var="deleteLink" value="/instructor/delete">
				<c:param name="instructorDigitalId" value="${tempInstructor.instructorDigitalInfo.id}" />
			</c:url>
			
				<tr>
					<td>${tempInstructor.instructorPersonalInfo.id}</td>
					<td>${tempInstructor.instructorPersonalInfo.name}</td>
					<td>${tempInstructor.instructorDigitalInfo.email}</td>
					<td>${tempInstructor.instructorDigitalInfo.linkedIn}</td>
					<td>${tempInstructor.instructorDigitalInfo.instaProfile}</td>
					<td> <a href="${updateLink }"> Update </a> | 
						 <a href="${deleteLink }" onclick="if(! (confirm('Are you sure you want to delete this instructor?'))) return false"> Delete </a> </td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>