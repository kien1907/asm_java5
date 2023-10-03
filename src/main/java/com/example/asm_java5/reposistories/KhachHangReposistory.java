package com.example.asm_java5.reposistories;

import com.example.asm_java5.entiy.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface KhachHangReposistory extends JpaRepository<KhachHang, UUID> {
    KhachHang findByMaAndMatKhau(String ma,String matKhau);
}
