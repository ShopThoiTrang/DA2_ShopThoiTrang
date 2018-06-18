<%-- 
    Document   : account
    Created on : Nov 20, 2017, 12:31:57 PM
    Author     : NhutKha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>account</title>
    </head>
    <body>

        <jsp:include page="header.jsp"></jsp:include>

            <section id="form"><!--form-->
                <div class="container">
                    <div class="row">
                        <div class="col-sm-4 col-sm-offset-1">
                            <div class="login-form"><!--login form-->
                                <h2>Đăng nhập hệ thống</h2>
                            <form:form action="register" modelAttribute="userForm" method="post">
                                <form:errors path="userEmail" cssClass="error"/>
                                <form:input path="userEmail" size="30" placeholder="Email Address"/>
                                <form:errors path="userPass" cssClass="error"/>
                                <form:password path="userPass" size="30" placeholder="Password"/>
                                <span><a href="#">Quên mật khẩu?</a></span>
                                <input type="submit" class="btn btn-default" value="Login" name="action" />
                            </form:form>
                        </div><!--/login form-->
                    </div>
                    <div class="col-sm-1">
                        <h2 class="or">OR</h2>
                    </div>
                    <div class="col-sm-4">
                        <div class="signup-form"><!--sign up form-->
                            <h2>Tạo tài khoản!</h2>
                            <form:form action="register" modelAttribute="userForm" method="post">
                                <form:errors path="userName" cssClass="error"/>
                                <form:input path="userName" size="30" placeholder="Full Name"/>
                                <form:errors path="userEmail" cssClass="error"/>
                                <form:input path="userEmail" size="30" placeholder="Email Address"/>
                                <form:errors path="userPass" cssClass="error"/>
                                <form:password path="userPass" size="30" placeholder="Password"/>
                                <input type="submit" class="btn btn-default" value="Register" name="action"/>
                            </form:form>
                        </div><!--/sign up form-->
                    </div>
                </div>
            </div>
        </section><!--/form-->

        <jsp:include page="footer.jsp"></jsp:include>

    </body>
</html>
