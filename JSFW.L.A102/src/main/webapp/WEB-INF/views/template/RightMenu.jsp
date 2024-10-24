<%@ page language="java" contentType="text/html; charset=UTF8"
    pageEncoding="UTF8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="myContext" value="${pageContext.request.contextPath}"/>

<span class="mobile-style " id="btn-open-right-menu"
	style=" font-size:20px; cursor: pointer" onclick="openNav()"><i class="fas fa-bars"></i></span>
<div class="col-3" id="right-menu">
	<!-- Demo -->
	<div class="row demo">
		<div class="col-12">
			<div style="float: left;"></div>
			<p style="margin: 0; display: inline;"><%=session.getAttribute("userName")%></p>
			<a id="btn-close-right-menu" onclick="closeNav()"><i
				class="fas fa-times-circle"></i></a>
		</div>
		<div class="col-12 ">
			<a href="${myContext}/CreatePostPage">Create New Post</a>
		</div>
		<div class="col-12 ">
			<a href="${myContext}/ManagePostPage/1">Manage Posts</a>
		</div>
		<div class="col-12 ">
			<a href="${myContext}/ManageCommentPage/1">Manage Comments</a>
			<p style="margin: 0px; display: inline;">(<%=session.getAttribute("totalComment")%>)</p>
		</div>
		<div class="col-12 ">
			<a href="${myContext}/Logout">Logout</a>
		</div>
	</div>
	<!-- Tags -->
	<div class="row tags">
		<div class="col-12 ">
			<p style="margin: 0;">Tags</p>
		</div>
		<div class="col-12 ">
			<a href="#">blog test</a>
		</div>
	</div>
	<!-- Recent Comments -->
	<div class="row recent-comment">
		<div class="col-12 border">
			<p style="margin: 0;">Recent Comments</p>
		</div>
		<div class="col-12">
			<p style="margin: 0;">
				Tester on <a href="#">A Test Post</a>
			</p>
		</div>
	</div>
</div>
