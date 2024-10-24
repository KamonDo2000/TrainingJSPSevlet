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
<c:set var="sevletPath" value="/computer" />

<link rel="stylesheet" href="${assetsPath}/css/bootstrap.min.css" />
<link rel="stylesheet" href="${assetsPath}/css/fontawesome6/css/all.min.css" />
<link rel="stylesheet" href="${assetsPath}/css/common.css" />
<script src="${assetsPath}/jquery-3.7.1.min.js"></script>
</head>

<body>
<%@include file="../NavBar.jsp" %>

<section class="container">
    <div class="d-flex justify-content-center mt-5">
        <section class="w-50" id="addNewModal">
            <h1 id="tmodal-update">Add Computer</h1>

            <form:form action="AddOrUpdate" method="post" modelAttribute="computer-Form">
            
                <form:input id="id-maMay" type="hidden" path="maMay" />

                <!-- input vi tri -->
                <div class="col-12">
                    <label class="mb-2 font-weight-bold">
                        Nhập vị trí
                    </label>
                    <form:input class="form-control" type="text" placeholder="001" path="viTri" />

                    <div class="error-message text-danger pt-3">
                        <form:errors path="viTri"></form:errors>
                    </div>
                </div>

                <!-- select trang thai -->
                <div class="col-12">
                    <label class="mb-2 font-weight-bold">
                        Trạng thái
                    </label>

                    <form:select path="trangThai" class="custom-select">
                        <option disabled selected value="">Chọn trạng thái</option>
                        <option value="Active">Active</option>
                        <option value="Non Active">Non Active</option>
                        <option value="Pending">Pending</option>
                    </form:select>

                    <div class="error-message text-danger pt-3">
                        <form:errors path="trangThai"></form:errors>
                    </div>
                </div>

				<div class="modal-footer">
                <button id="id-close" type="reset" class="btn btn-secondary close-add">
                    Close
                </button>

                <button type="submit" id="id-submit" class="btn btn-success">
                	Submit
                </button>
				</div>
            </form:form>

        </section>
    </div>
</section>
<%@include file="../Footer.jsp" %>
    <script src="${assetsPath}/bootstrap.bundle.min.js"></script>
    <script src="${assetsPath}/js/computer.js"></script>
    
</body>

</html>