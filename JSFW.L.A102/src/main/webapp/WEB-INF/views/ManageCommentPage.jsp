<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<head>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/ManageCommentPage/contentStyle.css"/>">

<!-- This is include link responsive -->
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/fStyle.css'/>">

<script type="text/javascript">
	
</script>
</head>

<!-- Start Destination -->
<div class="row">
	<div class="col-12 ">
		<p>
			<a href="">Home</a>>> <a style="font-weight: bold; color: gray;">Manage
				Comments</a>
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
				<h2>Manage Comments</h2>
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
							<th style="width: 5%;">No</th>
							<th style="width: 10%;">Author</th>
							<th style="width: 20%;">Email</th>
							<th style="width: 40%;">Content</th>
							<th style="width: 20%;">Create Time</th>
							<th style="width: 5%;"></th>
						</tr>
					</thead>

					<tbody>
						<c:set var="count" value="${(page_id-1)*15}" scope="page" />
						<!-- loop over and print our comments -->
						<c:forEach var="post" items="${listPosts}">
							<tr>
								<th colspan="2">Post: ${post.title}</th>
								<th>Author: ${post.user.username}</th>
								<th>Update: ${post.update_time}</th>
							</tr>
							<c:forEach var="comment" items="${listComments}">
								<c:if test="${comment.post.id == post.id }">
									<c:set var="count" value="${count + 1}" scope="page" />
									<!-- construct an "delete" link with Comment id -->
									<c:url var="deleteCmt"
										value="/ManageCommentPage/${page_id}/delete">
										<c:param name="cmtId" value="${comment.id}" />
									</c:url>
									<tr>
										<td>${count}</td>
										<td>${comment.author}</td>
										<td>${comment.email}</td>
										<td>${comment.content}</td>
										<td>${comment.create_time}</td>
										<td style="text-align: center;"><a href="${deleteCmt}"
											data-toggle="tooltip" title="Delete!"><i
												class="fas fa-times-circle"></i></a></td>
									</tr>
								</c:if>
							</c:forEach>
						</c:forEach>
						<!-- </tbody> -->
				</table>
			</div>
		</div>
		<!-- End Table Desktop -->

		<!-- Start Table Mobile -->
		<div class="row mobile-style">

			<c:set var="count" value="${(page_id-1)*15}" scope="page" />

			<!-- loop over and print our comments -->
			<c:forEach var="comment" items="${listComments}">
				<c:set var="count" value="${count + 1}" scope="page" />

				<!-- construct an "delete" link with Comment id -->
				<c:url var="deleteCmt" value="/ManageCommentPage/${page_id}/delete">
					<c:param name="cmtId" value="${comment.id}" />
				</c:url>
				<div class="col-12">
					<table class="table table-dark table-striped">
						<tr style="text-align: left;">
							<th style="width: 50%;">No</th>
							<th style="width: 50%;">${count}</th>
						</tr>
						<tr style="text-align: left;">
							<th style="width: 50%;">Author</th>
							<th style="width: 50%;">${comment.author}</th>
						</tr>
						<tr style="text-align: left;">
							<th style="width: 50%;">Email</th>
							<th style="width: 50%;">${comment.email}</th>
						</tr>
						<tr style="text-align: left;">
							<th style="width: 50%;">Comment</th>
							<th style="width: 50%;">${comment.content}</th>
						</tr>
						<tr style="text-align: left;">
							<th style="width: 50%;">Create Time</th>
							<th style="width: 50%;">${comment.author}</th>
						</tr>
						<tr style="text-align: left;">
							<th style="width: 50%;">Post</th>
							<th style="width: 50%;">${comment.post.title}</th>
						</tr>
						<tr style="text-align: left;">
							<th style="width: 50%;">Delete</th>
							<th style="text-align: center;"><a href="${deleteCmt}"
								data-toggle="tooltip" title="Delete!"><i
									class="fas fa-times-circle"></i></a></th>
						</tr>
					</table>
				</div>
			</c:forEach>
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
