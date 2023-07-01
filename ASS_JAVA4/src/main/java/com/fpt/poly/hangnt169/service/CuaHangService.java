package com.fpt.poly.hangnt169.service;

import com.fpt.poly.hangnt169.entity.CuaHang;

import java.util.List;
import java.util.UUID;

public interface CuaHangService {

    List<CuaHang> getList();

    CuaHang getOne(UUID id);

    Boolean addCH(CuaHang ch);

    Boolean updateCH(CuaHang ch);

    Boolean deleteCH(CuaHang ch);

}
