<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<head>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/ContactPage/contentStyle.css"/>">
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
	src="<c:url value="/resources/js/validateContactPageScript.js"/>"
	type="text/javascript"></script>
</head>


<!-- Destination -->
<div class="row">
	<div class="col-12 ">
		<p>
			<a href="">Home</a>>> <a style="font-weight: bold; color: gray;">Contact
				Us</a>
		</p>
	</div>
</div>

<!-- Content and Right Menu -->
<div class="row">
	<!-- Start Content -->
	<div class="col-9 row-content" style="padding: 15px;">
		<div class="row">
			<div class="col-12">
				<h2>Contact Us</h2>
			</div>
		</div>
		<div class="row">
			<div class="col-12">
				<p>If you have business inquiries or other question, please fill
					out the following form to contact us. Thank you.</p>
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
				<form method="post" id="contact" action="">
					<div>
						<label for="name">Name <span style="color: red">*</span></label><br>
						<input type="text" id="name" name="name">
					</div>

					<div>
						<label for="email">Email <span style="color: red">*</span></label><br>
						<input type="text" id="email" name="email">
					</div>

					<div>
						<label for="subject">Subject <span style="color: red">*</span></label><br>
						<input type="text" id="subject" name="subject">
					</div>

					<div>
						<label for="body">Body <span style="color: red">*</span></label><br>
						<textarea name="body" rows="5" cols="60"></textarea>
					</div>

					<div>
						<button type="submit" value="Submit">Submit</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- End Content -->

	<!-- Dialog box -->
	<%@ include file="./template/Dialog.jsp"%>
	<!-- End Dialog box -->

	<!-- Start Right Menu -->
	<!-- End Right Menu -->
</div>



