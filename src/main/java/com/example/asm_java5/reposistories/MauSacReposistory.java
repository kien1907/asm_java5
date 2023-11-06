package com.example.asm_java5.reposistories;

import com.example.asm_java5.entiy.MauSac;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface MauSacReposistory extends JpaRepository<MauSac, UUID> {
    MauSac findByTen(String name);
    @Query(value = "select * from mau_sac",nativeQuery = true)
    Page<MauSac> phanTrang(Pageable pageable);
}
