package com.example.asm_java5.services;

import com.example.asm_java5.entiy.MauSac;
import com.example.asm_java5.entiy.NSX;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface NSXService {
    List<NSX> getAll();
    Page<NSX> phanTrang(Pageable pageable);
    NSX findById(UUID id);
    int saveOrUpdate(NSX nsx);
    int delete(NSX nsx);
}
