package com.example.asm_java5.reposistories;

import com.example.asm_java5.entiy.ChucVu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChuVuReposistory extends JpaRepository<ChucVu, UUID> {
}
