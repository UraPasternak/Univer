<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form name="f" action="<c:url value='/j_spring_security_check'/>" method="POST">
		<div>
			<div>
				<input type="text" value="j_username" placeholder = "User Name">
			</div>
			<div>
				<input type="text" value="j_password" placeholder = "Password">
			</div>
			<div>
				<input type="submit" value="Sign In">
			</div>
			<c:if test="${param.error ne null}">
				<div>Invalid username or password.</div>
			</c:if>
			<c:if test="${param.error ne null}">
				<div>You have been logged out.</div>
			</c:if>
		</div>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	</form>
	
</body>
</html>