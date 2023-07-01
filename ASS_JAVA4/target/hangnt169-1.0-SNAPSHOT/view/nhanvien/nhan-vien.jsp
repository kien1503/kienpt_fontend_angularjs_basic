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
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Assignment</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<header>
    <h1 style="text-align: center">
        Trang Chủ Khách Hàng
    </h1>
</header>
<section>
    <form action="/nhan-vien/seach">
        Tên Nhân Viên: <input type="text" name="sTen">
        <br>
        <button class="btn btn-success" type="submit">Seach</button>
    </form>
</section>
<a href="/nhan-vien/view-add" class="btn btn-success">Add</a>
<br>
<form action="">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Mã Nhân Viên</th>
            <th scope="col">Tên Nhân Viên</th>
            <th scope="col">Tên Đệm</th>
            <th scope="col">Họ</th>
            <th scope="col">Giới Tính</th>
            <th scope="col">Ngày Sinh</th>
            <th scope="col">Địa Chỉ</th>
            <th scope="col">SĐT</th>
            <th scope="col">Mật Khẩu</th>
            <th scope="col">Trạng Thái</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${nv}" var="nv">
            <tr>
                <td>${nv.id}</td>
                <td>${nv.ma}</td>
                <td>${nv.ten}</td>
                <td>${nv.tenDem}</td>
                <td>${nv.ho}</td>
                <td>${nv.gioiTinh}</td>
                <td>${nv.ngaySinh}</td>
                <td>${nv.diaChi}</td>
                <td>${nv.sdt}</td>
                <td>${nv.matKhau}</td>
                <td>${nv.trangThai}</td>
                <td>
                    <a href="/nhan-vien/detail?id=${nv.id}" class="btn btn-success">Detail</a>
                    <a href="/nhan-vien/view-update?id=${nv.id}" class="btn btn-info">Edit</a>
                    <a href="/nhan-vien/remove?id=${nv.id}" class="btn btn-danger">Remove</a>
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
