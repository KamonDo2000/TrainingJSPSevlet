<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page session="true"%>
<head>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/HomePage/contentStyle.css"/>">

<!-- This is include link responsive -->
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/fStyle.css'/>">
<script language="javascript"
	src="<c:url value="/resources/js/validateCommentScript.js"/>"
	type="text/javascript"></script>
<style>
label.error {
	color: red;
}
input:-internal-autofill-selected{
	background-color: white!important;
}
</style>
</head>

<!-- Content and Right Menu -->
<div class="row">

	<!-- Start Content -->
	<div class="col-9 row-content" style="padding: 15px;">

		<!-- Start Test Post-->
		<c:set var="count" value="0" scope="page" />
		<c:forEach var="post" items="${listPost}">
			<c:set var="count" value="${count + 1}" scope="page" />
			<c:set var="post_id" value="${post.id}" scope="page" />
			<c:set var="count_cmt" value="0" scope="page" />
			<c:forEach var="comment" items="${listComments}">
				<div style="margin-top: 10px;">
					<c:set var="comment_post_id" value="${comment.post.id}"
						scope="page"></c:set>
					<c:if test="${post_id == comment_post_id}">
						<c:set var="count_cmt" value="${count_cmt + 1}" scope="page" />
					</c:if>
				</div>
			</c:forEach>
			<div class="row">
				<div class="col-12">
					<h2>${post.title}</h2>
					<hr style="margin: 0px;" color="#C9E0ED">
					<p style="color: gray;">posted by ${post.user.username} on ${post.create_time}</p>
				</div>
			</div>
			<div class="row">
				<div class="col-12">
					<p>${post.content}</p>
				</div>
			</div>

			<!-- Details -->
			<div class="row" style="background-color: #EFFDFF;">
				<div class="col-12">
					<p style="font-weight: bold; display: inline;">Tags:</p>
					<a>${post.tags}</a>
				</div>
				<div class="col-12">
					<p>
						<a href="#"> Permalink </a>|<a data-toggle="collapse"
							href="#collapseExample-${count}" role="button"
							aria-expanded="false" aria-controls="collapseExample-${count}">
							Comments(${count_cmt}) </a>| Last updated on ${post.update_time}
					<p>
				</div>
				<div class="col-12 collapse" id="collapseExample-${count}">
					<form:form id="saveComment" action="saveComment" method="post"
						modelAttribute="commentForm">
						<div class="form-group">
							<p>
								<label for="comment">Comment:</label>
							</p>
							<input name="post_id" style="display: none" value="${post.id}" />
							<input name="status" style="display: none" value="2" />
							<textarea class="form-control" rows="3" id="content"
								name="content" style="font-size: 13px"></textarea>
							<label>Author<span style="color: red">*</span>: </label>
							<p>
								<c:set var="nameUser"
									value="${pageContext.request.userPrincipal.name}"></c:set>
								<c:choose>
									<c:when test="${nameUser != null}">
										<input id="author" name="author"
											class="form-control" style="width: 20%; font-size: 13px;"
											value="<%=session.getAttribute("userName")%>">
									</c:when>
									<c:otherwise>
										<input id="author" name="author"
											class="form-control" style="width: 20%; font-size: 13px;">
									</c:otherwise>
								</c:choose>
							</p>
							<label>Email<span style="color: red">*</span>: </label>
							<p>
								<c:choose>
									<c:when test="${nameUser != null}">
										<input id="email" name="email"
											class="form-control" style="width: 30%; font-size: 13px;"
											value="<%=session.getAttribute("userEmail")%>">
									</c:when>
									<c:otherwise>
										<input id="email" name="email"
											class="form-control" style="width: 30%; font-size: 13px;">
									</c:otherwise>
								</c:choose>
							</p>
							<label>Your Website: </label>
							<p>
								<input id="url" name="url" class="form-control"
									style="width: 80%; font-size: 13px;">
							</p>
						</div>
						<button type="submit" class="btn btn-primary">Submit</button>
					</form:form>
					<div>
						<c:forEach var="comment" items="${listComments}">
							<div style="margin-top: 10px;">
								<c:set var="comment_post_id" value="${comment.post.id}"
									scope="page"></c:set>
								<c:if test="${post_id == comment_post_id}">
									<div>
										<label>Author: </label>
										<p style="margin: 0px; display: inline; font-weight: bold;">
											<c:out value="${comment.author}" />
										</p>
										<label>said: </label>
									</div>
									<div>
										<p style="margin: 0px; display: inline;">
											<c:out value="${comment.content}" />
										</p>
									</div>
								</c:if>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</c:forEach>
		<!-- End Test Post-->

	</div>
	<!-- End Content -->


	<!-- This is a tag button bar of right menu -->
	<span class="mobile-style " id="btn-open-right-menu"
		style="font-size: 20px; cursor: pointer" onclick="openNav()"> <i
		class="fas fa-bars"></i>
	</span>

	<!-- Start Right Menu -->
	<c:set var="nameUser" value="${pageContext.request.userPrincipal.name}"></c:set>
	<c:choose>
		<c:when test="${nameUser != null}">
			<%@ include file="./template/RightMenu.jsp"%>
		</c:when>
		<c:otherwise>
			<%@ include file="./template/rightMenu_notLogin.jsp"%>
		</c:otherwise>
	</c:choose>

	<!-- End Right Menu -->

</div>
