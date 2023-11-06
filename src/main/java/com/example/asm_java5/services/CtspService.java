package com.example.asm_java5.services;

import com.example.asm_java5.entiy.ChiTietSanPham;
import com.example.asm_java5.entiy.NSX;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface CtspService {
    List<ChiTietSanPham> getAll();
    ChiTietSanPham findById(UUID id);
    int saveAll(List<ChiTietSanPham> list);
    Page<ChiTietSanPham> findAll(Pageable pageable);
    void save(ChiTietSanPham chiTietSanPham);
    void delete(ChiTietSanPham chiTietSanPham);
}
