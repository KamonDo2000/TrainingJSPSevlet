<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>

<head>
<%@ include file="./template/head.jsp"%>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/CreatePostPage/contentStyle.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/dialog.css'/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/fStyle.css'/>">
<title>Create Post</title>
<style>
label.error {
	color: red;
}
</style>

<script language="javascript"
	src="<c:url value="/resources/js/validateCreatePostPageScript.js"/>"
	type="text/javascript"></script>
</head>


<!-- Destination -->
<div class="row">
	<div class="col-12 ">
		<p>
			<a href="">Home</a>>> <a style="font-weight: bold; color: gray;">Create
				Post</a>
		</p>
	</div>
</div>

<!-- Content and Right Menu -->
<div class="row">
	<!-- Start Content -->
	<div class="col-9 row-content" style="padding: 15px;">
		<div class="row">
			<div class="col-12">
				<h2>Create Post</h2>
			</div>
		</div>
		<div class="row">
			<div class="col-12">
				<p class=required>
					Fields with <span style="color: red">*</span> are required
				</p>
			</div>
		</div>
		<div class="row">
			<div class="col-12">
				<form:form action="savePost" id="savePost" method="post"
						modelAttribute="postForm">
					<div>
						<label for="title">Title <span style="color: red">*</span></label><br>
						<input type="text" id="title" name="title">
					</div>
					<div>
						<label for="content">Content <span style="color: red">*</span></label>
						<div>
							<textarea name="content" rows="8" cols="80"></textarea>
						</div>
					</div>
					<div style="color: #D3D3D3;">
						You may use <a href="#"> Markdown syntax </a>
					</div>
					<div>
						<label for="tags">Tags </label><br> <input type="text"
							id="tags" name="tags">
					</div>
					<div style="color: #D3D3D3;">Please separate different tags
						with commas</div>
					<div style="margin-bottom: 5px;">
						<label for="status">Status <span style="color: red">*</span></label><br>
						<select name="status">
							<option value="1">Draft</option>
							<option value="2">Published</option>
							<option value="3">Outdated</option>
						</select>
					</div>
					<div>
						<input type="submit" value="Create">
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<!-- End Content -->

	<!-- Dialog box -->
	<%@ include file="./template/Dialog.jsp"%>
	<!-- End Dialog box -->

	<!-- Start Right Menu -->
	<%@ include file="./template/RightMenu.jsp"%>
	<!-- End Right Menu -->
</div>