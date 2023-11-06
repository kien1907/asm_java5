package com.example.asm_java5.services.impl;

import com.example.asm_java5.entiy.CuaHang;
import com.example.asm_java5.reposistories.CuaHangReposistory;
import com.example.asm_java5.services.CuaHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CuaHangServiceImpl implements CuaHangService {

    @Autowired
    CuaHangReposistory cuaHangReposistory;

    @Override
    public Page<CuaHang> pages(Pageable pageable) {
        return this.cuaHangReposistory.getAll(pageable);
    }

    @Override
    public List<CuaHang> getAll() {
        return cuaHangReposistory.findAll();
    }

    @Override
    public int saveOrUpdate(CuaHang cuaHang) {
        try {
            this.cuaHangReposistory.save(cuaHang);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
            return 1;
        }
    }

    @Override
    public int delete(CuaHang cuaHang) {
        try {
            this.cuaHangReposistory.delete(cuaHang);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
            return 1;
        }
    }

    @Override
    public CuaHang getOne(UUID id) {
        return cuaHangReposistory.findById(id).get();
    }

}
