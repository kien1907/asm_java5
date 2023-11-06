package com.example.asm_java5.reposistories;

import com.example.asm_java5.entiy.CuaHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface CuaHangReposistory extends JpaRepository<CuaHang, UUID> {
    @Query(value = "select * from cua_hang",nativeQuery = true)
    Page<CuaHang> getAll(Pageable pageable);
}
