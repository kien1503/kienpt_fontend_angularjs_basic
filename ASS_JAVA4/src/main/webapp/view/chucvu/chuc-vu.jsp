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
        Trang Chủ Chức Vụ
    </h1>
</header>
<section>
    <form action="/chuc-vu/seach">
        Tên Chức Vụ: <input type="text" name="sTen">
        <br>
        <button class="btn btn-success" type="submit">Seach</button>
    </form>
</section>
<a href="/chuc-vu/view-add" class="btn btn-success">Add</a>
<br>
<form action="">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Mã Chức Vụ</th>
            <th scope="col">Chức Vụ</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${chucVu}" var="cv" varStatus="viTri">
            <tr>
                <td>${cv.id}</td>
                <td>${cv.ma}</td>
                <td>${cv.ten}</td>
                <td>
                    <a href="/chuc-vu/detail?id=${cv.id}" class="btn btn-success">Detail</a>
                    <a href="/chuc-vu/view-update?id=${cv.id}" class="btn btn-info">Edit</a>
                    <a href="/chuc-vu/remove?id=${cv.id}" class="btn btn-danger">Remove</a>
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
