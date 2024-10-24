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
                <c:set var="sevletPath" value="/customer" />

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
                                    <h1 id="tmodal-update">ADD Khách Hàng</h1>
                                </div>

                                <div class="body">
                                    <form:form id="form-data" action="addNew" method="post" modelAttribute="customer-Form">
                                        <div class="modal-body row">

                                            <!-- input Mã Khách Hàng -->
                                            <div class="col-12">
                                                <label class="mb-2 font-weight-bold">
                                                    Nhập Mã Khách Hàng
                                                </label>
                                                <form:input path="maKH" id="id-MaKH" class="form-control" type="text" placeholder="KH0001" />

                                                <div class="error-message text-danger pt-3">
                                                    <span id="id-maKH-error"></span>
                                                    <form:errors path="maKH"></form:errors>
                                                </div>
                                            </div>


                                            <!-- input Tên khách hàng -->
                                            <div class="col-12">
                                                <label class="mb-2 font-weight-bold">
                                                    Nhập Tên Khách Hàng
                                                </label>
                                                <form:input path="tenKH" class="form-control" type="text" placeholder="Nguyễn Văn A" />

                                                <div class="error-message text-danger pt-3">
                                                    <form:errors path="tenKH"></form:errors>
                                                </div>
                                            </div>

                                            <!-- input Địa chỉ -->
                                            <div class="col-12">
                                                <label class="mb-2 font-weight-bold">
                                                    Nhập Địa chỉ Khách Hàng
                                                </label>
                                                <form:input path="diaChi" class="form-control" type="text" placeholder="Quảng Nam" />

                                                <div class="error-message text-danger pt-3">
                                                    <form:errors path="diaChi"></form:errors>
                                                </div>
                                            </div>

                                            <!-- input Số phone -->
                                            <div class="col-12">
                                                <label class="mb-2 font-weight-bold">
                                                    Nhập Số Điện Thoại
                                                </label>
                                                <form:input path="soDienThoai" id="id-Phone" class="form-control" type="text" placeholder="09774053798" />

                                                <div class="error-message text-danger pt-3">
                                                    <span id="id-phone-error"></span>
                                                    <form:errors path="soDienThoai"></form:errors>
                                                </div>
                                            </div>

                                            <!-- input email -->
                                            <div class="col-12">
                                                <label class="mb-2 font-weight-bold">
                                                    Nhập Email
                                                </label>
                                                <form:input path="diaChiEmail" id="id-Email" class="form-control" type="text" placeholder="nguyenvana@gmail.com" />

                                                <div class="error-message text-danger pt-3">
                                                    <span id="id-email-error"></span>
                                                    <form:errors path="diaChiEmail"></form:errors>
                                                </div>
                                            </div>

                                        </div>

                                        <div class="modal-footer">
                                            <button id="id-close" type="reset" class="btn btn-secondary close-add">
                                                Close
                                            </button>

                                            <button onclick="validateKH(event)" type="submit" id="id-submit" class="btn btn-success">
                                                Submit
                                            </button>
                                        </div>
                                    </form:form>
                                </div>
                            </section>

                        </div>
                    </section>

                    <%@include file="../Footer.jsp" %>

                        <script src="${assetsPath}/bootstrap.bundle.min.js"></script>
                        <script src="${assetsPath}/js/customer.js"></script>
                        <script src="${assetsPath}/validation.js"></script>
            </body>

            </html>