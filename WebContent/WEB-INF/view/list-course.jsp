<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Course</title>
</head>
<body>
	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
		</tr>
		<tr>
			<c:forEach var="course" items="${courses}">
			<tr>
				<td>${course.id}</td>
				<td>${course.courseName}</td>
				<td> <a href="/review?id=${course.id}&name=${course.courseName}">see Reviews</a>
			</tr>
			</c:forEach>
		</tr>
	</table>
</body>
</html>