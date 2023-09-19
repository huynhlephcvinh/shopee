<%-- 
    Document   : addProductAdmin
    Created on : Jul 12, 2023, 4:05:26 PM
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
                    <li class="nav-item ">
                        <a class="nav-link "  href="productAdmin">Product</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link " style="color: #ef5c37" href="addProductAdmin">Add Product</a>
                    </li>
                </ul>

            </div>
        </nav>
        <form class="text-center" action="addProductAdmin" method="post" enctype="multipart/form-data">

            Image: <input type="file" name="photo"><br>
            Name: <input type="text" name="name" /><br>
            Price Old: <input type="number" name="priceOld" /><br>
            Price (Sale or Current) : <input type="number" name="priceNew" /><br>
            Brand: <input type="text" name="brand" /><br>
            Origin: <input type="text" name="origin" /><br>
            Sale(%): <input type="number" name="sale" /><br>
            Description:<br> <textarea name="description" rows="4" cols="30"></textarea><br>
            Category:<br>
            <select name="category">
                <c:forEach var="c" items="${listCategory}">
                <option value="${c.id}">${c.name}</option>
                </c:forEach>
            </select><br>
            You want sale product?(Yes: price old and price 'sale or current' will display | No: only price 'sale or current' will display)<br>
            <select name="onOffSale">
                <option value="true" selected>Yes</option>
                <option value="false">No</option>
            </select><br>
            <br>
            <input type="submit" value="Add" />
            <p style="color: red">${msg1}</p>
        </form>
       
    </body>
</html>
