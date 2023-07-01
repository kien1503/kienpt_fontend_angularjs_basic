package com.fpt.poly.hangnt169.service;

import com.fpt.poly.hangnt169.entity.NhaSanXuat;

import java.util.List;
import java.util.UUID;

public interface NhaSanXuatService {
    List<NhaSanXuat> getList();

    NhaSanXuat getOne(UUID id);

    Boolean addNSX(NhaSanXuat nsx);

    Boolean updateNSX(NhaSanXuat nsx);

    Boolean deleteNSX(NhaSanXuat nsx);
}
