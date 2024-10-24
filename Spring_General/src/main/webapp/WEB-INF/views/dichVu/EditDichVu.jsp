<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Computer Manager</title>
<!-- Handel Path link -->
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="assetsPath" value="${contextPath}/resources" />
<c:set var="sevletPath" value="/dichvu" />

<link rel="stylesheet" href="${assetsPath}/css/bootstrap.min.css" />
<link rel="stylesheet" href="${assetsPath}/css/fontawesome6/css/all.min.css" />
<link rel="stylesheet" href="${assetsPath}/css/common.css" />
<script src="${assetsPath}/jquery-3.7.1.min.js"></script>
</head>

<body>
<%@include file="../NavBar.jsp" %>

<section class="container">
<div class="d-flex justify-content-center mt-1">
    <section class="w-50" id="addNewModal">

        <div class="header">
            <h1 id="tmodal-update">Edit Dịch Vụ</h1>
        </div>

        <div class="body">
            <form:form id="form-data" action="update" method="post" modelAttribute="dichVu-Form">
                <div class="modal-body row">

                    <form:input path="maDV" id="id-MaDV" type="hidden" />

                    <!-- input Tên DV -->
                    <div class="col-12">
                        <label for="id-input-1" class="mb-2 font-weight-bold">
                            Nhập Tên Dịch Vụ
                        </label>
                        <form:input path="tenDV" class="form-control" id="id-input-1" type="text" placeholder="Mì Tôm" />

                        <div class="error-message text-danger pt-3">
                            <form:errors path="tenDV"></form:errors>
                        </div>
                    </div>

                    <!-- input Đơn Giá -->
                    <div class="col-12">
                        <label for="id-input-2" class="mb-2 font-weight-bold">
                            Nhập Đơn Giá
                        </label>
                        <form:input path="donGia" class="form-control" id="id-input-2" type="text" placeholder="30000" />

                        <div class="error-message text-danger pt-3">
                            <form:errors path="donGia"></form:errors>
                        </div>
                    </div>

                    <!-- input Đơn Vị Tính -->
                    <div class="col-12">
                        <label for="id-input-3" class="mb-2 font-weight-bold">
                            Nhập Đơn Vị Tính
                        </label>
                        <form:input path="donViTinh" class="form-control" id="id-input-3" type="text" placeholder="Tô" />

                        <div class="error-message text-danger pt-3">
                            <form:errors path="donViTinh"></form:errors>
                        </div>
                    </div>

                </div>

                <div class="modal-footer">
                    <button id="id-close" type="reset" class="btn btn-secondary close-add">
                        Close
                    </button>

                    <button type="submit" id="id-submit" class="btn btn-primary">
                        Edit
                    </button>

                </div>
            </form:form>
        </div>
    </section>
</div>
</section>

<%@include file="../Footer.jsp" %>

<script src="${assetsPath}/bootstrap.bundle.min.js"></script>
<script src="${assetsPath}/js/controlDV.js"></script>
</body>

</html>