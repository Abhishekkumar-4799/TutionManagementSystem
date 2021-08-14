<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Instructor Registration Form</title>
<style>
	.error {color:red}
</style>
</head>
<body>
	<form:form action="addInstructor" modelAttribute="instructorDetails" >
		Instructor Name: <form:input path="instructorPersonalInfo.name" />
		<br><br>
		<form:errors path="instructorPersonalInfo.name" cssClass="error" />
		<br><br>
		Email: <form:input path="instructorDigitalInfo.email" />
		<form:errors path="instructorDigitalInfo.email" cssClass="error" />
		<br><br>
		LinkedIn Profile: <form:input path="instructorDigitalInfo.linkedIn" />
		<form:errors path="instructorDigitalInfo.linkedIn" cssClass="error" />
		<br><br>
		Insta Profile: <form:input path="instructorDigitalInfo.instaProfile" />
		<form:errors path="instructorDigitalInfo.instaProfile" cssClass="error" />
		<br><br>
		<input type="submit" value="Submit" />
		
	</form:form>
</body>
</html>