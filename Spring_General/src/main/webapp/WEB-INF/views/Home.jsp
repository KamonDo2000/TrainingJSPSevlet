<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- Handel Path link -->
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="assetsPath" value="${contextPath}/resources" />
<c:set var="paggingPath" value="${contextPath}/home/index?" />
<c:set var="sevletPath" value="/home" />

<link rel="stylesheet" href="${assetsPath}/css/bootstrap.min.css" />
<link rel="stylesheet" href="${assetsPath}/css/fontawesome6/css/all.min.css" />
<link rel="stylesheet" href="${assetsPath}/css/common.css" />
<script src="${assetsPath}/jquery-3.7.1.min.js"></script>

<style type="text/css">
	
	.ok{
	text-align: right !important;
	}
	
	.lefsf{
	text-align: left !important;
	}

</style>

</head>

<body>

<%@include file="NavBar.jsp" %>

<section class="container">
	<section class=" mt-3">
	    <!-- header -->
	    <header class="row bg-head py-2 px-3 m-0 align-items-center">
	        <h3 class="col-5 text-light">
	            Manager <span>&nbsp;Home</span>
	        </h3>
	    </header>
	
	    <!-- Content -->
	    <section class="row bg-light justify-content-center py-3 mt-3">
	        <div class="table-responsive px-3 tableFixHead">
	            <table class="table table-striped" style="width: max-content !important">
	                <thead>
	                    <tr>
	                        <th>Mã Khách Hàng</th>
	                        <th>Tên Khách Hàng</th>
	                        <th>Mã Máy</th>
	                        <th>Vị Trí</th>
	                        <th>Trạng Thái</th>
	                        <th>Ngày bắt đầu sử dụng máy</th>
	                        <th>Giờ bắt đầu sử dụng máy</th>
	                        <th>Thời gian sử dụng máy</th>
	                        <th>Mã Dịch Vụ</th>
	                        <th>Ngày sử dụng dịch vụ</th>
	                        <th>Giờ sử dụng dịch vụ</th>
	                        <th>Số lượng</th>
	                        <th>Đơn Giá</th>
	                      	<th>Tổng tiền</th>
	                    </tr>
	                </thead>
	                <tbody id="idTable" class="form">
	                    <c:forEach var="e" items="${arrObject}">
	                        <tr>
	                            <td class="">${e[0]}</td>
	                            <td class="lefsf">${e[1]}</td>
	                            <td class="">${e[2]}</td>
	                            <td class="">${e[3]}</td>
	                            <td class="">${e[4]}</td>
	                            <td class="">${e[5]}</td>
	                            <td class="">${e[6]}</td>
	                            <td class="ok">${e[7]}</td>
	                            <td class="">${e[8]}</td>
	                            <td class="">${e[9]}</td>
	                            <td class="">${e[10]}</td>
	                            <td class="ok">${e[11]}</td>
	                            <td class="ok">${e[12]}</td>
	                            <td class="ok">${e[12]*e[11]}</td>
	                        </tr>
	                    </c:forEach>
	                </tbody>
	
	            </table>
	        </div>
	    </section>
	</section>

<!-- footer -->
<%@include file="PagingPage.jsp" %>
</section>

<%@include file="Footer.jsp" %>

</body>

</html>