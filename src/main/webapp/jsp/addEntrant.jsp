<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Periodicals</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<body>
	<div class="container">

		<!-- Sidebar -->
		<jsp:include page='sidebar.jsp'/>


		<!-- Page Content -->
		<div style="margin-left: 10%">
			<div class="w3-container w3-teal">
				<h1>Create new Entrant</h1>
			</div>
			<div class="w3-container">
				<c:if test="${pageContext.request.userPrincipal.name != null}">
					<form id="logoutForm" method="POST" action="${contextPath}/logout">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</form>
					<h2>
						Welcome ${pageContext.request.userPrincipal.name} | <a
							onclick="document.forms['logoutForm'].submit()">Logout</a>
					</h2>
				</c:if>




				<form:form method="POST" modelAttribute="entrant">
					<spring:bind path="firstName">
			            <div class="form-group ${status.error ? 'has-error' : ''}">
			                <form:input type="text" path="firstName" class="form-control" placeholder="First name"
			                            autofocus="true"></form:input>
			                <form:errors path="firstName"></form:errors>
			            </div>
			        </spring:bind>
			
			          <spring:bind path="lastName">
			            <div class="form-group ${status.error ? 'has-error' : ''}">
			                <form:input type="text" path="lastName" class="form-control" placeholder="Last name"
			                            autofocus="true"></form:input>
			                <form:errors path="lastName"></form:errors>
			            </div>
			        </spring:bind>
			        
			        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</form:form>


			</div>

		</div>


	</div>
	<!-- /container -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>

</body>
</html>