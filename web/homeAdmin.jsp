<%-- 
    Document   : homeAdmin
    Created on : Jul 2, 2023, 11:51:53 PM
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
            <div class="card-header my-3" style="color: #ef5c37">Admin Shopee: ${account.name}</div>
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
                    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                        <li class="nav-item active" >
                            <a class="nav-link" style="color: #ef5c37" href="homeAdmin">Home <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link " href="productAdmin">Product</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="logoutAdmin">Logout</a>
                        </li>
                    </ul>
                    <form class="form-inline my-2 my-lg-0" action="homeAdmin">
                        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="name" value="${sname}">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                    </form>
                </div>
            </nav>
            <table class="table table-light">
                <thead>
                    <tr>
                        <th scope="col">Date</th>
                        <th scope="col">Mail</th>
                        <th scope="col">Name Customer</th>
                        <th scope="col">Address</th>
                        <th scope="col">Number Phone</th>
                        <th scope="col">Name Product</th>
                        <th scope="col">Quantity</th>
                        <th scope="col">Price</th>
                        <th scope="col">PayMent</th>
                        <th scope="col">Delete</th>
                    </tr>
                </thead>
                <tbody>
                    <c:if test="${listOrdersCustomer != null}">
                        <c:forEach var="o" items="${listOrdersCustomer}">

                            <tr>
                                <td>${o.date}</td>
                                <td>${o.mail}</td>
                                <td>${o.nameCustomer}</td>
                                <td>${o.address}</td>
                                <td>${o.phone}</td>
                                <td>${o.nameProduct}</td>
                                <td>${o.quantity}</td>
                                <td>${o.priceProduct}</td>
                                <td>${o.payment}</td>
                                <td>
                                    <form action="deleteAdmin" method="POST">
                                        <input type="hidden" name="id" value="${o.id}">
                                        <input type="submit" value="✖" />
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>

                    </c:if>
                </tbody>
            </table>
        </div>
    </body>
</html>
