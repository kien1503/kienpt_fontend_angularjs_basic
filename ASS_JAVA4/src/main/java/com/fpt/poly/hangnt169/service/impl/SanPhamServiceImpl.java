package com.fpt.poly.hangnt169.service.impl;

import com.fpt.poly.hangnt169.entity.SanPham;
import com.fpt.poly.hangnt169.repository.SanPhamRepository;
import com.fpt.poly.hangnt169.service.SanPhamService;

import java.util.List;
import java.util.UUID;

public class SanPhamServiceImpl implements SanPhamService {
    private SanPhamRepository sanPhamRepository = new SanPhamRepository();

    @Override
    public List<SanPham> getList() {
        return sanPhamRepository.getList();
    }

    @Override
    public SanPham getOne(UUID id) {
        return sanPhamRepository.getOne(id);
    }

    @Override
    public Boolean addSP(SanPham sp) {
        return sanPhamRepository.addSP(sp);
    }

    @Override
    public Boolean updateSP(SanPham sp) {
        return sanPhamRepository.updateSP(sp);
    }

    @Override
    public Boolean deleteSP(SanPham sp) {
        return sanPhamRepository.deleteSP(sp);
    }
}
