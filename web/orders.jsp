<%-- 
    Document   : orders
    Created on : Jul 2, 2023, 10:33:38 PM
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
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">
            <div style="width: 100%; margin-top: 20px">
                <a href="home" class="mx-3 btn btn-primary" style="background-color: #ee4d2d; border: none;" >Trở về</a>
            </div>
            <div class="card-header my-3">Tất cả các đơn đặt hàng</div>
            <table class="table table-light">
                <thead>
                    <tr>
                        <th scope="col">Date</th>
                        <th scope="col">Name</th>
                        <th scope="col">Quantity</th>
                        <th scope="col">Price</th>

                    </tr>
                </thead>
                <tbody>
                    <c:if test="${orders != null}">
                        <c:forEach var="o" items="${orders}">

                            <tr>
                                <td>${o.date}</td>
                                <td>${o.nameProduct}</td>
                                <td>${o.quantity}</td>
                                <td>${o.priceProduct}</td>

                            </tr>
                        </c:forEach>

                    </c:if>
                </tbody>
            </table>
        </div>
    </body>
</html>
