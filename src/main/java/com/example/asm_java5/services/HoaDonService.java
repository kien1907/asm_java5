package com.example.asm_java5.services;

import com.example.asm_java5.entiy.HoaDon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface HoaDonService {
    List<HoaDon> getAll();
    Page<HoaDon> findAll(Pageable pageable);
}
