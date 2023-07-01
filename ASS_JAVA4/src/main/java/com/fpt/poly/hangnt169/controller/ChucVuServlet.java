package com.fpt.poly.hangnt169.controller;

import com.fpt.poly.hangnt169.entity.ChucVu;
import com.fpt.poly.hangnt169.service.ChucVuService;
import com.fpt.poly.hangnt169.service.impl.ChucVuServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "ChucVuServlet", value = {
        "/chuc-vu/hien-thi",
        "/chuc-vu/seach",
        "/chuc-vu/remove",
        "/chuc-vu/detail",
        "/chuc-vu/view-update",
        "/chuc-vu/view-add",
        "/chuc-vu/update",
        "/chuc-vu/add",

})
public class ChucVuServlet extends HttpServlet {
    private ChucVuService chucVuService = new ChucVuServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThiDSChucVu(request, response);
        } else if (uri.contains("seach")) {
            this.seachChucVu(request, response);
        } else if (uri.contains("remove")) {
            this.removeChucVu(request, response);
        } else if (uri.contains("detail")) {
            this.detailChucVu(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdateChucVu(request, response);
        } else if (uri.contains("view-add")) {
            this.viewAddChucVu(request, response);
        } else {
            this.hienThiDSChucVu(request, response);
        }

    }

    private void viewAddChucVu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/chucvu/add-chuc-vu.jsp").forward(request,response);
    }

    private void viewUpdateChucVu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id =request.getParameter("id");
        request.setAttribute("cv",chucVuService.getOne(UUID.fromString(id)));
        request.getRequestDispatcher("/view/chucvu/update-chuc-vu.jsp").forward(request,response);
    }

    private void detailChucVu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ChucVu cv = chucVuService.getOne(UUID.fromString(id));
        request.setAttribute("cv",cv);
        request.getRequestDispatcher("/view/chucvu/detail-chuc-vu.jsp").forward(request,response);
    }

    private void removeChucVu(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        ChucVu cv = chucVuService.getOne(UUID.fromString(id));
        chucVuService.deleteSP(cv);
        response.sendRedirect("/chuc-vu/hien-thi");
    }

    private void seachChucVu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String seachTen = request.getParameter("sTen");
        request.setAttribute("cv",chucVuService.seachTen(seachTen));
        request.getRequestDispatcher("/view/chucvu/chuc-vu.jsp").forward(request,response);

    }

    private void hienThiDSChucVu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (chucVuService.getList().isEmpty()){
            chucVuService.getList();
        }
        request.setAttribute("chucVu",chucVuService.getList());
        request.getRequestDispatcher("/view/chucvu/chuc-vu.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uri = request.getRequestURI();
        if (uri.contains("update")){
            this.updateChucVu(request,response);
        }else  if (uri.contains("add")){
            this.addChucVu(request,response);
        }else {
            this.hienThiDSChucVu(request,response);
        }
    }

    private void addChucVu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maStr = request.getParameter("ma");
        String tenStr = request.getParameter("ten");

        ChucVu chucVu = ChucVu .builder()
                .ma(maStr)
                .ten(tenStr)
                .build();
        chucVuService.addSP(chucVu);
        response.sendRedirect("/chuc-vu/hien-thi");
    }

    private void updateChucVu(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String idStr = request.getParameter("id");
        UUID id = UUID.fromString(idStr);
        String maStr = request.getParameter("ma");
        String tenStr = request.getParameter("ten");

        ChucVu chucVu = ChucVu .builder()
                .id(id)
                .ma(maStr)
                .ten(tenStr)
                .build();
        chucVuService.updateSP(chucVu);
        response.sendRedirect("/chuc-vu/hien-thi");
    }
}
