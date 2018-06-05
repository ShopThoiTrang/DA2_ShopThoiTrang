<%-- 
    Document   : menu
    Created on : Nov 20, 2017, 11:32:32 AM
    Author     : NhutKha
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>menu</title>
    </head>
    <body>

        <div class="col-sm-3">
            <div class="left-sidebar">

                <div class="brands_products"><!--brands_products-->
                    <h2>Category</h2>
                    <div class="brands-name">
                        <ul class="nav nav-pills nav-stacked">

                            <c:forEach var="item" items="${listCategory}">
                                <li><a href="${pageContext.request.contextPath}/product/list?categoryID=${item.categoryID}">${item.categoryName}</a></li>
                                </c:forEach>

                        </ul>
                    </div>
                </div><!--/brands_products-->
            </div>
        </div>

    </body>
</html>
