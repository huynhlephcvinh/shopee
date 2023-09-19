<%-- 
    Document   : buy
    Created on : Jul 1, 2023, 10:37:29 PM
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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <style>
            input[type=text], select {
                width: 100%;
                padding: 12px 20px;
                margin: 8px 0;
                display: inline-block;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
            }

            input[type=submit] {
                width: 100%;
                background-color: #ef5c37;
                color: white;
                padding: 14px 20px;
                margin: 8px 0;
                border: none;
                border-radius: 4px;
                cursor: pointer;
            }

            input[type=submit]:hover {
                opacity: 0.8;
            }

            div {
                border-radius: 5px;
                background-color: #f2f2f2;
                padding: 20px;
            }
        </style>
    </head>
    <body>
        <div class="app">
            <div class="app__container" >
                <div class="grid wide">
                    <div class="grid__row app__content">
                        <div class="product_container2">
                            <div class="row">

                                <div class="col-lg-12">
                                    <form action="buy" method="post">
                                        <table class="table table-light">
                                        <thead>
                                            <tr>
                                                <th scope="col">Sản phẩm</th>
                                                <th scope="col" class="text-center">Giá</th>
                                                <th scope="col" class="text-center">Số lượng</th>
                                            </tr>
                                        </thead>
                                        <tbody>

                                            <c:if test="${cart_list != null}">
                                                <c:forEach var="c" items="${cartProduct}">
                                                    <tr>
                                                        <td>${c.name}
                                                            <input type="hidden" name="nameProduct" value="${c.name}" class="form-input">
                                                        </td>
                                                        <td class="text-center">${c.priceNew}đ
                                                            <input type="hidden" name="priceProduct" value="${c.priceNew}" class="form-input">
                                                        </td>
                                                        <td class="text-center">
                                                            <input type="hidden" name="idProduct" value="${c.id}" class="form-input">
                                                            ${c.quantity}
                                                            <input type="hidden" name="quantity" class="form-control w-25"  value="${c.quantity}" readonly> 

                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </c:if>

                                        </tbody>
                                    </table>
                                        <br>
                                        <div>
                                            <h3>Tổng tiền hàng: ${total}đ</h3><br>
                                            <h3>Phí vận chuyển: ${priceShip}đ</h3><br>
                                            <h3>Tổng thanh toán: <div style="color:#ef5c37; display: inline-block;">${totalAndShip}đ</div></h3><br>
                                        </div>
                                        <br>
                                        <label for="fname">Họ và Tên</label>
                                        <input type="text" id="fname" name="fullname" placeholder="Your name..">
                                        <label for="address">Địa chỉ</label>
                                        <input type="text" id="address" name="address" placeholder="Address..">
                                        <label for="phone">Số Điện Thoại</label>
                                        <input type="text" id="phone" name="phone" placeholder="Number Phone..">
                                        <label for="payment">Phương thức thanh toán:</label>
                                        <select id="payment" name="payment">
                                            <option value="Thanh toán khi nhận hàng">Thanh toán khi nhận hàng</option>
                                            <option value="Thẻ Tín dụng">Thẻ Tín dụng/Ghi nợ</option>
                                            <option value="ShopeePay">Ví ShopeePay</option>
                                        </select>
                                        
                                        <p style="color: red">${msg}</p>
                                        
                                        <input type="submit"  class="w-25" value="Đặt Hàng"> 
                                    </form>


                                </div>

                               
                               

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>
