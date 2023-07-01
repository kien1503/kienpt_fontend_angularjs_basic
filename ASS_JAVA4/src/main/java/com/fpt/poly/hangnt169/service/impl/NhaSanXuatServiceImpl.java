package com.fpt.poly.hangnt169.service.impl;

import com.fpt.poly.hangnt169.entity.NhaSanXuat;
import com.fpt.poly.hangnt169.repository.NSXRepository;
import com.fpt.poly.hangnt169.service.NhaSanXuatService;

import java.util.List;
import java.util.UUID;

public class NhaSanXuatServiceImpl implements NhaSanXuatService {
    private NSXRepository nsxRepository = new NSXRepository();

    @Override
    public List<NhaSanXuat> getList() {
        return nsxRepository.getList();
    }

    @Override
    public NhaSanXuat getOne(UUID id) {
        return nsxRepository.getOne(id);
    }

    @Override
    public Boolean addNSX(NhaSanXuat nsx) {
        return nsxRepository.addNSX(nsx);
    }

    @Override
    public Boolean updateNSX(NhaSanXuat nsx) {
        return nsxRepository.updateNSX(nsx);
    }

    @Override
    public Boolean deleteNSX(NhaSanXuat nsx) {
        return nsxRepository.deleteNSX(nsx);
    }
}
