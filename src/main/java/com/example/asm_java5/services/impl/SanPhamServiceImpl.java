package com.example.asm_java5.services.impl;

import com.example.asm_java5.entiy.SanPham;
import com.example.asm_java5.reposistories.SanPhamReposistory;
import com.example.asm_java5.services.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SanPhamServiceImpl implements SanPhamService {
    @Autowired
    SanPhamReposistory sanPhamReposistory;
    @Override
    public SanPham add(SanPham sanPham) {
        return this.sanPhamReposistory.save(sanPham);
    }

    @Override
    public SanPham findByName(String name) {
        return this.sanPhamReposistory.getByTen(name);
    }
}
