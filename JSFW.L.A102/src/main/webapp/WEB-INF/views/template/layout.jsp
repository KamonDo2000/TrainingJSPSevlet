<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">

<head>
<!-- This is a include of head, consist of tags meta, link common css -->
<tiles:insertAttribute name="head" />

<!-- This is include link HomePage css -->
<%-- <tiles:insertAttribute name="css" /> --%>
<%@ page isELIgnored="false"%>
<!-- Title Home -->
<title><tiles:getAsString name="title" /></title>
</head>

<body>
	<!--Start Header-->
	<tiles:insertAttribute name="header" />
	<!--End Header-->

	<!--Start body-->
	<div class="container-xl mt-3">
		<tiles:insertAttribute name="body" />
	</div>
	<!--End Body-->

	<!--Start footer-->
	<tiles:insertAttribute name="footer" />
	<!--End footer-->
</body>

</html>