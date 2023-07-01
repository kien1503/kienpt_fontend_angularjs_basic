package com.fpt.poly.hangnt169.service;

import com.fpt.poly.hangnt169.entity.SanPham;

import java.util.List;
import java.util.UUID;

public interface SanPhamService {

    List<SanPham> getList();

    SanPham getOne(UUID id);

    Boolean addSP(SanPham sp);

    Boolean updateSP(SanPham sp);

    Boolean deleteSP(SanPham sp);
}
