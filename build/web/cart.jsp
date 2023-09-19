<%-- 
    Document   : cart
    Created on : Jun 22, 2023, 8:17:56 PM
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

        <style type="text/css">

            .table tbody td{
                vertical-align: middle;
            }
            .btn-incre, .btn-decre{
                box-shadow: none;
                font-size: 25px;
            }
        </style>
    </head>
    <body>
        <div class="container my-3">

            <form action="buy" method="get" class="form-inline">
                <div class="d-flex py-3"><h3>Total Price: ${(total>0)?total:0}đ</h3> </div>
                <table class="table table-light">
                    <thead>
                        <tr>
                            <th scope="col"></th>
                            <th scope="col"></th>
                            <th scope="col" ></th>
                            <th scope="col" style="text-align: center"></th>
                            <th scope="col" style="text-align: center"></th>
                            <th scope="col" style="text-align: center"></th>
                        </tr>
                    </thead>
                    <tbody>

                        <c:if test="${cart_list != null}">
                            <c:forEach var="c" items="${cartProduct}">
                                <tr>
                                    <td><img src="img/${c.img}" alt="" style="width: 60px;height: 60px;border: 1px solid #E8E8E8;"/></td>
                                    <td>${c.name}</td>
                                    <td>${c.brand}</td>
                                    <td>${c.priceNew}đ</td>
                                    <td style="text-align: center">

                                        <input type="hidden" name="id" value="${c.id}" class="form-input">
                                        <div class="form-group d-flex justify-content-between w-100">
                                            <a class="btn btn-sm btn-decre" style="color: #000"  href="quantityIncDec?action=dec&id=${c.id}"><i class="fas fa-sharp fa-regular fa-minus"></i></a>
                                            <input type="text" name="quantity" class="form-control w-50"  value="${c.quantity}" readonly> 
                                            <a class="btn bnt-sm btn-incre" style="color: #000"  href="quantityIncDec?action=inc&id=${c.id}"><i class="fas fa-sharp fa-regular fa-plus"></i></a>
                                        </div>


                                    </td>
                                    <td><a href="remove?id=${c.id}" class="btn btn-sm btn-danger">Remove</a></td>
                                </tr>
                            </c:forEach>
                        </c:if>

                    </tbody>
                </table>
                <c:if test="${cart_list.size()>0}">
                    <div style="width: 100%;text-align: center">
                        <input type="submit" class="mx-3 btn btn-primary" style="background-color: #ee4d2d; border: none;" value="Mua">
                    </div>
                </c:if>
                
                <div style="width: 100%;text-align: center; margin-top: 20px">
                    <a href="home" class="mx-3 btn btn-primary" style="background-color: #ee4d2d; border: none;" >Trở về</a>
                </div>
            </form>
        </div>
    </body>
</html>
