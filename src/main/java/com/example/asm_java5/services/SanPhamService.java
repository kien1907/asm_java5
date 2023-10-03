package com.example.asm_java5.services;

import com.example.asm_java5.entiy.SanPham;

public interface SanPhamService {
    SanPham add(SanPham sanPham);
    SanPham findByName(String name);
}
