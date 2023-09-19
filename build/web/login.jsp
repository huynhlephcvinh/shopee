<%-- 
    Document   : login
    Created on : Jun 10, 2023, 11:26:18 AM
    Author     : ACER-PC
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Huynh Le Phuc Vinh</title>
        <link rel="icon" href="https://shopee.vn/assets/icon_favicon_1_96.png" type="image/x-icon" />
        <link rel="stylesheet" href="css/base.css">
        <link rel="stylesheet" href="css/main.css">
        <link rel="stylesheet" href="css/grid.css">
        <link rel="stylesheet" href="css/responsive.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css" integrity="sha512-NhSC1YmyruXifcj/KFRWoC561YpHpc5Jtzgvbuzx5VozKpWvQ+4nXhPdFgmx8xqexRcpAglTj9sIBWINXa8x5w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="font/fontawesome-free-5.15.4-web/fontawesome-free-5.15.4-web/css/all.min.css">
    </head>
    <body>
        <div class="modal">
            <div class="modal__overlay"></div>
            <div class="modal___body">  
                <!-- Login form -->
                <form class="auth-form" action="login" method="post">
                    <div class="auth-form__container">
                        <div class="auth-form__header">
                            <h3 class="auth-form__heading">Đăng nhập</h3>
                            <a href="register" style="text-decoration: none">
                                <span class="auth-form__switch-btn">Đăng ký</span>
                            </a>
                        </div>

                        <div class="auth-form__form">
                            <div class="auth-form__group">
                                <input type="text" class="auth-form__input" name="email" placeholder="Email của bạn">
                            </div>
                            <div class="auth-form__group">
                                <input type="password" class="auth-form__input" name="password" placeholder="Mật khẩu của bạn">
                            </div>
                            <p class="auth-form__group" style="color: red;size: 14px">${msg}</p>
                            <c:set var="msg" value="${null}" scope="session"></c:set>
                        </div>


                        <div class="auth-form__aside">
                            <div class="auth-form__help">
                                <a href="" class="auth-form__help-link auth-form__help-forgot">Quên mật khẩu</a>
                                <span class="auth-form__help-separate"></span>
                                <a href="" class="auth-form__help-link">Cần trợ giúp?</a>
                            </div>
                        </div>

                        <div class="auth-form__controls">
                            <a href="home" class="btn btn--normal mg-right">TRỞ LẠI</a>
                            <button type="submit" class="btn btn--primary">ĐĂNG NHẬP</button>
                        </div>
                    </div>

                    <div class="auth-form__socials">
                        <a href="#" class="auth-form__socials--facebook btn btn--size-s btn--with-icon">
                            <i class="auth-form__socials-icon fab fa-facebook-square"></i>
                            <span class="auth-form__socials-title">Kết nối với Facebook</span>
                        </a>

                        <a href="#" class="auth-form__socials--google auth-form__socials-icon btn btn--size-s btn--with-icon">
                            <i class="auth-form__socials-icon fab fa-google"></i>
                            <span class="auth-form__socials-title">Kết nối với Google</span>
                        </a>
                    </div>
                </form>
            </div>
        </div> 
    </body>
</html>
