package com.example.asm_java5.services.impl;

import com.example.asm_java5.entiy.MauSac;
import com.example.asm_java5.reposistories.MauSacReposistory;
import com.example.asm_java5.services.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MauSacServiceImpl implements MauSacService {
    @Autowired
    MauSacReposistory mauSacReposistory;
    @Override
    public MauSac add(MauSac mauSac) {
        return mauSacReposistory.save(mauSac);
    }

    @Override
    public MauSac findByName(String name) {
        return this.mauSacReposistory.findByTen(name);
    }
}
