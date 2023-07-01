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
        Update Khách Hàng
    </h1>
</header>
<form action="/khach-hang/update?id=${kh.id}" method="post">
    Id Khách Hàng: <input type="text" value="${kh.id}" name="id" disabled>
    <br>
    <br>
    Mã Khách Hàng: <input type="text" value="${kh.ma}" name="ma">
    <br>
    <br>
    Tên: <input type="text" value="${kh.ten}" name="ten">
    <br>
    <br>
    Tên Đệm: <input type="text" value="${kh.tenDem}" name="tendem">
    <br>
    <br>
    Họ: <input type="text" value="${kh.ho}" name="ho">
    <br>
    <br>
    Ngày Sinh: <input type="text" value="${kh.ngaySinh}" name="ngaySinh">
    <br>
    <br>
    SĐT: <input type="text" value="${kh.sdt}" name="sdt">
    <br>
    <br>
    Địa Chỉ: <input type="text" value="${kh.diaChi}" name="diaChi">
    <br>
    <br>
    Thành Phố: <input type="text" value="${kh.thanhPho}" name="thanhPho">
    <br>
    <br>
    Quốc Gia: <select class="form-select" aria-label="Default select example" ${kh.quocGia} name="quocGia">
    <option value="VN">Việt Nam</option>
    <option value="JAPAN">Nhật Bản</option>
    <option value="USA">Mĩ</option>
    <option value="TQ">Trung Quốc</option>
    <option value="KOREA">Hàn Quốc</option>
</select>
    <br>
    <br>
    Mật Khẩu: <input type="password" value="${kh.matKhau}" name="matKhau">
    <br>
    <br>
    <button class="btn btn-success" type="submit">UPDATE</button>
    <a href="/khach-hang/hien-thi" class="btn btn-warning">Back To List</a>
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
