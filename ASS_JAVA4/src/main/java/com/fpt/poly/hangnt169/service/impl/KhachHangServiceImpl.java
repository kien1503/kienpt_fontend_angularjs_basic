package com.fpt.poly.hangnt169.service.impl;

import com.fpt.poly.hangnt169.entity.KhachHang;
import com.fpt.poly.hangnt169.repository.KhachHangRepository;
import com.fpt.poly.hangnt169.service.KhachHangService;

import java.util.List;
import java.util.UUID;

public class KhachHangServiceImpl implements KhachHangService {
    private KhachHangRepository khachHangRepository = new KhachHangRepository();

    @Override
    public List<KhachHang> getList() {
        return khachHangRepository.getList();
    }

    @Override
    public KhachHang getOne(UUID id) {
        return khachHangRepository.getOne(id);
    }

    @Override
    public Boolean addKH(KhachHang kh) {
        return khachHangRepository.addKH(kh);
    }

    @Override
    public Boolean updateKH(KhachHang kh) {
        return khachHangRepository.updateKH(kh);
    }

    @Override
    public Boolean deleteKH(KhachHang kh) {
        return khachHangRepository.deleteKH(kh);
    }

    @Override
    public List<KhachHang> seachTen(String ten) {
        return khachHangRepository.seachTen(ten);
    }
}
