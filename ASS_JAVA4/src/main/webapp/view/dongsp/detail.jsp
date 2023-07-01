<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 4/3/2023
  Time: 4:18 PM
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
        Detail Dòng Sản Phẩm
    </h1>
</header>
<section>
    ID Dòng Sản Phẩm: <span>${dsp.id}</span>
    <br>
    <br>
    Mã Dòng Sản Phẩm: <span>${dsp.ma}</span>
    <br>
    <br>
    Tên Dòng Sản Phẩm: <span>${dsp.ten}</span>
    <br>
    <br>
    <a href="/dong-sp/hien-thi" class="btn btn-warning">Back To List</a>
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
