package com.example.asm_java5.reposistories;

import com.example.asm_java5.entiy.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MauSacReposistory extends JpaRepository<MauSac, UUID> {
    MauSac findByTen(String name);
}
