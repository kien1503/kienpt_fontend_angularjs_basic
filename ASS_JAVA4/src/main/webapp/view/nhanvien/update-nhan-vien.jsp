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
        Add Nhân Viên
    </h1>
</header>
<form action="/nhan-vien/update?id=${nv.id}" method="post">
    Id Nhân Viên: <input type="text" value="${nv.id}" name="id" disabled>
    <br>
    <br>
    Mã Nhân Viên: <input type="text" value="${nv.ma}" name="ma">
    <br>
    <br>
    Tên: <input type="text" value="${nv.ten}" name="ten">
    <br>
    <br>
    Tên Đệm: <input type="text" value="${nv.tenDem}" name="tenDem">
    <br>
    <br>
    Họ: <input type="text" value="${nv.ho}" name="ho">
    <br>
    <br>
    Giới Tính: <input type="radio" value="true" ${nv.gioiTinh == true ? "checked" : ""} name="gioiTinh">Nam
    <input type="radio" value="false" ${nv.gioiTinh == false ? "checked" : ""} name="gioiTinh">Nữ
    <br>
    <br>
    Ngày Sinh: <input type="text" value="${nv.ngaySinh}" name="ngaySinh">
    <br>
    <br>
    Địa Chỉ: <input type="text" value="${nv.diaChi}" name="diaChi">
    <br>
    <br>
    SĐT: <input type="text" value="${nv.sdt}" name="sdt">
    <br>
    <br>
    Mật Khẩu: <input type="password" value="${nv.matKhau}" name="matKhau">
    <br>
    <br>
    Trạng Thái: <input type="number" value="${nv.trangThai}" name="trangThai">
    <br>
    <br>
    <button class="btn btn-success" type="submit">UPDATE</button>
    <a href="/nhan-vien/hien-thi" class="btn btn-warning">Back To List</a>
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
