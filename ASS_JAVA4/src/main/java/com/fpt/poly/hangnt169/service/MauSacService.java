package com.fpt.poly.hangnt169.service;

import com.fpt.poly.hangnt169.entity.MauSac;

import java.util.List;
import java.util.UUID;

public interface MauSacService {

    List<MauSac> getList();

    MauSac getOne(UUID id);

    Boolean addMS(MauSac ms);

    Boolean updateMS(MauSac ms);

    Boolean deleteMS(MauSac ms);
}
