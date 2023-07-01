<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 3/29/2023
  Time: 5:49 PM
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
        Add Chức Vụ
    </h1>
</header>
<form action="/chuc-vu/add" method="post">
    Id Chức Vụ: <input type="text" value="${cv.id}" name="id" disabled>
    <br>
    <br>
    Mã Chức Vụ: <input type="text" value="${cv.ma}" name="ma">
    <br>
    <br>
    Tên Chức Vụ: <input type="text" value="${cv.ten}" name="ten">
    <br>
    <br>
    <button class="btn btn-success" type="submit">ADD</button>
    <a href="/chuc-vu/hien-thi" class="btn btn-warning">Back To List</a>
</form>
<footer>
    <h3 style="text-align: center">FPT Polytechnic: PTPM-Hangnt169</h3>
    <br>
    <h3 style="text-align: center">
        Kiên Chạy Be
    </h3>
</footer>
</body>
</html>
