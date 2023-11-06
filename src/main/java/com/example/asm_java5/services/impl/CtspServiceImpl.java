package com.example.asm_java5.services.impl;

import com.example.asm_java5.entiy.ChiTietSanPham;
import com.example.asm_java5.reposistories.CtspReposistory;
import com.example.asm_java5.services.CtspService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CtspServiceImpl implements CtspService {
    @Autowired
    CtspReposistory ctspReposistory;
    @Override
    public List<ChiTietSanPham> getAll(){
        return this.ctspReposistory.findAll();
    }

    @Override
    public ChiTietSanPham findById(UUID id) {
        return this.ctspReposistory.findById(id).get();
    }

    @Override
    public int saveAll(List<ChiTietSanPham> list) {
        this.ctspReposistory.saveAll(list);
        return 0;
    }

    @Override
    public Page<ChiTietSanPham> findAll(Pageable pageable) {
        return ctspReposistory.findAll(pageable);
    }

    @Override
    public void save(ChiTietSanPham chiTietSanPham) {
        ctspReposistory.save(chiTietSanPham);
    }

    @Override
    public void delete(ChiTietSanPham chiTietSanPham) {
        ctspReposistory.delete(chiTietSanPham);
    }

}
