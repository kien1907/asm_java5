package com.example.asm_java5.services;

import com.example.asm_java5.entiy.Dong;
import com.example.asm_java5.entiy.SanPham;

public interface DongService {
    Dong add(Dong dong);
    Dong findByName(String name);
}
