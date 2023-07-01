package com.fpt.poly.hangnt169.controller;

import com.fpt.poly.hangnt169.entity.DongSanPham;
import com.fpt.poly.hangnt169.service.DongSanPhamService;
import com.fpt.poly.hangnt169.service.impl.DongSanPhamServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "DongSPServlet", value = {
        "/dong-sp/hien-thi",
        "/dong-sp/detail",
        "/dong-sp/remove",
        "/dong-sp/seach",
        "/dong-sp/view-add",
        "/dong-sp/view-update",
        "/dong-sp/add",
        "/dong-sp/update",

})
public class DongSanPhamServlet extends HttpServlet {
    private DongSanPhamService dongSPService = new DongSanPhamServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThiDongSP(request, response);
        } else if (uri.contains("seach")) {
            this.seachDongSP(request, response);
        } else if (uri.contains("detail")) {
            this.detailDongSP(request, response);
        } else if (uri.contains("remove")) {
            this.removeDongSP(request, response);
        } else if (uri.contains("view-add")) {
            this.viewAddDongSP(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdateDongSP(request, response);
        } else {
            this.hienThiDongSP(request, response);
        }
    }

    private void viewUpdateDongSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id =request.getParameter("id");
        request.setAttribute("dsp",dongSPService.getOne(UUID.fromString(id)));
        request.getRequestDispatcher("/view/dongsp/update.jsp").forward(request,response);

    }

    private void viewAddDongSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/dongsp/add.jsp").forward(request,response);

    }

    private void removeDongSP(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        DongSanPham dsp = dongSPService.getOne(UUID.fromString(id));
        dongSPService.deleteDongSP(dsp);
        response.sendRedirect("/dong-sp/hien-thi");
    }

    private void detailDongSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        DongSanPham dsp = dongSPService.getOne(UUID.fromString(id));
        request.setAttribute("dsp",dsp);
        request.getRequestDispatcher("/view/dongsp/detail.jsp").forward(request,response);
    }

    private void seachDongSP(HttpServletRequest request, HttpServletResponse response) {
    }

    private void hienThiDongSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (dongSPService.getList().isEmpty()){
            dongSPService.getList();
        }
        request.setAttribute("dsp",dongSPService.getList());
        request.getRequestDispatcher("/view/dongsp/dongsp.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.addDongSP(request, response);
        } else if (uri.contains("update")) {
            this.updateDongSP(request, response);
        } else {
            this.hienThiDongSP(request, response);
        }
    }

    private void updateDongSP(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idStr = request.getParameter("id");
        UUID id = UUID.fromString(idStr);
        String maStr = request.getParameter("ma");
        String tenStr = request.getParameter("ten");

        DongSanPham dongSP = DongSanPham.builder()
                .id(id)
                .ma(maStr)
                .ten(tenStr)
                .build();
        dongSPService.updateDongSP(dongSP);
        response.sendRedirect("/dong-sp/hien-thi");
    }

    private void addDongSP(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String maStr = request.getParameter("ma");
        String tenStr = request.getParameter("ten");

        DongSanPham dongSP = DongSanPham.builder()
                .ma(maStr)
                .ten(tenStr)
                .build();
        dongSPService.updateDongSP(dongSP);
        response.sendRedirect("/dong-sp/hien-thi");
    }
}
