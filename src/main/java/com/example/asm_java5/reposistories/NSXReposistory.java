package com.example.asm_java5.reposistories;

import com.example.asm_java5.entiy.NSX;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NSXReposistory extends JpaRepository<NSX, UUID> {
}
