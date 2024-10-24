<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="col-12">
	<div class="pagination">
		<a href="1">&laquo;</a>
		<c:choose>
			<c:when test="${page_id > 1}">
				<a href="${page_id-1}">&lsaquo;</a>
			</c:when>
			<c:otherwise>
				<a href="${1}">&lsaquo;</a>
			</c:otherwise>
		</c:choose>

		<c:forEach begin="1" end="${page}" var="val">
			<c:if test="${page < 4}">
				<a class="active" href="<c:out value="${val}" />"><c:out
						value="${val}" /></a>
			</c:if>
		</c:forEach>
		<c:choose>
			<c:when test="${page_id < page}">
				<a href="${page_id+1}">&rsaquo;</a>
			</c:when>
			<c:otherwise>
				<a href="${page}">&rsaquo;</a>
			</c:otherwise>
		</c:choose>
		<a href="${page}">&raquo;</a>
	</div>
</div>