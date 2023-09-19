<%-- 
    Document   : productAdmin
    Created on : Jul 11, 2023, 10:54:50 PM
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
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
                <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                    <li class="nav-item ">
                        <a class="nav-link" href="homeAdmin">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link " style="color: #ef5c37" href="productAdmin">Product</a>
                    </li>
                    <li class="nav-item ">
                        <a class="nav-link " href="addProductAdmin">Add Product</a>
                    </li>
                </ul>

            </div>
        </nav>
        <table class="table table-light">
            <thead>
                <tr>
                    <th scope="col">No</th>
                    <th scope="col">image</th>
                    <th scope="col">Name Product</th>
                    <th scope="col">Price Old</th>
                    <th scope="col">Price New</th>
                    <th scope="col">Sold</th>
                    <th scope="col">Brand</th>
                    <th scope="col">Origin</th>
                    <th scope="col">Sale(%)</th>
                    <th scope="col">Description</th>
                    <th scope="col">Status sale(on/off)</th>
                    <th scope="col">Favourite(on/off)</th>
                    <th scope="col">Update</th>
                    <th scope="col">Delete</th>
                </tr>
            </thead>
            <tbody>
                <c:if test="${listAdmin != null}">
                    <c:forEach var="o" items="${listAdmin}" varStatus="count">

                        <tr>
                            <td>${count.count}</td>
                            <td><img src="img/${o.img}" alt="" style="width: 42px;height: 42px;border: 1px solid #E8E8E8;"/></td>
                            <td>${o.name}</td>
                            <td>${o.priceOld}</td>
                            <td>${o.priceNew}</td>
                            <td>${o.sold}</td>
                            <td>${o.brand}</td>
                            <td>${o.origin}</td>
                            <td>${o.sale}%</td>
                            <td>${o.description}</td>
                            <td> <c:if test="${o.onOffSale == true}">
                                    Yes
                                </c:if>
                                <c:if test="${o.onOffSale == false}">
                                    No
                                </c:if>
                            </td>
                            <td><c:if test="${o.yeuThich== true}">
                                    Yes
                                </c:if>
                                <c:if test="${o.yeuThich== false}">
                                    No
                                </c:if>
                                <c:if test="${o.id ==idProduct}">
                                    <p style="display: inline-block;
                                       color: red;
                                       margin-left: 20px;">${msg}</p>

                                </c:if>

                            </td>
                            <td>
                                <form action="updateProductAdmin" method="get">
                                    <input type="hidden" name="id" value="${o.id}">
                                    <input type="submit" value="Change" />
                                </form>
                            </td>
                            <td>
                                <form action="deleteProductAdmin" method="POST">
                                    <input type="hidden" name="id" value="${o.id}">
                                    <input type="submit" value="✖" />
                                </form>
                            </td>
                        </tr>
                    </c:forEach>

                </c:if>
            </tbody>
        </table>
        <c:set var="msg" value="${null}" scope="session"></c:set>
        <c:set var="idProduct" value="${null}" scope="session"></c:set>
    </body>
</html>
