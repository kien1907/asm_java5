package com.example.asm_java5.services;

import com.example.asm_java5.entiy.NhanVien;

import java.util.UUID;

public interface NhanVienService {
    NhanVien findNhanVienByMaAndMatKhau(String ma,String matKhau);
    NhanVien findById(UUID id);

}
