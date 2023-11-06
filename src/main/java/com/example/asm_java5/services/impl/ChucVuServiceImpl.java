package com.example.asm_java5.services.impl;

import com.example.asm_java5.entiy.ChucVu;
import com.example.asm_java5.entiy.CuaHang;
import com.example.asm_java5.reposistories.ChuVuReposistory;
import com.example.asm_java5.reposistories.CuaHangReposistory;
import com.example.asm_java5.services.ChucVuService;
import com.example.asm_java5.services.CuaHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChucVuServiceImpl implements ChucVuService {

    @Autowired
    ChuVuReposistory chuVuReposistory;

    @Override
    public Page<ChucVu> pages(Pageable pageable) {
        return chuVuReposistory.findAll(pageable);
    }

    @Override
    public List<ChucVu> getAll() {
        return chuVuReposistory.findAll();
    }

    @Override
    public int saveOrUpdate(ChucVu chucVu) {
        try {
            chuVuReposistory.save(chucVu);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
            return 1;
        }
    }

    @Override
    public int delete(ChucVu chucVu) {
        try {
            chuVuReposistory.delete(chucVu);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
            return 1;
        }
    }

    @Override
    public ChucVu getOne(UUID id) {
        return chuVuReposistory.findById(id).get();
    }
}
