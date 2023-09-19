<%-- 
    Document   : updateProductAdmin
    Created on : Jul 13, 2023, 10:42:49 PM
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
                    <li class="nav-item">
                        <a class="nav-link " href="addProductAdmin">Add Product</a>
                    </li>
                    <li class="nav-item active">
                        <div class="nav-link " style="color: #ef5c37" >Update Product</div>
                    </li>
                </ul>

            </div>
        </nav>
        
        <form class="text-center" action="updateProductAdmin" method="post" enctype="multipart/form-data">
            <input type="hidden" name="id" value="${product.id}">
            <img src="img/${product.img}" alt="" style="width: 100px;height: 100px;border: 1px solid #E8E8E8;"/>
            Change Image ->: <input type="file" name="photo"><br>
            Name: <input type="text" name="name" value="${product.name}" /><br>
            Price Old: <input type="number" name="priceOld" value="${product.priceOld}" /><br>
            Price New: <input type="number" name="priceNew" value="${product.priceNew}" /><br>
            Brand: <input type="text" name="brand" value="${product.brand}" /><br>
            Origin: <input type="text" name="origin" value="${product.origin}" /><br>
            Sale(%): <input type="number" name="sale" value="${product.sale}" /><br>
            Description:<br> <textarea name="description" rows="4" cols="30" >${product.description}</textarea><br>
            You want sale product?<br>
            <select name="onOffSale">
                <option value="true" ${product.onOffSale == true? "selected" : ""}>Yes</option>
                <option value="false" ${product.onOffSale == false? "selected" : ""}>No</option>
            </select><br>
            <input type="submit" value="Update" />
            <p style="color: red">${msg}</p>
        </form>
        
        
    </body>
</html>
