package com.example.asm_java5.reposistories;

import com.example.asm_java5.entiy.Dong;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DongReposistory extends JpaRepository<Dong, UUID> {
    Dong findByTen(String name);
}
