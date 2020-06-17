<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title><spring:message code="login.title" /></title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${contextPath}../css/login.css">

</head>

<body>

<div class="container">

    <form method="POST" action="${contextPath}/login" class="form-signin">
        <h2 class="form-heading"><spring:message code="login.login" /></h2>

        <div class="form-group ${error != null ? 'has-error' : ''}" >
            <span>${message}</span>
            <input name="email" type="text" class="form-control" data-validate = "<spring:message code="login.email.validate" />" placeholder="<spring:message code="login.email" />"/>
            <input name="password" type="password" class="form-control" data-validate = "<spring:message code="login.password.validate" />" placeholder="<spring:message code="login.password" />"/>
            <span>${error}</span>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <button class="btn btn-lg btn-primary btn-block" type="submit"><spring:message code="login.login" /></button>
            <h4 class="text-center"><a href="${contextPath}/registration"><spring:message code="login.create_account" /></a></h4>
        </div>
        <div>
			<fieldset>
				<label><spring:message code="login.choose_language" /></label>
				<select	class="" id="locales">
					<option value="en"><spring:message code='login.english' /></option>
					<option value="uk_UA"><spring:message code='login.ukrainian' /></option>
				</select>
			</fieldset>
		</div>

    </form>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${contextPath}/vendor/select2/select2.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var selItem = localStorage.getItem("locales");
		$('#locales').val(selItem ? selItem : 'en');
		$("#locales").change(function() {
			var selectedOption = $('#locales').val();
			if (selectedOption) {
				window.location.replace('?lang=' + selectedOption);
				localStorage.setItem("locales", selectedOption);
			}
		});
	});
</script>
</body>
</html> 