<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error_page"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:setProperty property="*" name="user"/>
<!-- invoke userBean mrthods for validation and registration -->
<body>
	<h5>Registration status - ${sessionScope.user.validateAndRegister()}</h5>
</body>
</html>