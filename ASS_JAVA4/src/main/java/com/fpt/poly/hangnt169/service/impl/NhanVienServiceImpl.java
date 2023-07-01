package com.fpt.poly.hangnt169.service.impl;

import com.fpt.poly.hangnt169.entity.NhanVien;
import com.fpt.poly.hangnt169.repository.NhanVienRepository;
import com.fpt.poly.hangnt169.service.NhanVienService;

import java.util.List;
import java.util.UUID;

public class NhanVienServiceImpl implements NhanVienService {
    private NhanVienRepository nhanVienRepository = new NhanVienRepository();

    @Override
    public List<NhanVien> getList() {
        return nhanVienRepository.getList();
    }

    @Override
    public NhanVien getOne(UUID id) {
        return nhanVienRepository.getOne(id);
    }

    @Override
    public Boolean addNV(NhanVien nv) {
        return nhanVienRepository.addNV(nv);
    }

    @Override
    public Boolean updateNV(NhanVien nv) {
        return nhanVienRepository.updateNV(nv);
    }

    @Override
    public Boolean deleteNV(NhanVien nv) {
        return nhanVienRepository.deleteNV(nv);
    }

    @Override
    public List<NhanVien> seachTen(String ten) {
        return nhanVienRepository.seachTen(ten);
    }
}
