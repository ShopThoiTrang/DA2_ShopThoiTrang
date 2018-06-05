<%-- 
    Document   : content
    Created on : Nov 20, 2017, 11:35:55 AM
    Author     : NhutKha
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>content</title>
    </head>
    <body>

        <div class="col-sm-9 padding-right">
            <div class="features_items"><!--features_items-->
                <h2 class="title text-center">Features Items</h2>

                <c:forEach var="item" items="${listProduct}">
                    <div class="col-sm-4">
                        <div class="product-image-wrapper">
                            <div class="single-products">
                                <div class="productinfo text-center">
                                    <img src="<c:url value="/resources/images/shop/${item.productImage}" />" alt="" />
                                    <h2>$ ${item.productPrice}</h2>
                                    <p> ${item.productName}</p>
                                     <input type="HIDDEN" name="itemID" value="${item.productID}"/>
                                    <a href="orderpage" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
                                </div>
                                <div class="product-overlay">
                                    <div class="overlay-content">
                                        <<h2>$ ${item.productPrice} </h2>
                                        <p> ${item.productName}</p>
                                        <form:form action="orderpage">
                                        <input type="HIDDEN" name="itemID" value="${item.productID}" />
                                       
                                     <input type="submit" class="btn btn-default" value="Add to cart" name="action2" />
                                        </form:form>
                                    </div>
                                </div>
                            </div>
                            <div class="choose">
                                <ul class="nav nav-pills nav-justified">
                                    <li><a href="${pageContext.request.contextPath}/detail?ID=${item.productID}"><i class="fa fa-plus-square"></i>More Detail</a></li>
                                   
                                </ul>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div><!--features_items-->
        </div>
    </body>
</html>
