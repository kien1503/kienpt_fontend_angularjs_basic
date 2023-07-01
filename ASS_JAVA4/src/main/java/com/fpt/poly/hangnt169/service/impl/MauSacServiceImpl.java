package com.fpt.poly.hangnt169.service.impl;

import com.fpt.poly.hangnt169.entity.MauSac;
import com.fpt.poly.hangnt169.repository.MauSacRepository;
import com.fpt.poly.hangnt169.service.MauSacService;

import java.util.List;
import java.util.UUID;

public class MauSacServiceImpl implements MauSacService {
    private MauSacRepository mauSacRepository = new MauSacRepository();

    @Override
    public List<MauSac> getList() {
        return mauSacRepository.getList();
    }

    @Override
    public MauSac getOne(UUID id) {
        return mauSacRepository.getOne(id);
    }

    @Override
    public Boolean addMS(MauSac ms) {
        return mauSacRepository.addSP(ms);
    }

    @Override
    public Boolean updateMS(MauSac ms) {
        return mauSacRepository.updateSP(ms);
    }

    @Override
    public Boolean deleteMS(MauSac ms) {
        return mauSacRepository.deleteSP(ms);
    }
}
