<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>

<c:set var="contextPath" value="${pageContext.request.contextPath}/resources" />

<link rel="stylesheet"
	href="${contextPath}/css/bootstrap.min.css">

</head>
<body class="container d-flex justify-content-center">
	<section class="w-50 bg-light p-4" style="margin-top: 10%;">
		<header class="h4">Please Sign in</header>
		<form method="post" action="Login">
			<!-- User Name -->
			<input type="text" name="user" class="form-control mt-4"
				placeholder="User Name" />

			<!-- password -->
			<input type="password" name="pass" class="form-control mt-4"
				placeholder="password" />

			<div class="d-flex align-items-center mt-4">
				<input class="" type="checkbox" /> <span class="pl-2 h6">Remember
					me</span>
			</div>

			<button type="submit" class="btn btn-success mt-4 w-100">Login</button>
		</form>
	</section>
</body>
</html>