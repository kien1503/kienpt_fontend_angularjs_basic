package com.fpt.poly.hangnt169.controller;

import com.fpt.poly.hangnt169.entity.NhanVien;
import com.fpt.poly.hangnt169.service.NhanVienService;
import com.fpt.poly.hangnt169.service.impl.NhanVienServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@WebServlet(name = "NhanVienServlet", value = {
        "/nhan-vien/hien-thi",
        "/nhan-vien/detail",
        "/nhan-vien/remove",
        "/nhan-vien/seach",
        "/nhan-vien/view-add",
        "/nhan-vien/view-update",
        "/nhan-vien/add",
        "/nhan-vien/update",
})
public class NhanVienServlet extends HttpServlet {
    private NhanVienService nhanVienService = new NhanVienServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThiNhanVien(request, response);
        } else if (uri.contains("seach")) {
            this.seachNhanVien(request, response);
        } else if (uri.contains("detail")) {
            this.detailNhanVien(request, response);
        } else if (uri.contains("remove")) {
            this.removeNhanVien(request, response);
        } else if (uri.contains("view-add")) {
            this.viewAddNhanVien(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdateNhanVien(request, response);
        } else {
            this.hienThiNhanVien(request, response);
        }
    }

    private void viewUpdateNhanVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        request.setAttribute("nv", nhanVienService.getOne(UUID.fromString(id)));
        request.getRequestDispatcher("/view/nhanvien/update-nhan-vien.jsp").forward(request, response);

    }

    private void viewAddNhanVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/nhanvien/add-nhan-vien.jsp").forward(request, response);

    }

    private void removeNhanVien(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        NhanVien nv = nhanVienService.getOne(UUID.fromString(id));
        nhanVienService.deleteNV(nv);
        response.sendRedirect("/nhan-vien/hien-thi");

    }

    private void detailNhanVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        NhanVien nv = nhanVienService.getOne(UUID.fromString(id));
        request.setAttribute("nv", nv);
        request.getRequestDispatcher("/view/nhanvien/detail-nhan-vien.jsp").forward(request, response);
    }

    private void seachNhanVien(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String seachTen = request.getParameter("sTen");
        request.setAttribute("nv", nhanVienService.seachTen(seachTen));
        request.getRequestDispatcher("/view/nhanvien/nhan-vien.jsp").forward(request, response);
    }

    private void hienThiNhanVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (nhanVienService.getList().isEmpty()) {
            nhanVienService.getList();
        }
        request.setAttribute("nv", nhanVienService.getList());
        request.getRequestDispatcher("/view/nhanvien/nhan-vien.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.addNhanVien(request, response);
        } else if (uri.contains("update")) {
            this.updateNhanVien(request, response);
        } else {
            this.hienThiNhanVien(request, response);
        }
    }

    private void updateNhanVien(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SimpleDateFormat ngaySinh = new SimpleDateFormat();
        String idStr = request.getParameter("id");
        UUID id = UUID.fromString(idStr);
        String maStr = request.getParameter("ma");
        String tenStr = request.getParameter("ten");
        String tenDemStr = request.getParameter("tenDem");
        String hoStr = request.getParameter("ho");
        String gioiTinhStr = request.getParameter("gioiTinh");
        String ngaySinhStr = request.getParameter("ngaySinh");
        Date date = null;
        try {
            date = ngaySinh.parse(ngaySinhStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String diaChiStr = request.getParameter("diaChi");
        String sdtStr = request.getParameter("sdt");
        String matKhauStr = request.getParameter("matKhau");
        String trangThaiStr = request.getParameter("trangThai");

        NhanVien nv = NhanVien.builder()
                .id(id)
                .ma(maStr)
                .ten(tenStr)
                .tenDem(tenDemStr)
                .ho(hoStr)
                .gioiTinh(Boolean.valueOf(gioiTinhStr))
                .ngaySinh(date)
                .diaChi(diaChiStr)
                .sdt(sdtStr)
                .matKhau(matKhauStr)
                .trangThai(Integer.valueOf(trangThaiStr))
                .build();
        nhanVienService.updateNV(nv);
        response.sendRedirect("/nhan-vien/hien-thi");
    }

    private void addNhanVien(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SimpleDateFormat ngaySinh = new SimpleDateFormat("dd/MM/yyyy");
        String maStr = request.getParameter("ma");
        String tenStr = request.getParameter("ten");
        String tenDemStr = request.getParameter("tenDem");
        String hoStr = request.getParameter("ho");
        String gioiTinhStr = request.getParameter("gioiTinh");
        String ngaySinhStr = request.getParameter("ngaySinh");
        System.out.println(ngaySinhStr);
        Date date = null;
        try {
            date = ngaySinh.parse(ngaySinhStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String diaChiStr = request.getParameter("diaChi");
        String sdtStr = request.getParameter("sdt");
        String matKhauStr = request.getParameter("matKhau");
        String trangThaiStr = request.getParameter("trangThai");

        NhanVien nv = NhanVien.builder()
                .ma(maStr)
                .ten(tenStr)
                .tenDem(tenDemStr)
                .ho(hoStr)
                .gioiTinh(Boolean.valueOf(gioiTinhStr))
                .ngaySinh(date)
                .diaChi(diaChiStr)
                .sdt(sdtStr)
                .matKhau(matKhauStr)
                .trangThai(Integer.valueOf(trangThaiStr))
                .build();
        System.out.println(nv);
        nhanVienService.addNV(nv);
        response.sendRedirect("/nhan-vien/hien-thi");
    }
}
