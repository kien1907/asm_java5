package com.example.asm_java5.services.impl;

import com.example.asm_java5.entiy.MauSac;
import com.example.asm_java5.reposistories.MauSacReposistory;
import com.example.asm_java5.services.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MauSacServiceImpl implements MauSacService {
    @Autowired
    MauSacReposistory mauSacReposistory;

    @Override
    public MauSac findByName(String name) {
        return this.mauSacReposistory.findByTen(name);
    }

    @Override
    public Page<MauSac> phanTrang(Pageable pageable) {
        return mauSacReposistory.phanTrang(pageable);
    }

    @Override
    public MauSac findById(UUID id) {
        return mauSacReposistory.findById(id).get();
    }

    @Override
    public int saveOrUpdate(MauSac mauSac) {
        mauSacReposistory.save(mauSac);
        return 0;
    }

    @Override
    public int delete(MauSac mauSac) {
        mauSacReposistory.delete(mauSac);
        return 0;
    }

    @Override
    public List<MauSac> getAll() {
        return mauSacReposistory.findAll();
    }
}
