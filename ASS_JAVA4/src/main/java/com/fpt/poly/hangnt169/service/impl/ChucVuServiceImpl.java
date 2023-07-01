package com.fpt.poly.hangnt169.service.impl;

import com.fpt.poly.hangnt169.entity.ChucVu;
import com.fpt.poly.hangnt169.repository.ChucVuRepository;
import com.fpt.poly.hangnt169.service.ChucVuService;

import java.util.List;
import java.util.UUID;

public class ChucVuServiceImpl implements ChucVuService {
    private ChucVuRepository chucVuRepository = new ChucVuRepository();

    @Override
    public List<ChucVu> getList() {
        return chucVuRepository.getList();
    }

    @Override
    public ChucVu getOne(UUID id) {
        return chucVuRepository.getOne(id);
    }

    @Override
    public Boolean addSP(ChucVu cv) {
        return chucVuRepository.addSP(cv);
    }

    @Override
    public Boolean updateSP(ChucVu cv) {
        return chucVuRepository.updateSP(cv);
    }

    @Override
    public Boolean deleteSP(ChucVu cv) {
        return chucVuRepository.deleteSP(cv);
    }

    @Override
    public List<ChucVu> seachTen(String ten) {
        return chucVuRepository.seachTen(ten);
    }
}
