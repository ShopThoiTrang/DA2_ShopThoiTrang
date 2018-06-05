<%-- 
    Document   : header
    Created on : Nov 20, 2017, 10:18:17 AM
    Author     : NhutKha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>header</title>

        <link href="<c:url value="/resources/css/animate.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/font-awesome.min.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/prettyPhoto.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/price-range.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/responsive.css" />" rel="stylesheet">
        <script src="<c:url value="/resources/js/ourjsfile.js"/> "type="text/javascript"></script>
        <script src="<c:url value="/resources/js/bootstrap.min.js"/> "type="text/javascript"></script>
        <script src="<c:url value="/resources/js/gmaps.js"/> "type="text/javascript"></script>
        <script src="<c:url value="/resources/js/html5shiv.js"/> "type="text/javascript"></script>
        <script src="<c:url value="/resources/js/jquery.js"/> "type="text/javascript"></script>
        <script src="<c:url value="/resources/js/jquery.prettyPhoto.js"/> "type="text/javascript"></script>
        <script src="<c:url value="/resources/js/jquery.scrollUp.min.js"/> "type="text/javascript"></script>
        <script src="<c:url value="/resources/js/main.js"/> "type="text/javascript"></script>
        <script src="<c:url value="/resources/js/price-range.js"/> "type="text/javascript"></script>

    </head>
    <body>

        <header id="header"><!--header-->
            <div class="header_top"><!--header_top-->
                <div class="container">
                    <div class="row">
                        <div class="col-sm-6">
                            <div class="contactinfo">
                                <ul class="nav nav-pills">
                                    <li><a href="#"><i class="fa fa-phone"></i> +84 164 86 07 233</a></li>
                                    <li><a href="#"><i class="fa fa-envelope"></i> VNKshop@domain.com</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="social-icons pull-right">
                                <ul class="nav navbar-nav">
                                    <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                    <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                    <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                                    <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
                                    <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--/header_top-->

            <div class="header-middle"><!--header-middle-->
                <div class="container">
                    <div class="row">
                        <div class="col-sm-4">
                            <div class="logo pull-left">
                                <a href="${pageContext.request.contextPath}/"><img src="<c:url value="/resources/images/home/logo.png" />" alt="" /></a>
                            </div>

                        </div>
                        <div class="col-sm-8">
                            <div class="shop-menu pull-right">
                                <ul class="nav navbar-nav">
                                    <li><a href="cartoder"><i class="fa fa-shopping-cart"></i> Cart</a></li>
                                        <c:choose>

                                        <c:when test="${users!='' && login=='enable'}">
                                            <li><a>${(users.getUserName()) }</a></li>
                                            <li><a href="exit"><i class="fa fa-lock"></i> Exit</a></li>
                                            </c:when>
                                            <c:otherwise>

                                            <li><a href="register"><i class="fa fa-lock"></i> Login</a></li>
                                            </c:otherwise>

                                    </c:choose>

                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--/header-middle-->

            <div class="header-bottom"><!--header-bottom-->
                <div class="container">
                    <div class="row">
                        <div class="col-sm-9">
                            <div class="navbar-header">
                                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                                    <span class="sr-only">Toggle navigation</span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                </button>
                            </div>
                            <div class="mainmenu pull-left">
                                <ul class="nav navbar-nav collapse navbar-collapse">
                                    <li><a href="${pageContext.request.contextPath}/home/index">Home</a></li>
                                    <!--                                    <li class="dropdown"><a href="#">Shop<i class="fa fa-angle-down"></i></a>
                                                                            <ul role="menu" class="sub-menu">
                                                                                <li><a href="index">Products</a></li>
                                                                                <li><a href="product-details.html">Product Details</a></li> 
                                                                                <li><a href="checkout.html">Checkout</a></li> 
                                                                                <li><a href="cart.html">Cart</a></li> 
                                                                                <li><a href="${pageContext.request.contextPath}/home/register" class="active">Login</a></li> 
                                                                            </ul>
                                                                        </li> 
                                                                        <li class="dropdown"><a href="#">Blog<i class="fa fa-angle-down"></i></a>
                                                                            <ul role="menu" class="sub-menu">
                                                                                <li><a href="blog.html">Blog List</a></li>
                                                                                <li><a href="blog-single.html">Blog Single</a></li>
                                                                            </ul>
                                                                        </li> -->
                                    <li><a href="${pageContext.request.contextPath}/about" >About</a></li>
                                    <li><a href="${pageContext.request.contextPath}/404">404</a></li>
                                    <li><a href="${pageContext.request.contextPath}/contact-us">Contact</a></li>

                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--/header-bottom-->
        </header><!--/header-->

    </body>
</html>
