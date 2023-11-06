package com.example.asm_java5.services;

import com.example.asm_java5.entiy.KhachHang;
import com.example.asm_java5.entiy.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface KhachHangService {
    KhachHang findKhachHanfByMaAndMatKhau(String ma,String matKhau);
    Page<KhachHang> phanTrang(Pageable pageable);
    KhachHang findById(UUID id);
    int saveOrUpdate(KhachHang nsx);
    int delete(KhachHang nsx);
    List<KhachHang> getAll();
}
