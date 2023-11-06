package com.example.asm_java5.services.impl;

import com.example.asm_java5.entiy.SanPham;
import com.example.asm_java5.reposistories.SanPhamReposistory;
import com.example.asm_java5.services.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SanPhamServiceImpl implements SanPhamService {
    @Autowired
    SanPhamReposistory sanPhamReposistory;
    @Override
    public SanPham findByName(String name) {
        return this.sanPhamReposistory.getByTen(name);
    }

    @Override
    public Page<SanPham> phanTrang(Pageable pageable) {
        return sanPhamReposistory.phanTrang(pageable);
    }

    @Override
    public SanPham findById(UUID id) {
        return sanPhamReposistory.findById(id).get();
    }

    @Override
    public int saveOrUpdate(SanPham nsx) {
        sanPhamReposistory.save(nsx);
        return 0;
    }

    @Override
    public int delete(SanPham nsx) {
        sanPhamReposistory.delete(nsx);
        return 0;
    }

    @Override
    public List<SanPham> getAll() {
        return sanPhamReposistory.findAll();
    }
}
