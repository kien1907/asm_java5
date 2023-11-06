package com.example.asm_java5.reposistories;

import com.example.asm_java5.entiy.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface KhachHangReposistory extends JpaRepository<KhachHang, UUID> {
    KhachHang findByMaAndMatKhau(String ma,String matKhau);
    @Query(value = "select * from khach_hang",nativeQuery = true)
    Page<KhachHang> phanTrang(Pageable pageable);
}
