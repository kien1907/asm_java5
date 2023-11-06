package com.example.asm_java5.reposistories;

import com.example.asm_java5.entiy.Dong;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface DongReposistory extends JpaRepository<Dong, UUID> {
    Dong findByTen(String name);
    @Query(value = "SELECT  * FROM dong_sp",nativeQuery = true)
    Page<Dong> phanTrang(Pageable pageable);
}
