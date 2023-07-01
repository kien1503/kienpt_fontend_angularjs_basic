package com.fpt.poly.hangnt169.controller;

import com.fpt.poly.hangnt169.entity.CuaHang;
import com.fpt.poly.hangnt169.service.CuaHangService;
import com.fpt.poly.hangnt169.service.impl.CuaHangServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "CuaHangServlet", value = {
        "/cua-hang/hien-thi",
        "/cua-hang/seach",
        "/cua-hang/detail",
        "/cua-hang/remove",
        "/cua-hang/view-add",
        "/cua-hang/view-update",
        "/cua-hang/add",
        "/cua-hang/update",

})
public class CuaHangServlet extends HttpServlet {
    private CuaHangService cuaHangService = new CuaHangServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThiCH(request, response);
        } else if (uri.contains("seach")) {
            this.seachCh(request, response);
        } else if (uri.contains("detail")) {
            this.detailCH(request, response);
        } else if (uri.contains("remove")) {
            this.removeCH(request, response);
        } else if (uri.contains("view-add")) {
            this.viewAddCH(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdateCH(request, response);
        } else {
            this.hienThiCH(request, response);
        }
    }

    private void viewUpdateCH(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        request.setAttribute("ch", cuaHangService.getOne(UUID.fromString(id)));
        request.getRequestDispatcher("/view/cuahang/update-cua-hang.jsp").forward(request, response);
    }

    private void viewAddCH(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/cuahang/add-cua-hang.jsp").forward(request, response);
    }

    private void removeCH(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        CuaHang chiTietSP = cuaHangService.getOne(UUID.fromString(id));
        cuaHangService.deleteCH(chiTietSP);
        response.sendRedirect("/cua-hang/hien-thi");
    }

    private void detailCH(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        CuaHang ch = cuaHangService.getOne(UUID.fromString(id));
        request.setAttribute("ch", ch);
        request.getRequestDispatcher("/view/cuahang/detail-cua-hang.jsp").forward(request, response);
    }

    private void seachCh(HttpServletRequest request, HttpServletResponse response) {
    }

    private void hienThiCH(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (cuaHangService.getList().isEmpty()) {
            cuaHangService.getList();
        }
        request.setAttribute("ch", cuaHangService.getList());
        request.getRequestDispatcher("/view/cuahang/cua-hang.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.addCH(request, response);
        } else if (uri.contains("update")) {
            this.updateCh(request, response);
        } else {
            this.hienThiCH(request, response);
        }
    }

    private void addCH(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String maStr = request.getParameter("ma");
        String tenStr = request.getParameter("ten");
        String diaChiStr = request.getParameter("diaChi");
        String thanhPhoStr = request.getParameter("thanhPho");
        String quocGiaStr = request.getParameter("quocGia");

        CuaHang ch = CuaHang.builder()
                .ma(maStr)
                .ten(tenStr)
                .diaChi(diaChiStr)
                .thanhPho(thanhPhoStr)
                .quocGia(quocGiaStr)
                .build();
        cuaHangService.addCH(ch);
        response.sendRedirect("/cua-hang/hien-thi");
    }

    private void updateCh(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idStr = request.getParameter("id");
        UUID id = UUID.fromString(idStr);
        String maStr = request.getParameter("ma");
        String tenStr = request.getParameter("ten");
        String diaChiStr = request.getParameter("diaChi");
        String thanhPhoStr = request.getParameter("thanhPho");
        String quocGiaStr = request.getParameter("quocGia");

        CuaHang ch = CuaHang.builder()
                .id(id)
                .ma(maStr)
                .ten(tenStr)
                .diaChi(diaChiStr)
                .thanhPho(thanhPhoStr)
                .quocGia(quocGiaStr)
                .build();
        cuaHangService.updateCH(ch);
        response.sendRedirect("/cua-hang/hien-thi");
    }
}
