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
        Detail Nhân Viên
    </h1>
</header>
<section>
    ID Nhân Viên: <span>${nv.id}</span>
    <br>
    <br>
    Mã Nhân Viên: <span>${nv.ma}</span>
    <br>
    <br>
    Tên Nhân Viên: <span>${nv.ten}</span>
    <br>
    <br>
    Tên Đệm: <span>${nv.tenDem}</span>
    <br>
    <br>
    Họ: <span>${nv.ho}</span>
    <br>
    <br>
    Giới Tính: <span>${nv.gioiTinh}</span>
    <br>
    <br>
    Ngày Sinh: <span>${nv.ngaySinh}</span>
    <br>
    <br>
    Địa Chỉ: <span>${nv.diaChi}</span>
    <br>
    <br>
    SĐT: <span>${cv.sdt}</span>
    <br>
    <br>
    Mật Khẩu: <span>${nv.matKhau}</span>
    <br>
    <br>
    Trạng Thái: <span>${nv.trangThai}</span>
    <br>
    <br>
    <a href="/nhan-vien/hien-thi" class="btn btn-warning">Back To List</a>
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
