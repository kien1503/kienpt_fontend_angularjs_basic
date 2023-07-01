package com.fpt.poly.hangnt169.controller;

import com.fpt.poly.hangnt169.entity.KhachHang;
import com.fpt.poly.hangnt169.service.KhachHangService;
import com.fpt.poly.hangnt169.service.impl.KhachHangServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@WebServlet(name = "KhachHangServlet", value = {
        "/khach-hang/hien-thi",
        "/khach-hang/detail",
        "/khach-hang/remove",
        "/khach-hang/seach",
        "/khach-hang/view-add",
        "/khach-hang/view-update",
        "/khach-hang/add",
        "/khach-hang/update",

})
public class KhachHangServlet extends HttpServlet {
    private KhachHangService khachHangService = new KhachHangServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThiKhachHang(request, response);
        } else if (uri.contains("seach")) {
            this.seachKhachHang(request, response);
        } else if (uri.contains("detail")) {
            this.detailKhachHang(request, response);
        } else if (uri.contains("remove")) {
            this.removeKhachHang(request, response);
        } else if (uri.contains("view-add")) {
            this.viewAddKhachHang(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdateKhachHang(request, response);
        } else {
            this.hienThiKhachHang(request, response);
        }
    }

    private void viewUpdateKhachHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        request.setAttribute("kh", khachHangService.getOne(UUID.fromString(id)));
        request.getRequestDispatcher("/view/khachhang/update-khach-hang.jsp").forward(request, response);

    }

    private void viewAddKhachHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/khachhang/add-khach-hang.jsp").forward(request, response);
    }

    private void removeKhachHang(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        KhachHang kh = khachHangService.getOne(UUID.fromString(id));
        khachHangService.deleteKH(kh);
        response.sendRedirect("/khach-hang/hien-thi");

    }

    private void detailKhachHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        KhachHang kh = khachHangService.getOne(UUID.fromString(id));
        request.setAttribute("kh", kh);
        request.getRequestDispatcher("/view/khachhang/detail-khach-hang.jsp").forward(request, response);

    }

    private void seachKhachHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String seachTen = request.getParameter("sTen");
        request.setAttribute("kh",khachHangService.seachTen(seachTen));
        request.getRequestDispatcher("/view/khachhang/khach-hang.jsp").forward(request,response);

    }

    private void hienThiKhachHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (khachHangService.getList().isEmpty()) {
            khachHangService.getList();
        }
        request.setAttribute("kh", khachHangService.getList());
        request.getRequestDispatcher("/view/khachhang/khach-hang.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.addKhachHang(request, response);
        } else if (uri.contains("update")) {
            this.updateKhachHang(request, response);
        } else {
            this.hienThiKhachHang(request, response);
        }
    }

    private void updateKhachHang(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SimpleDateFormat ngaySinh = new SimpleDateFormat("dd/MM/yyyy");

        String idStr = request.getParameter("id");
        UUID id = UUID.fromString(idStr);
        String maStr = request.getParameter("ma");
        String tenStr = request.getParameter("ten");
        String tenDemStr = request.getParameter("tendem");
        String hoStr = request.getParameter("ho");
        String ngaySinhStr = request.getParameter("ngaySinh");
        Date date = null;
        try {
            date = ngaySinh.parse(ngaySinhStr);
        }catch (Exception e){
            e.printStackTrace();
        }
        String sdtStr = request.getParameter("sdt");
        String diaChiStr = request.getParameter("diaChi");
        String thanhPhoStr = request.getParameter("thanhPho");
        String quocGiaStr = request.getParameter("quocGia");
        String matKhauStr = request.getParameter("matKhau");

        KhachHang khachHang = KhachHang.builder()
                .id(id)
                .ma(maStr)
                .ten(tenStr)
                .tenDem(tenDemStr)
                .ho(hoStr)
                .ngaySinh(date)
                .sdt(sdtStr)
                .diaChi(diaChiStr)
                .thanhPho(thanhPhoStr)
                .quocGia(quocGiaStr)
                .matKhau(matKhauStr)
                .build();
        khachHangService.updateKH(khachHang);
        response.sendRedirect("/khach-hang/hien-thi");
    }

    private void addKhachHang(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SimpleDateFormat ngaySinh = new SimpleDateFormat("dd/MM/yyyy");

        String maStr = request.getParameter("ma");
        String tenStr = request.getParameter("ten");
        String tenDemStr = request.getParameter("tendem");
        String hoStr = request.getParameter("ho");
        String ngaySinhStr = request.getParameter("ngaySinh");
        Date date = null;
        try {
           date = ngaySinh.parse(ngaySinhStr);
        }catch (Exception e){
            e.printStackTrace();
        }
        String sdtStr = request.getParameter("sdt");
        String diaChiStr = request.getParameter("diaChi");
        String thanhPhoStr = request.getParameter("thanhPho");
        String quocGiaStr = request.getParameter("quocGia");
        String matKhauStr = request.getParameter("matKhau");

        KhachHang khachHang = KhachHang.builder()
                .ma(maStr)
                .ten(tenStr)
                .tenDem(tenDemStr)
                .ho(hoStr)
                .ngaySinh(date)
                .sdt(sdtStr)
                .diaChi(diaChiStr)
                .thanhPho(thanhPhoStr)
                .quocGia(quocGiaStr)
                .matKhau(matKhauStr)
                .build();
        khachHangService.addKH(khachHang);
        response.sendRedirect("/khach-hang/hien-thi");
    }
}
