package com.example.asm_java5.reposistories;

import com.example.asm_java5.entiy.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface NhanVienReposistory extends JpaRepository<NhanVien, UUID> {
    NhanVien findByMaAndMatKhau(String ma,String matKhau);
}
