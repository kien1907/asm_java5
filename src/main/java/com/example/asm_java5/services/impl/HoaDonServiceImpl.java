package com.example.asm_java5.services.impl;

import com.example.asm_java5.entiy.HoaDon;
import com.example.asm_java5.reposistories.HoaDonReposistory;
import com.example.asm_java5.services.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HoaDonServiceImpl implements HoaDonService{
    @Autowired
    HoaDonReposistory hoaDonReposistory;
    @Override
    public List<HoaDon> getAll() {
        return hoaDonReposistory.findAll();
    }

    @Override
    public Page<HoaDon> findAll(Pageable pageable) {
        return hoaDonReposistory.findAll(pageable);
    }
}
