<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="myContext" value="${pageContext.request.contextPath}" />
<%@ page isELIgnored="false"%>
<header>
	<!-- Logo -->
	<div class="container-xl" id="blog">
		<div class="row">
			<div class="col-12">
				<h2>Blog</h2>
			</div>
		</div>
	</div>
	<!-- Logo -->
	<!-- Top TopMenu-->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand nav-link " href="#">Menu</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link"
					href="${myContext}/index">Home </a></li>
				<li class="nav-item"><a class="nav-link"
					href="${myContext}/AboutPage">About</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${myContext}/ContactPage">Contact</a></li>
				<c:set var="nameUser"
					value="${pageContext.request.userPrincipal.name}"></c:set>
				<c:choose>
					<c:when test="${nameUser != null}">
						<li class="nav-item"><a class="nav-link"
					href="${myContext}/Logout">Logout(<c:out value="${nameUser}"></c:out>)</a></li>
					</c:when>
					<c:otherwise>
						<li class="nav-item"><a class="nav-link"
					href="${myContext}/LoginPage">Login</a></li>
					</c:otherwise>
				</c:choose>			
			</ul>
		</div>
	</nav>
	<!--End TopMenu-->
</header>
