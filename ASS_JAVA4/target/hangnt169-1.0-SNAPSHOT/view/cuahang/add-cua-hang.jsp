<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 3/29/2023
  Time: 5:51 PM
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
        Add Cửa Hàng
    </h1>
</header>
<form action="/cua-hang/add" method="post">
    Id Cửa Hàng: <input type="text" name="id" disabled>
    <br>
    <br>
    Mã Cửa Hàng: <input type="text" name="ma">
    <br>
    <br>
    Tên Cửa Hàng: <input type="text" name="ten">
    <br>
    <br>
    Địa Chỉ Cửa Hàng: <input type="text" name="diaChi">
    <br>
    <br>
    Thành Phố Cửa Hàng: <input type="text" name="thanhPho">
    <br>
    <br>
    Quốc Gia Cửa Hàng: <select class="form-select" aria-label="Default select example"  name="quocGia">
    <option value="VN">Việt Nam</option>
    <option value="JAPAN">Nhật Bản</option>
    <option value="USA">Mĩ</option>
    <option value="TQ">Trung Quốc</option>
    <option value="KOREA">Hàn Quốc</option>
</select>
    <br>
    <br>
    <button class="btn btn-success" type="submit">ADD</button>
    <a href="/cua-hang/hien-thi" class="btn btn-warning">Back To List</a>
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
