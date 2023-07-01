package com.fpt.poly.hangnt169.service;

import com.fpt.poly.hangnt169.entity.KhachHang;

import java.util.List;
import java.util.UUID;

public interface KhachHangService {
    List<KhachHang> getList();

    KhachHang getOne(UUID id);

    Boolean addKH(KhachHang kh);

    Boolean updateKH(KhachHang kh);

    Boolean deleteKH(KhachHang kh);

    List<KhachHang> seachTen(String ten);

}
