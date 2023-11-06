package com.example.asm_java5.services;

import com.example.asm_java5.entiy.NSX;
import com.example.asm_java5.entiy.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface SanPhamService {
    SanPham findByName(String name);
    Page<SanPham> phanTrang(Pageable pageable);
    SanPham findById(UUID id);
    int saveOrUpdate(SanPham nsx);
    int delete(SanPham nsx);
    List<SanPham> getAll();
}
