<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
</head>

<body>
    <!-- footer -->
    <footer class="row bg-light py-2 px-3 m-0">
        <!-- count model -->
        <div class="col-9 text-secondary">
            showing <span>&nbsp;${soPhanTu1Trang}&nbsp;</span> out of <span>&nbsp;${tongSoBangGhi}&nbsp;</span>
            entries
        </div>
        <!-- pagination -->
        <nav class="col-3" aria-label="...">
            <div class="pagination">
            
               <a id="id-curr" href="${paggingPath}page=${currentPage-1}" class="page-link text-secondary bg-unset">
               Previous
               </a>
               
              	<c:choose>
              		<c:when test="${totalPages<3}">
				        <c:set var="end" value="${totalPages}" />
				        <c:set var="start" value="1" />
				    </c:when>
				    
				    <c:when test="${currentPage < (totalPages-2)}">
				        <c:set var="end" value="${currentPage+2}" />
				        <c:set var="start" value="${currentPage}" />
				    </c:when>
	
				    <c:otherwise>
				        <c:set var="end" value="${totalPages}" />
				        <c:set var="start" value="${totalPages-2}" />
				    </c:otherwise>
				</c:choose>
               
                
                <c:forEach begin="${start}" end="${end}" var="i">
                    <c:choose>
                        <c:when test="${currentPage == i}">
                            <a href="${paggingPath}page=${i}" class="page-link text-light bg-active">${i}</a>
                        </c:when>
                        <c:otherwise>
                            <a href="${paggingPath}page=${i}" class="page-link text-secondary bg-unset">${i}</a>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                
              <a id="id-next" href="${paggingPath}page=${currentPage+1}" class="page-link text-secondary bg-unset">
              Next
             </a>
                
            </div>
        </nav>
    </footer>
    
     <script>
     	$(document).ready(function() {
    		if (${currentPage} <= 1) {
    			$("#id-curr").css("pointer-events", "none");
    		}

    		if (${currentPage} >= ${totalPages}) {
    			$("#id-next").css("pointer-events", "none");
    		}
    	});
     </script>
</body>

</html>