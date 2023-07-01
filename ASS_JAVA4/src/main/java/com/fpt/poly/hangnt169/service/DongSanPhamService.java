package com.fpt.poly.hangnt169.service;

import com.fpt.poly.hangnt169.entity.DongSanPham;

import java.util.List;
import java.util.UUID;

public interface DongSanPhamService {
    List<DongSanPham> getList();

    DongSanPham getOne(UUID id);

    Boolean addDongSP(DongSanPham dongSP);

    Boolean updateDongSP(DongSanPham dongSP);

    Boolean deleteDongSP(DongSanPham dongSP);

}
