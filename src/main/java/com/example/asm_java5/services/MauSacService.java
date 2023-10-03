package com.example.asm_java5.services;

import com.example.asm_java5.entiy.MauSac;
import com.example.asm_java5.entiy.SanPham;

public interface MauSacService {
    MauSac add(MauSac mauSac);
    MauSac findByName(String name);
}
