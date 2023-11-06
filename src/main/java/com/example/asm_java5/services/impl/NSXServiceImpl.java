package com.example.asm_java5.services.impl;

import com.example.asm_java5.entiy.MauSac;
import com.example.asm_java5.entiy.NSX;
import com.example.asm_java5.reposistories.NSXReposistory;
import com.example.asm_java5.services.NSXService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NSXServiceImpl implements NSXService {
    @Autowired
    NSXReposistory nsxReposistory;
    @Override
    public List<NSX> getAll() {
        return this.nsxReposistory.findAll();
    }


    @Override
    public Page<NSX> phanTrang(Pageable pageable) {
        return nsxReposistory.findAll(pageable);
    }

    @Override
    public NSX findById(UUID id) {
        return nsxReposistory.findById(id).get();
    }

    @Override
    public int saveOrUpdate(NSX nsx) {
        nsxReposistory.save(nsx);
        return 0;
    }

    @Override
    public int delete(NSX nsx) {
        nsxReposistory.delete(nsx);
        return 0;
    }

}
