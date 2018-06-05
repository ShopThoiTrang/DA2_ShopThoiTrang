<%-- 
    Document   : contact-us
    Created on : Nov 20, 2017, 12:11:55 PM
    Author     : NhutKha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>

   <!--- basic page needs
   ================================================== -->
   <meta charset="utf-8">
	<title>About</title>
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

	<link href="<%=request.getContextPath() %>/resources/404/css/base.css" rel="stylesheet">
		<link href="<%=request.getContextPath() %>/resources/404/css/main.css" rel="stylesheet">
			<link href="<%=request.getContextPath() %>/resources/404/css/vendor.css" rel="stylesheet">
   <!-- script
   ================================================== -->
<!-- 	<script src="js/modernizr.js"></script> -->
	<script src="<%=request.getContextPath() %>/resources/404/js/bootstrap.min.js"></script>

   <!-- favicons
	================================================== -->
	<link rel="icon" type="image/png" href="favicon.png">

</head>

<body>

	<!-- header 
   ================================================== -->
   <header class="main-header">
   	<div class="row">
      		 <a href="${pageContext.request.contextPath}/home/index"><img src="<%=request.getContextPath() %>/resources/images/home/logo.png" width="300x"  alt="" /></a>  		
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
	</nav>
   <main id="main-404-content" class="main-content-particle-js">

   	<div class="content-wrap">

		   <div class="shadow-overlay"></div>

		   <div class="main-content">
		   	<div class="row">
		   		<div class="col-twelve">
			  		<br>
			  		<br>
			  		<br>
			  			<h2 class="title text-center">Contact Info</h2>
                                <address>
                                    <p>E_Shopper Inc.</p>
                                    <p>484 Lê Văn Việt, phường Tăng Nhơn Phú A, quận 9</p>
                                    <p>TP.HCM</p>
                                    <p>Mobile: +2346 17 38 93</p>
                                    <p>Fax: 1-714-252-0026</p>
                                    <p>Email: info@VNK-shopper.com</p>
                                </address>

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
   <script src="<%=request.getContextPath() %>/resources/404/js/jquery-2.1.3.min.js"></script>
     <script src="<%=request.getContextPath() %>/resources/404/js/plugins.js"></script>
       <script src="<%=request.getContextPath() %>/resources/404/js/main.js"></script>

</body>

</html>