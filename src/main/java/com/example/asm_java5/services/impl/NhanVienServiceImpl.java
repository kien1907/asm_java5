package com.example.asm_java5.services.impl;

import com.example.asm_java5.entiy.KhachHang;
import com.example.asm_java5.entiy.NhanVien;
import com.example.asm_java5.reposistories.NhanVienReposistory;
import com.example.asm_java5.services.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.swing.text.TabExpander;
import java.util.List;
import java.util.UUID;

@Service
public class NhanVienServiceImpl implements NhanVienService {
    @Autowired
    NhanVienReposistory nhanVienReposistory;

    @Override
    public NhanVien findNhanVienByMaAndMatKhau(String ma, String matKhau) {
        return this.nhanVienReposistory.findByMaAndMatKhau(ma,matKhau);
    }

    @Override
    public NhanVien findById(UUID id) {
        return this.nhanVienReposistory.findById(id).get();
    }

    @Override
    public NhanVien findByMa(String ma) {
        return nhanVienReposistory.findByMa(ma);
    }

    @Override
    public Page<NhanVien> phanTrang(Pageable pageable) {
        return nhanVienReposistory.phanTrang(pageable);
    }

    @Override
    public int saveOrUpdate(NhanVien nhanVien) {
        try {
            nhanVienReposistory.save(nhanVien);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
            return 1;
        }
    }

    @Override
    public int delete(NhanVien nhanVien) {
        try {
            nhanVienReposistory.delete(nhanVien);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
            return 1;
        }
    }



}
