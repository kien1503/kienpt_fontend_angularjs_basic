<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 3/29/2023
  Time: 5:47 PM
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
        Trang Chủ Cửa Hàng
    </h1>
</header>
<section>
    <form action="/cua-hang/seach">
        Tên Cửa Hàng: <input type="text" name="sTen">
        <br>
        <button class="btn btn-success" type="submit">Seach</button>
    </form>
</section>
<a href="/cua-hang/view-add" class="btn btn-success">Add</a>
<br>
<form action="">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Mã Cửa Hàng</th>
            <th scope="col">Tên Của Hàng</th>
            <th scope="col">Địa Chỉ Của Hàng</th>
            <th scope="col">Thành Phố Của Hàng</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${ch}" var="ch">
            <tr>
                <td>${ch.id}</td>
                <td>${ch.ma}</td>
                <td>${ch.ten}</td>
                <td>${ch.diaChi}</td>
                <td>${ch.thanhPho}</td>
                <td>${ch.quocGia}</td>
                <td>
                    <a href="/cua-hang/detail?id=${ch.id}" class="btn btn-success">Detail</a>
                    <a href="/cua-hang/view-update?id=${ch.id}" class="btn btn-info">Edit</a>
                    <a href="/cua-hang/remove?id=${ch.id}" class="btn btn-danger">Remove</a>
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
