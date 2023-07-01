package com.fpt.poly.hangnt169.controller;

import com.fpt.poly.hangnt169.entity.SanPham;
import com.fpt.poly.hangnt169.service.SanPhamService;
import com.fpt.poly.hangnt169.service.impl.SanPhamServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "SanPhamServlet", value = {
        "/san-pham/hien-thi",
        "/san-pham/detail",
        "/san-pham/remove",
        "/san-pham/seach",
        "/san-pham/view-add",
        "/san-pham/view-update",
        "/san-pham/add",
        "/san-pham/update",
})
public class SanPhamServlet extends HttpServlet {
    private SanPhamService sanPhamService = new SanPhamServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThiSP(request, response);
        } else if (uri.contains("seach")) {
            this.seachSP(request, response);
        } else if (uri.contains("detail")) {
            this.detailSP(request, response);
        } else if (uri.contains("remove")) {
            this.removeSP(request, response);
        } else if (uri.contains("view-add")) {
            this.viewAddSP(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdateSP(request, response);
        } else {
            this.hienThiSP(request, response);
        }
    }

    private void viewUpdateSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        request.setAttribute("sp", sanPhamService.getOne(UUID.fromString(id)));
        request.getRequestDispatcher("/view/sanpham/update-san-pham.jsp").forward(request, response);

    }

    private void viewAddSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/sanpham/add-san-pham.jsp").forward(request, response);
    }

    private void removeSP(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        SanPham sp = sanPhamService.getOne(UUID.fromString(id));
        sanPhamService.deleteSP(sp);
        response.sendRedirect("/san-pham/hien-thi");

    }

    private void detailSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        SanPham sp = sanPhamService.getOne(UUID.fromString(id));
        request.setAttribute("sp", sp);
        request.getRequestDispatcher("/view/sanpham/detail-san-pham.jsp").forward(request, response);

    }

    private void seachSP(HttpServletRequest request, HttpServletResponse response) {
    }

    private void hienThiSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (sanPhamService.getList().isEmpty()) {
            sanPhamService.getList();
        }
        request.setAttribute("sp", sanPhamService.getList());
        request.getRequestDispatcher("/view/sanpham/san-pham.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.addSP(request, response);
        } else if (uri.contains("update")) {
            this.updateSP(request, response);
        } else {
            this.hienThiSP(request, response);
        }
    }

    private void updateSP(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idStr = request.getParameter("id");
        UUID id = UUID.fromString(idStr);
        String maStr = request.getParameter("ma");
        String tenStr = request.getParameter("ten");

        SanPham sp = SanPham.builder()
                .id(id)
                .ma(maStr)
                .ten(tenStr)
                .build();
        sanPhamService.updateSP(sp);
        response.sendRedirect("/san-pham/hien-thi");
    }

    private void addSP(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String maStr = request.getParameter("ma");
        String tenStr = request.getParameter("ten");

        SanPham sp = SanPham.builder()
                .ma(maStr)
                .ten(tenStr)
                .build();
        sanPhamService.addSP(sp);
        response.sendRedirect("/san-pham/hien-thi");
    }
}
