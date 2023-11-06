package com.example.asm_java5.reposistories;

import com.example.asm_java5.entiy.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface SanPhamReposistory extends JpaRepository<SanPham, UUID> {
    SanPham getByTen(String name);
    @Query(value = "select * from san_pham",nativeQuery = true)
    Page<SanPham> phanTrang(Pageable pageable);
}
