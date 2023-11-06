package com.example.asm_java5.reposistories;

import com.example.asm_java5.entiy.ChiTietSanPham;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface CtspReposistory extends JpaRepository<ChiTietSanPham, UUID> {
    @Query(value = "select  * from chi_tiet_sp",nativeQuery = true)
    Page<ChiTietSanPham> findAll(Pageable pageable);
}
