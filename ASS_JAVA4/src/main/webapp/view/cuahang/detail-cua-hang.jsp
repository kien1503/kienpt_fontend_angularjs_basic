<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 3/29/2023
  Time: 5:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Assignment</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<header>
    <h1 style="text-align: center">
        Detail Cửa Hàng
    </h1>
</header>
<section>
    ID Của Hàng: <span>${ch.id}</span>
    <br>
    <br>
    Mã Của Hàng: <span>${ch.ma}</span>
    <br>
    <br>
    Tên Của Hàng: <span>${ch.ten}</span>
    <br>
    <br>
    Địa Chỉ Của Hàng: <span>${ch.diaChi}</span>
    <br>
    <br>
    Thành Phố Của Hàng: <span>${ch.thanhPho}</span>
    <br>
    <br>
    Quốc Gia Của Hàng: <span>${ch.quocGia}</span>
    <br>
    <br>
    <a href="/cua-hang/hien-thi" class="btn btn-warning">Back To List</a>
</section>
<footer>
    <h3 style="text-align: center">FPT Polytechnic: PTPM-Hangnt169</h3>
    <br>
    <h3 style="text-align: center">
        Kiên Chạy Be
    </h3>
</footer>
</body>
</html>
