package com.example.asm_java5.services;

import com.example.asm_java5.entiy.KhachHang;
import com.example.asm_java5.entiy.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface NhanVienService {
    NhanVien findNhanVienByMaAndMatKhau(String ma,String matKhau);
    NhanVien findById(UUID id);
    NhanVien findByMa(String ma);
    Page<NhanVien> phanTrang(Pageable pageable);
    int saveOrUpdate (NhanVien nhanVien);
    int delete (NhanVien nhanVien);
}
