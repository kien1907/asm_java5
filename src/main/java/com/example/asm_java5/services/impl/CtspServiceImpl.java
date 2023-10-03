package com.example.asm_java5.services.impl;

import com.example.asm_java5.entiy.ChiTietSanPham;
import com.example.asm_java5.reposistories.CtspReposistory;
import com.example.asm_java5.services.CtspService;
import org.springframework.beans.factory.annotation.Autowired;
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
        return this.ctspReposistory.getOne(id);
    }

    @Override
    public int saveAll(List<ChiTietSanPham> list) {
        this.ctspReposistory.saveAll(list);
        return 0;
    }

}
