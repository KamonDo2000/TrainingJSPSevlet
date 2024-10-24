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
                <c:set var="searchPath" value="${contextPath}/computer/search" />
                <c:set var="paggingPath" value="${contextPath}/computer/index?" />
                <c:set var="sevletPath" value="/computer" />

                <link rel="stylesheet" href="${assetsPath}/css/bootstrap.min.css" />
                <link rel="stylesheet" href="${assetsPath}/css/fontawesome6/css/all.min.css" />
                <link rel="stylesheet" href="${assetsPath}/css/common.css" />
                <script src="${assetsPath}/jquery-3.7.1.min.js"></script>

            </head>

            <body>

                <%@include file="../NavBar.jsp" %>

                    <section class="container">
                        <c:if test="${searchKey != ''}">
                            <c:set var="paggingPath" value="${searchPath}?searchKey=${searchKey}&" />
                        </c:if>

                        <section class=" mt-3">
                            <!-- header -->
                            <header class="row bg-head py-2 px-3 m-0 align-items-center">
                                <h3 class="col-5 text-light">
                                    Manager <span>&nbsp;Computer</span>
                                </h3>
                                <!-- SEARCH INPUT -->
                                <section class="col-3">
                                    <form class="input-group" action="${searchPath}" method="get">
                                        <div class="input-group-prepend">
                                            <button class="input-group-text bg-white">
                                                <i class="fa-solid fa-magnifying-glass"></i>
                                            </button>
                                        </div>
                                        <input name="searchKey" class="form-control" placeholder="Computer....." />
                                    </form>
                                </section>
                                <!-- Button ADD -->
                                <nav class="col-4 d-flex justify-content-center align-items-center">
                                    <button id="add-btn" type="button" class="btn btn-success ml-3">
                                        <i class="fa-solid fa-circle-plus"></i> Add New Computer
                                    </button>
                                </nav>
                            </header>

                            <!-- Content -->
                            <section class="row bg-light justify-content-center py-3 mt-3">
                                <div class="table-responsive px-3 tableFixHead">
                                    <table class="table table-striped">
                                        <thead>
                                            <tr>
                                                <th>Mã Máy</th>
                                                <th>Vị Trí</th>
                                                <th>Trạng Thái</th>
                                                <th>Action</th>
                                            </tr>
                                        </thead>
                                        <tbody id="idTable" class="form">
                                            <c:forEach var="e" items="${computers}" varStatus="loop">
                                                <tr>
                                                    <td class="txt-MaMay">${e.getMaMay()}</td>
                                                    <td class="txt-ViTri">${e.getViTri()}</td>
                                                    <td class="txt-TrangThai">${e.getTrangThai()}</td>
                                                    <td>
                                                        <i onclick="showEditData(${e.getMaMay()})" class="fa-solid fa-pen pencil"></i>
                                                        <i onclick="setIndexDelete(${e.getMaMay()})" class="fa-solid fa-trash trash pl-3" data-toggle="modal" data-target="#delete-modal"></i>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>

                                    </table>
                                </div>
                            </section>
                        </section>

                        <!-- footer -->
                        <%@include file="../PagingPage.jsp" %>
                            <!-- Modal delete -->
                            <%@include file="ModalDelete.jsp" %>
                    </section>

                    <%@include file="../Footer.jsp" %>

                        <script src="${assetsPath}/bootstrap.bundle.min.js"></script>
                        <script src="${assetsPath}/js/computer.js"></script>
            </body>

            </html>