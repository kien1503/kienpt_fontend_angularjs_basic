package com.fpt.poly.hangnt169.service.impl;

import com.fpt.poly.hangnt169.entity.ChiTietSanPham;
import com.fpt.poly.hangnt169.repository.ChiTietSPRepository;
import com.fpt.poly.hangnt169.service.ChiTietSanPhamService;

import java.util.List;
import java.util.UUID;

public class ChiTietSanPhamServiceImpl implements ChiTietSanPhamService {
    private ChiTietSPRepository chiTietSPRepository = new ChiTietSPRepository();

    @Override
    public List<ChiTietSanPham> getAll() {
        return chiTietSPRepository.getList();
    }

    @Override
    public ChiTietSanPham getOne(UUID id) {
        return chiTietSPRepository.getOne(id);
    }

    @Override
    public Boolean addCTSP(ChiTietSanPham ctsp) {
        return chiTietSPRepository.addCTSP(ctsp);
    }

    @Override
    public Boolean updateCTSP(ChiTietSanPham ctsp) {
        return chiTietSPRepository.updateCTSP(ctsp);
    }

    @Override
    public Boolean deleteCTSP(ChiTietSanPham ctsp) {
        return chiTietSPRepository.deleteCTSP(ctsp);
    }
}
