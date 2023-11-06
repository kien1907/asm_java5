package com.example.asm_java5.services.impl;

import com.example.asm_java5.entiy.Dong;
import com.example.asm_java5.entiy.MauSac;
import com.example.asm_java5.reposistories.DongReposistory;
import com.example.asm_java5.services.DongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DongServiceImpl implements DongService {
    @Autowired
    DongReposistory dongReposistory;
    @Override
    public Dong findByName(String name) {
        return this.dongReposistory.findByTen(name);
    }

    @Override
    public Page<Dong> phanTrang(Pageable pageable) {
        return dongReposistory.phanTrang(pageable);
    }

    @Override
    public Dong findById(UUID id) {
        return dongReposistory.findById(id).get();
    }

    @Override
    public int saveOrUpdate(Dong dong) {
        dongReposistory.save(dong);
        return 0;
    }

    @Override
    public int delete(Dong dong) {
        dongReposistory.delete(dong);
        return 0;
    }

    @Override
    public List<Dong> getAll() {
        return dongReposistory.findAll();
    }
}
