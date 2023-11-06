package com.example.asm_java5.services;

import com.example.asm_java5.entiy.CuaHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface CuaHangService {
    Page<CuaHang> pages(Pageable pageable);
    List<CuaHang> getAll();

    int saveOrUpdate(CuaHang cuaHang);
    int delete(CuaHang cuaHang);
    CuaHang getOne(UUID id);
}
