package com.example.asm_java5.services;

import com.example.asm_java5.entiy.ChucVu;
import com.example.asm_java5.entiy.CuaHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ChucVuService {
    Page<ChucVu> pages(Pageable pageable);
    List<ChucVu> getAll();

    int saveOrUpdate(ChucVu chucVu);
    int delete(ChucVu chucVu);
    ChucVu getOne(UUID id);
}
