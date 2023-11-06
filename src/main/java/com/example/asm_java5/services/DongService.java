package com.example.asm_java5.services;

import com.example.asm_java5.entiy.Dong;
import com.example.asm_java5.entiy.MauSac;
import com.example.asm_java5.entiy.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface DongService {
    Dong findByName(String name);
    Page<Dong> phanTrang(Pageable pageable);
    Dong findById(UUID id);
    int saveOrUpdate(Dong dong);
    int delete(Dong dong);
    List<Dong> getAll();
}
