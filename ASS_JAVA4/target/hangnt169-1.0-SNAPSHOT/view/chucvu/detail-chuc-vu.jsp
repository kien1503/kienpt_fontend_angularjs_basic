<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 3/29/2023
  Time: 5:48 PM
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
        Detail Chức Vụ
    </h1>
</header>
<section>
    ID Chức Vụ: <span>${cv.id}</span>
    <br>
    <br>
    Mã Chức Vụ: <span>${cv.ma}</span>
    <br>
    <br>
    Tên Chức Vụ: <span>${cv.ten}</span>
    <br>
    <br>
    <a href="/chuc-vu/hien-thi" class="btn btn-warning">Back To List</a>
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
