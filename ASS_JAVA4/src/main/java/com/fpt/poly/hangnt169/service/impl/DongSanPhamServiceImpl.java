package com.fpt.poly.hangnt169.service.impl;

import com.fpt.poly.hangnt169.entity.DongSanPham;
import com.fpt.poly.hangnt169.repository.DongSPRepository;
import com.fpt.poly.hangnt169.service.DongSanPhamService;

import java.util.List;
import java.util.UUID;

public class DongSanPhamServiceImpl implements DongSanPhamService {
    private DongSPRepository dongSPRepository = new DongSPRepository();

    @Override
    public List<DongSanPham> getList() {
        return dongSPRepository.getList();
    }

    @Override
    public DongSanPham getOne(UUID id) {
        return dongSPRepository.getOne(id);
    }

    @Override
    public Boolean addDongSP(DongSanPham dongSP) {
        return dongSPRepository.addSP(dongSP);
    }

    @Override
    public Boolean updateDongSP(DongSanPham dongSP) {
        return dongSPRepository.updateSP(dongSP);
    }

    @Override
    public Boolean deleteDongSP(DongSanPham dongSP) {
        return dongSPRepository.deleteSP(dongSP);
    }

}
