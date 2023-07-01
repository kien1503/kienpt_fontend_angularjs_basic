package com.fpt.poly.hangnt169.service;

import com.fpt.poly.hangnt169.entity.NhanVien;

import java.util.List;
import java.util.UUID;

public interface NhanVienService {
    List<NhanVien> getList();

    NhanVien getOne(UUID id);

    Boolean addNV(NhanVien nv);

    Boolean updateNV(NhanVien nv);

    Boolean deleteNV(NhanVien nv);

    List<NhanVien> seachTen(String ten);

}
