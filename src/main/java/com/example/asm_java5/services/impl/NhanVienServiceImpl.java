package com.example.asm_java5.services.impl;

import com.example.asm_java5.entiy.NhanVien;
import com.example.asm_java5.reposistories.NhanVienReposistory;
import com.example.asm_java5.services.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.swing.text.TabExpander;
import java.util.UUID;

@Service
public class NhanVienServiceImpl implements NhanVienService {
    @Autowired
    NhanVienReposistory nhanVienReposistory;
    @Autowired
    RedisTemplate redisTemplate;

    private final String HAS_KEY = "USER";

    @Override
    public NhanVien findNhanVienByMaAndMatKhau(String ma, String matKhau) {
        return this.nhanVienReposistory.findByMaAndMatKhau(ma,matKhau);
    }

    @Override
    public NhanVien findById(UUID id) {
        return this.nhanVienReposistory.getOne(id);
    }

}
