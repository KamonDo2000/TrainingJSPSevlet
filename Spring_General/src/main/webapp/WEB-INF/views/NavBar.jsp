<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    
<style type="text/css"> 
	.bg-black{
		background: #343a40d6;
	}
</style>
    
</head>

<body>
<section class="bg-black">
    <h2 class="pl-3 pt-4 text-light">Manager Cybersoft</h2>

    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
            <a id="nav-Home" class="navbar-brand" href="${contextPath}/home/index">HOME</a>

            <ul class="navbar-nav mr-auto mt-2 mt-lg-0">

                <li class="nav-item">
                    <a id="nav-computer" class="nav-link" href="${contextPath}/computer/index">
                        Máy Tính
                    </a>
                </li>

                <li class="nav-item">
                    <a id="nav-custommer" class="nav-link" href="${contextPath}/customer/index">
                        Khách Hàng
                    </a>
                </li>
                
                <li class="nav-item">
                    <a id="nav-DichVu" class="nav-link" href="${contextPath}/dichvu/index">
                       Dịch Vụ
                    </a>
                </li>

                <li class="nav-item">
                    <a id="nav-DangKyMay" class="nav-link" href="${contextPath}/dangkymay/index">
                        Dang Ky May
                    </a>
                </li>
                
                <li class="nav-item">
                    <a id="nav-DangKyDichVu" class="nav-link" href="${contextPath}/dangkydichvu/index">
                        Dang Ky Dich Vu
                    </a>
                </li>
				
            </ul>
        </div>
    </nav>
				<input id="path" type="hidden" value="${sevletPath}"/>
</section>
    <script>
        $(document).ready(function () {
            /* var context = "${requestScope['javax.servlet.forward.servlet_path']}"; */
			var context = $('#path').val();
			
            if (context == "/computer") {
                $("#nav-computer").addClass("bg-success text-white");
            }else if (context == "/customer") {
                $("#nav-custommer").addClass("bg-success text-white");
            }else if (context == "/dichvu") {
                $("#nav-DichVu").addClass("bg-success text-white");
            }else if (context == "/dangkymay") {
                $("#nav-DangKyMay").addClass("bg-success text-white");
            }else if (context == "/dangkydichvu") {
                $("#nav-DangKyDichVu").addClass("bg-success text-white");
            }else {
            	$("#nav-Home").addClass("text-success");
			}
        });
    </script>
</body>

</html>