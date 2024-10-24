<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<head>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/ManagePotsPage/contentStyle.css"/>">

<!-- This is include link responsive -->
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/fStyle.css'/>">
</head>

<!-- Start Destination -->
<div class="row">
	<div class="col-12 ">
		<p>
			<a href="">Home</a>>> <a style="font-weight: bold; color: gray;">Manage
				Posts</a>
		</p>
	</div>
</div>
<!-- End Destination -->

<!-- Content and Right Menu -->
<div class="row">

	<!-- Start Content -->
	<div class="col-9 row-content" style="padding: 15px; height: 550px;">

		<!-- Start Title Manage Posts-->
		<div class="row">
			<div class="col-12">
				<h2>Manage Posts</h2>
			</div>
		</div>
		<!-- End Title Manage Posts-->

		<!-- Start Result Manage Posts-->
		<c:set var="page" value="${totalPage}"></c:set>
		<div class="row">
			<div class="col-12" style="text-align: right;">
				<p>Displaying page ${page_id}</p>
			</div>
		</div>
		<!-- End Result Manage Posts-->

		<!-- Start Table Desktop -->
		<div class="row table-desktop">
			<div class="col-12">
				<table class="table table-dark table-striped">
					<thead style="background-color: #65A5CC; color: white;">
						<tr style="text-align: center;">
							<th style="width: 35%;">Title</th>
							<th style="width: 20%;">Status</th>
							<th style="width: 30%;">Create Time</th>
							<th style="width: 15%;"></th>
						</tr>
					</thead>
					<tbody>
						<tr id="tr-fisrt">
							<td><input type="text" style="width: 100%; height: 21px;"></td>
							<td><select id="status" style="width: 100%;">
									<option value="draft">draft</option>
									<option value="published">published</option>
									<option value="outdated">outdated</option>
							</select></td>
							<td></td>
							<td></td>
						</tr>
						
					<tbody>
						<!-- loop over and print our comments -->
						<c:forEach var="post" items="${listPost}">
							<!-- construct an "delete" link with Post id -->
							<c:url var="deletePost" value="/ManagePostPage/${page_id}/delete">
								<c:param name="postId" value="${post.id}" />
							</c:url>
							
							<c:url var="editPost" value="/ManagePostPage/${page_id}/edit">
								<c:param name="postId" value="${post.id}" />
							</c:url>
							<tr>
								<td>${post.title}</td>
								<td>
									<c:choose>
  										 <c:when test="${post.status == '1'}">draft</c:when> 
   										 <c:when test="${post.status == '2'}">published</c:when> 
   										 <c:otherwise>outdated</c:otherwise>
									</c:choose>
								</td>
								<td>${post.create_time}</td>
								<td style="text-align: center;">
									<a href="${searchPost}" data-toggle="tooltip" title="Post Detail">
										<i class="fas fa-search"></i>
									</a>
									<a href="${editPost}" data-toggle="tooltip" title="Edit Post">
										<i class="far fa-edit"></i>
									</a>
									<a href="${deletePost}" data-toggle="tooltip" title="Delete Post">
										<i class="fas fa-times-circle"></i>
									</a>
								</td>
							</tr>
						</c:forEach>
						<!-- </tbody> -->
					</tbody>
				</table>
			</div>
		</div>
		<!-- End Table Desktop -->

		<!-- Start Table Mobile -->
		<div class="row mobile-style">
			<div class="col-12">
				<table class="table table-dark table-striped">
					<tr style="text-align: center;">
						<th style="width: 50%;">Title</th>
						<th style="width: 50%;"><input type="text"
							style="width: 100%; height: 21px;"></th>
					</tr>
					<tr style="text-align: center;">
						<th style="width: 50%;">Status</th>
						<th style="width: 50%;"><select id="status"
							style="width: 100%;">
								<option value="all"></option>
								<option value="draft">draft</option>
								<option value="published">published</option>
								<option value="outdated">outdated</option>
						</select></th>
					</tr>
				</table>
			</div>
			<div class="col-12">
				<c:set var="count" value="${(page_id-1)*15}" scope="page" />
				<!-- loop over and print our comments -->
				<c:forEach var="post" items="${listPost}">
					<c:set var="count" value="${count + 1}" scope="page" />
					<table class="table table-dark table-striped">
						<tr style="text-align: center;">
							<th style="width: 50%;">Title</th>
							<th style="width: 50%;">${post.title}</th>
						</tr>
						<tr style="text-align: center;">
							<th style="width: 50%;">Status</th>
							<th style="width: 50%;"><c:choose>
									<c:when test="${post.status == '1'}">draft</c:when>
									<c:when test="${post.status == '2'}">published</c:when>
									<c:otherwise>outdated</c:otherwise>
								</c:choose></th>
						</tr>
						<tr style="text-align: center;">
							<th style="width: 50%;">Create Time</th>
							<th style="width: 50%;">${post.create_time}</th>
						</tr>
						<tr style="text-align: center;">
							<th style="width: 50%;"></th>
							<th style="width: 50%;">
								<a href="${searchPost}" data-toggle="tooltip" title="Post Detail">
									<i class="fas fa-search"></i>
								</a>
								<a href="${editPost}" data-toggle="tooltip" title="Edit Post">
									<i class="far fa-edit"></i>
								</a>
								<a href="${deletePost}" data-toggle="tooltip" title="Delete Post">
									<i class="fas fa-times-circle"></i>
								</a>
							</th>
						</tr>
					</table>
				</c:forEach>
			</div>


		</div>

		<!-- Start Table Mobile -->

		<!-- Start Pagging -->
		<div class="row">
			<%@ include file="./template/paging.jsp"%>
		</div>
		<!-- End Pagging -->

	</div>
	<!-- End Content -->

	<!-- Start Right Menu -->
	<%@ include file="./template/RightMenu.jsp"%>
	<!-- End Right Menu -->
</div>
