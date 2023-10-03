package com.example.asm_java5.services;

import com.example.asm_java5.entiy.KhachHang;

public interface KhachHangService {
    KhachHang findKhachHanfByMaAndMatKhau(String ma,String matKhau);
    boolean addKhachHang(KhachHang khachHang);
}
