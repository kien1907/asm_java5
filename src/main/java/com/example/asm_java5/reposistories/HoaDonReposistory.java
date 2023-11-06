package com.example.asm_java5.reposistories;

import com.example.asm_java5.entiy.HoaDon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HoaDonReposistory extends JpaRepository<HoaDon, UUID> {
    @Override
    Page<HoaDon> findAll(Pageable pageable);
}
