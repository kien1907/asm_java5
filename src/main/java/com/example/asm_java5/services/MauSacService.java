package com.example.asm_java5.services;

import com.example.asm_java5.entiy.MauSac;
import com.example.asm_java5.entiy.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface MauSacService {
    MauSac findByName(String name);
    Page<MauSac> phanTrang(Pageable pageable);
    MauSac findById(UUID id);
    int saveOrUpdate(MauSac mauSac);
    int delete(MauSac mauSac);
    List<MauSac> getAll();
}
