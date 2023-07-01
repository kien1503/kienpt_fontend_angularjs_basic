package com.fpt.poly.hangnt169.service.impl;

import com.fpt.poly.hangnt169.entity.CuaHang;
import com.fpt.poly.hangnt169.repository.CuaHangRepository;
import com.fpt.poly.hangnt169.service.CuaHangService;

import java.util.List;
import java.util.UUID;

public class CuaHangServiceImpl implements CuaHangService {
    private CuaHangRepository cuaHangRepository = new CuaHangRepository();

    @Override
    public List<CuaHang> getList() {
        return cuaHangRepository.getList();
    }

    @Override
    public CuaHang getOne(UUID id) {
        return cuaHangRepository.getOne(id);
    }

    @Override
    public Boolean addCH(CuaHang ch) {
        return cuaHangRepository.addCH(ch);
    }

    @Override
    public Boolean updateCH(CuaHang ch) {
        return cuaHangRepository.updateCH(ch);
    }

    @Override
    public Boolean deleteCH(CuaHang ch) {
        return cuaHangRepository.deleteCH(ch);
    }
}
