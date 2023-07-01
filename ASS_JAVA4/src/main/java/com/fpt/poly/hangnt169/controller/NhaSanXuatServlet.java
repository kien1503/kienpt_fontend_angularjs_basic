package com.fpt.poly.hangnt169.controller;

import com.fpt.poly.hangnt169.entity.NhaSanXuat;
import com.fpt.poly.hangnt169.service.NhaSanXuatService;
import com.fpt.poly.hangnt169.service.impl.NhaSanXuatServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "NSXServlet", value = {
        "/nsx/hien-thi",
        "/nsx/detail",
        "/nsx/remove",
        "/nsx/seach",
        "/nsx/view-add",
        "/nsx/view-update",
        "/nsx/add",
        "/nsx/update",
})
public class NhaSanXuatServlet extends HttpServlet {
    private NhaSanXuatService nsxService = new NhaSanXuatServiceImpl();

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
        request.setAttribute("nsx   ",nsxService.getOne(UUID.fromString(id)));
        request.getRequestDispatcher("/view/nsx/update-nsx.jsp").forward(request,response);

    }

    private void viewAddMauSac(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/nsx/add-nsx.jsp").forward(request,response);

    }

    private void seachMauSac(HttpServletRequest request, HttpServletResponse response) {
    }

    private void detailMauSac(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        NhaSanXuat nsx = nsxService.getOne(UUID.fromString(id));
        request.setAttribute("nsx", nsx);
        request.getRequestDispatcher("/view/nsx/detail-nsx.jsp").forward(request, response);

    }

    private void removeMauSac(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        NhaSanXuat nsx = nsxService.getOne(UUID.fromString(id));
        nsxService.deleteNSX(nsx);
        response.sendRedirect("/nsx/hien-thi");
    }

    private void hienThiMauSac(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (nsxService.getList().isEmpty()) {
            nsxService.getList();
        }
        request.setAttribute("nsx", nsxService.getList());
        request.getRequestDispatcher("/view/nsx/nsx.jsp").forward(request, response);

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

        NhaSanXuat nsx = NhaSanXuat.builder()
                .id(id)
                .ma(maStr)
                .ten(tenStr)
                .build();
        nsxService.updateNSX(nsx);
        response.sendRedirect("/nsx/hien-thi");
    }

    private void addMauSac(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String maStr = request.getParameter("ma");
        String tenStr = request.getParameter("ten");

        NhaSanXuat nsx = NhaSanXuat.builder()
                .ma(maStr)
                .ten(tenStr)
                .build();
        nsxService.addNSX(nsx);
        response.sendRedirect("/nsx/hien-thi");

    }
}
