<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Assignment</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<header>
    <h1 style="text-align: center">
        Trang Chủ Dòng Sản Phẩm
    </h1>
</header>
<section>
    <form action="/dong-sp/seach">
        Tên Chức Vụ: <input type="text" name="sTen">
        <br>
        <button class="btn btn-success" type="submit">Seach</button>
    </form>
</section>
<a href="/dong-sp/view-add" class="btn btn-success">Add</a>
<br>
<form action="">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Mã Dòng Sản Phẩm</th>
            <th scope="col">Dòng Sản Phẩm</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${dsp}" var="dsp">
            <tr>
                <td>${dsp.id}</td>
                <td>${dsp.ma}</td>
                <td>${dsp.ten}</td>
                <td>
                    <a href="/dong-sp/detail?id=${dsp.id}" class="btn btn-success">Detail</a>
                    <a href="/dong-sp/view-update?id=${dsp.id}" class="btn btn-info">Edit</a>
                    <a href="/dong-sp/remove?id=${dsp.id}" class="btn btn-danger">Remove</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
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
