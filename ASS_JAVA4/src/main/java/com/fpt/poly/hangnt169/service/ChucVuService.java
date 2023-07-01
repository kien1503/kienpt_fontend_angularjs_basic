package com.fpt.poly.hangnt169.service;

import com.fpt.poly.hangnt169.entity.ChucVu;

import java.util.List;
import java.util.UUID;

public interface ChucVuService {

    List<ChucVu> getList();

    ChucVu getOne(UUID id);

    Boolean addSP(ChucVu cv);

    Boolean updateSP(ChucVu cv);

    Boolean deleteSP(ChucVu cv);

    List<ChucVu> seachTen(String ten);

}
