<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>

    <!--- basic page needs
    ================================================== -->
    <meta charset="utf-8">
    <title>404-Not found</title>
    <meta name="description" content="">  
    <meta name="author" content="">

    <!-- mobile specific metas
    ================================================== -->
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

    <!-- CSS
================================================== -->
    <!--    <link rel="stylesheet" href="css/base.css">   -->
    <!--    <link rel="stylesheet" href="css/main.css"> -->
    <!--    <link rel="stylesheet" href="css/vendor.css">      -->

    <link href="<%=request.getContextPath()%>/resources/404/css/base.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/resources/404/css/main.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/resources/404/css/vendor.css" rel="stylesheet">-->
    <!-- script
    ================================================== -->
    <!-- 	<script src="js/modernizr.js"></script> -->
    <script src="<c:url value="/resources/404/js/bootstrap.min.js"/>" type="text/javascript"></script>


    <!-- favicons
         ================================================== -->
    <link rel="icon" type="image/png" href="favicon.png">

</head>

<body>

    <!-- header 
================================================== -->
    <header class="main-header">
        <div class="row">

            <a href="${pageContext.request.contextPath}/home/index"><img src="<c:url value="/resources/images/home/logo.png" />" width="300x"   alt="" /></a>

        </div>   

        <a class="menu-toggle" href="#"><span>Menu</span></a>	
    </header> <!-- /header -->

    <!-- navigation 
    ================================================== -->
    <nav id="menu-nav-wrap">

        <h5>Site Pages</h5>   	
        <ul class="nav-list">
            <li><a href="index.html" title="">Home</a></li>
            <li><a href="about.html" title="">About</a></li>		
            <li><a href="contact-us.html" title="">Contact</a></li>					
        </ul>

        <h5>404</h5>  
        <p>Comeback home.</p>

    </nav>
    <main id="main-404-content" class="main-content-particle-js">

        <div class="content-wrap">

            <div class="shadow-overlay"></div>

            <div class="main-content">
                <div class="row">
                    <div class="col-twelve">

                        <h1 class="kern-this">404 Error.</h1>
                        <p>
                            Oooooops! Looks like nothing was found at this location.
                            Maybe try on of the links below, click on the top menu
                            or try a search?
                        </p>


                    </div> <!-- /twelve --> 		   			
                </div> <!-- /row -->    		 		
            </div> <!-- /main-content --> 

            <footer>
                <div class="row">

                    <div class="col-seven tab-full social-links pull-right">
                        <ul>
                            <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                            <li><a href="#"><i class="fa fa-behance"></i></a></li>
                            <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                            <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
                            <li><a href="#"><i class="fa fa-instagram"></i></a></li>   			
                        </ul>
                    </div>

                    <div class="col-five tab-full bottom-links">
                        <ul class="links">
                            <li><a href="index.html">Homepage</a></li>
                            <li><a href="about.html">About</a></li>		                    
                        </ul>

                    </div>   		   		

                </div> <!-- /row -->    		  		
            </footer>

        </div> <!-- /content-wrap -->

    </main> <!-- /main-404-content -->

    <div id="preloader"> 
        <div id="loader"></div>
    </div> 


    <!-- Java Script
    ================================================== --> 
    <!--    <script src="js/jquery-2.1.3.min.js"></script> -->
    <!--    <script src="js/plugins.js"></script> -->
    <!--    <script src="js/main.js"></script> -->
    <script src="<c:url value="/resources/404/js/jquery-2.1.3.min.js"/>" type="text/javascript"></script>
    <script src="<c:url value="/resources/404/js/plugins.js"/>" type="text/javascript"></script>
    <script src="<c:url value="/resources/404/js/main.js"/>" type="text/javascript"></script>
 <!--   <script src="<%=request.getContextPath()%>/resources/404/js/jquery-2.1.3.min.js"></script>
      <script src="<%=request.getContextPath()%>/resources/404/js/plugins.js"></script>
        <script src="<%=request.getContextPath()%>/resources/404/js/main.js"></script>-->

</body>

</html>