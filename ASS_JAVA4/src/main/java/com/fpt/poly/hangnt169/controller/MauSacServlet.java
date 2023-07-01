package com.fpt.poly.hangnt169.controller;

import com.fpt.poly.hangnt169.entity.MauSac;
import com.fpt.poly.hangnt169.service.MauSacService;
import com.fpt.poly.hangnt169.service.impl.MauSacServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "MauSacServlet", value = {
        "/mau-sac/hien-thi",
        "/mau-sac/detail",
        "/mau-sac/remove",
        "/mau-sac/seach",
        "/mau-sac/view-add",
        "/mau-sac/view-update",
        "/mau-sac/add",
        "/mau-sac/update",

})
public class MauSacServlet extends HttpServlet {
    private MauSacService mauSacService = new MauSacServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThiMauSac(request, response);
        } else if (uri.contains("seach")) {
            this.seachMauSac(request, response);
        } else if (uri.contains("detail")) {
            this.detailMauSac(request, response);
        } else if (uri.contains("remove")) {
            this.removeMauSac(request, response);
        } else if (uri.contains("view-add")) {
            this.viewAddMauSac(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdateMauSac(request, response);
        } else {
            this.hienThiMauSac(request, response);
        }
    }

    private void viewUpdateMauSac(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id =request.getParameter("id");
        request.setAttribute("dsp",mauSacService.getOne(UUID.fromString(id)));
        request.getRequestDispatcher("view/mausac/update-mau-sac.jsp").forward(request,response);

    }

    private void viewAddMauSac(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/mausac/add-mau-sac.jsp").forward(request,response);
    }

    private void removeMauSac(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        MauSac ms = mauSacService.getOne(UUID.fromString(id));
        mauSacService.deleteMS(ms);
        response.sendRedirect("/mau-sac/hien-thi");

    }

    private void detailMauSac(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        MauSac ms = mauSacService.getOne(UUID.fromString(id));
        request.setAttribute("ms",ms);
        request.getRequestDispatcher("/view/mausac/detail-mau-sac.jsp").forward(request,response);

    }

    private void seachMauSac(HttpServletRequest request, HttpServletResponse response) {
    }

    private void hienThiMauSac(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (mauSacService.getList().isEmpty()){
            mauSacService.getList();
        }
        request.setAttribute("ms",mauSacService.getList());
        request.getRequestDispatcher("/view/mausac/mau-sac.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.addMauSac(request, response);
        } else if (uri.contains("update")) {
            this.updateMauSac(request, response);
        } else {
            this.hienThiMauSac(request, response);
        }
    }

    private void updateMauSac(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idStr = request.getParameter("id");
        UUID id = UUID.fromString(idStr);
        String maStr = request.getParameter("ma");
        String tenStr = request.getParameter("ten");

        MauSac ms = MauSac .builder()
                .id(id)
                .ma(maStr)
                .ten(tenStr)
                .build();
        mauSacService.updateMS(ms);
        response.sendRedirect("/mau-sac/hien-thi");
    }

    private void addMauSac(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String maStr = request.getParameter("ma");
        String tenStr = request.getParameter("ten");

        MauSac ms = MauSac .builder()
                .ma(maStr)
                .ten(tenStr)
                .build();
        mauSacService.addMS(ms);
        response.sendRedirect("/mau-sac/hien-thi");
    }
}
