package com.example.asm_java5.reposistories;

import com.example.asm_java5.entiy.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SanPhamReposistory extends JpaRepository<SanPham, UUID> {
    SanPham getByTen(String name);
}
