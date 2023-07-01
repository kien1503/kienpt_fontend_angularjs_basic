package com.fpt.poly.hangnt169.controller;

import com.fpt.poly.hangnt169.service.ChiTietSanPhamService;
import com.fpt.poly.hangnt169.service.impl.ChiTietSanPhamServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ChiTietSPServlet", value = {
        "/chi-tiet-sp/hien-thi",
        "/chi-tiet-sp/seach",
        "/chi-tiet-sp/remove",
        "/chi-tiet-sp/detail",
        "/chi-tiet-sp/view-update",
        "/chi-tiet-sp/view-add",
        "/chi-tiet-sp/update",
        "/chi-tiet-sp/add",
})
public class ChiTietSanPhamServlet extends HttpServlet {
    private ChiTietSanPhamService chiTietSPService = new ChiTietSanPhamServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThiDSChiTietSanPham(request, response);
        } else if (uri.contains("seach")) {
            this.seachChiTietSanPham(request, response);
        } else if (uri.contains("remove")) {
            this.removeChiTietSanPham(request, response);
        } else if (uri.contains("detail")) {
            this.detailChiTietSanPham(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdateChiTietSanPham(request, response);
        } else if (uri.contains("view-add")) {
            this.viewAddChiTietSanPham(request, response);
        } else {
            this.hienThiDSChiTietSanPham(request,response);
        }

    }

    private void viewAddChiTietSanPham(HttpServletRequest request, HttpServletResponse response) {
    }

    private void viewUpdateChiTietSanPham(HttpServletRequest request, HttpServletResponse response) {
    }

    private void detailChiTietSanPham(HttpServletRequest request, HttpServletResponse response) {
    }

    private void removeChiTietSanPham(HttpServletRequest request, HttpServletResponse response) {
    }

    private void seachChiTietSanPham(HttpServletRequest request, HttpServletResponse response) {
    }

    private void hienThiDSChiTietSanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if (chiTietSPService.getAll().isEmpty()){
        chiTietSPService.getAll();
    }
    request.setAttribute("ctsp",chiTietSPService.getAll());
    request.getRequestDispatcher("/view/ctsp/CTSP.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
