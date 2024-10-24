<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Đăng Ký Máy</title>

    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
    <c:set var="assetsPath" value="${contextPath}/resources" />
    <c:set var="addPath" value="${contextPath}/dangkymay/add" />
    <c:set var="sevletPath" value="/dangkymay" />

    <link rel="stylesheet" href="${assetsPath}/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${assetsPath}/css/fontawesome6/css/all.min.css" />
    <link rel="stylesheet" href="${assetsPath}/css/common.css" />
    <script src="${assetsPath}/jquery-3.7.1.min.js"></script>
</head>

<body>

    <%@include file="../NavBar.jsp" %>
<section class="container">
        <section>
            <!-- head -->
            <div class="text-center mt-2 mb-2 h3">Đăng Ký Sử Dụng Máy</div>

            <form:form class="form" action="${addPath}" method="post" modelAttribute="may-Form">
                <section class="d-flex flex-column align-items-center">
                    <div class="col-6">
                        <label for="id-combobox-1" class="mb-2 font-weight-bold">Chọn khách hàng </label>
                        <form:select path="id.maKH" id="id-combobox-1" class="custom-select form-data">
                            <option hidden="true" disabled selected value="">Chọn Khách hàng</option>

                            <c:forEach var="e" items="${listMaKH}" varStatus="loop">
                                <option value="${e}">${e}</option>
                            </c:forEach>

                        </form:select>
                        
                        <div class="error-message text-danger pt-2">
                        	<form:errors path="id.maKH"></form:errors>
                        </div>
                    </div>



                    <div class="col-6">
                        <label for="id-combobox-2" class="mb-2 font-weight-bold"> Mã Máy</label>
                        <form:select path="id.maMay" id="id-combobox-2" class="custom-select form-data">
                            <option hidden="true" disabled selected value="">Chọn Máy</option>

                           	<c:forEach var="e" items="${listMaMay}" varStatus="loop">
                                <option value="${e}">${e}</option>
                            </c:forEach>

                        </form:select>
                        <div class="error-message text-danger pt-2">
                       	 	<form:errors path="id.maMay"></form:errors>
                        </div>
                    </div>

                    <div class="col-6">
                        <label for="id-input-3" class="mb-1 font-weight-bold"> Ngày Bắt Đầu sử dụng </label> 
                        <form:input path="id.ngayBatDau" id="id-input-3" type="date" class="form-control form-data"/>
                        
                        <div class="error-message text-danger pt-2">
                        	<form:errors path="id.ngayBatDau"></form:errors>
                        </div>
                    </div>

                    <div class="col-6">
                        <label for="id-input-4" class="mb-1 font-weight-bold"> Thời gian bắt đầu </label> 
						<form:input path="id.gioBatDau" id="id-input-4" type="time" class="form-control form-data"/>
                        
                        <div class="error-message text-danger pt-2">
                        	<form:errors path="id.gioBatDau"></form:errors>
                        </div>
                    </div>

                    <div class="col-6">
                        <label for="id-input-5" class="mb-1 font-weight-bold"> Thời gian dùng (Phút) </label> 
                        <form:input path="thoiGianSuDung" type="number" id="id-input-5" class="form-control form-data"/>
                        <div class="error-message text-danger pt-2">
                        	<form:errors path="thoiGianSuDung"></form:errors>
                        </div>
                    </div>

                    <!-- Row 3 -->
                    <div class="mt-1">
                        <input class="btn btn-outline-info" type="submit" value="Thêm Thông Tin" />
                    </div>
                </section>
            </form:form>
        </section>
</section>

<%@include file="../Footer.jsp" %>

 	<script src="${assetsPath}/bootstrap.bundle.min.js"></script>
    <script src="${assetsPath}/js/dangKyMay.js"></script>
</body>

</html>