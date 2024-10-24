<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<head>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/LoginPage/contentStyle.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/dialog.css'/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/fStyle.css'/>">
<style>
label.error {
	color: red;
}
</style>

<script language="javascript"
	src="<c:url value="/resources/js/validateLoginPageScript.js"/>"
	type="text/javascript"></script>

</head>


<!-- Destination -->
<div class="row">
	<div class="col-12 ">
		<p>
			<a href="">Home</a>>> <a style="font-weight: bold; color: gray;">Login</a>
		</p>
	</div>
</div>

<!-- Content and Right Menu -->
<div class="row">
	<!-- Start Content -->
	<div class="col-9 row-content" style="padding: 15px;">
		<div class="row">
			<div class="col-12">
				<h2>Login</h2>
			</div>
		</div>
		<div class="row">
			<div class="col-12">
				<p>Please fill out the following form with your login
					credentials.</p>
			</div>
		</div>
		<div class="row">
			<div class="col-12">
				<p class="required">
					Fields with <span style="color: red">*</span> are required
				</p>
			</div>
		</div>
		<div class="row">
			<div class="col-12">
				<form method="post" id="doLogin" action="doLogin">
					<div>
						<label for="username">Username <span style="color: red">*</span></label><br>
						<input type="text" id="username" name="username"
							STYLE="background-color: #FAFFBD">

					</div>
					<div>
						<label for="password">Password <span style="color: red">*</span></label><br>
						<input type="password" id="password" name="password"
							STYLE="background-color: #FAFFBD">
					</div>

					<div style="color: #D3D3D3;">Hint: You can login with
						demo/demo</div>
					<div>
						<input type="checkbox" id="remember" name="remember"
							value="remeber"> <label for="remember"> Remember
							me the next time</label>
					</div>
					<div>
						<button type="submit" value="Login">Login</button>
					</div>
				</form>

			</div>
		</div>
		<div class="row" style="margin-top: 8px;">
			<div class="col-12">
				New to BlogManagement? <a href="#" class="AddUser"
					data-toggle="modal" data-target="#myModal"> Create an account.</a>
			</div>
		</div>
	</div>
	<!-- End Content -->

	<!-- Start Right Menu -->
	<!-- End Right Menu -->
</div>
<!--Popup AddUser-->
<div class="modal fade" id="myModal" role="dialog">
	<div class="modal-dialog">
		<!-- Modal content-->
		<div class="modal-content">
			<form:form method="post" id="createUser" action="createUser"
				modelAttribute="user">
				<div class="modal-header" STYLE="background-color: #65A5CC">
					<h4 class="modal-title">New User</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<div class="modal-body">

					<p>
						<label for="username">Username <span style="color: red">*</span></label><br>
						<input type="text" id="username" name="username"
							STYLE="background-color: #FAFFBD; width: 100%">

					</p>

					<p>
						<label for="password">Password <span style="color: red">*</span></label><br>
						<input type="password" id="password" name="password"
							STYLE="background-color: #FAFFBD; width: 100%">

					</p>

					<p>
						<label for="email">Email</label><br> <input type="text"
							id="email" name="email" STYLE="width: 100%">
					</p>

					<p>
						<label for="profile">Profile</label><br> <input type="text"
							id="profile" name="profile" STYLE="width: 100%">
					</p>

				</div>
				<div class="modal-footer">
					<button type="submit" value="create">Create</button>
					<button type="button" data-dismiss="modal">Close</button>
				</div>
				

			</form:form>
		</div>

	</div>
</div>
<!-- End Popup AddUser-->

<!-- Error Mess-->
<c:choose>
	<c:when test="${Result == 'fail_create'}">
		<c:set var="head_dialog" scope="page" value="Fail!!!" />
		<c:set var="body_dialog" scope="page"
			value="Username is already exist!!!" />
		<c:set var="hide" scope="session" value="true" />
	</c:when>
	<c:when test="${Result == 'success_create'}">
		<c:set var="head_dialog" scope="page" value="Success!!" />
		<c:set var="body_dialog" scope="page"
			value="You successfully create new user!!!!" />
		<c:set var="hide" scope="session" value="true" />
	</c:when>
	<c:when test="${Result == 'fail_login'}">
		<c:set var="head_dialog" scope="page" value="Fail!!!" />
		<c:set var="body_dialog" scope="page"
			value="Username or password are not correct!!" />
		<c:set var="hide" scope="session" value="true" />
	</c:when>
	<c:otherwise>
		<c:set var="hide" scope="session" value="false" />
	</c:otherwise>
</c:choose>
<!-- ENd Error Mess-->

<!-- Dialog box -->
<div id="white-background"></div>
<div id="dlgbox"
	style="display:${hide ? 'block' : 'none'}; top : 200px; ">
	<div id="dlg-header">
		<c:out value="${head_dialog}" />
	</div>
	<div id="dlg-body">
		<c:out value="${body_dialog}" />
	</div>
	<div id="dlg-footer">
		<button id="submitbutton" style="display: none"></button>
		<button id="closebutton">Close</button>
	</div>
</div>

<!-- End Dialog box -->