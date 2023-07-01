package com.fpt.poly.hangnt169.service;

import com.fpt.poly.hangnt169.entity.ChiTietSanPham;

import java.util.List;
import java.util.UUID;

public interface ChiTietSanPhamService {
    List<ChiTietSanPham> getAll();

    ChiTietSanPham getOne(UUID id);

    Boolean addCTSP(ChiTietSanPham ctsp);

    Boolean updateCTSP(ChiTietSanPham ctsp);

    Boolean deleteCTSP(ChiTietSanPham ctsp);

}
