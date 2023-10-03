package com.example.asm_java5.services.impl;

import com.example.asm_java5.entiy.KhachHang;
import com.example.asm_java5.reposistories.KhachHangReposistory;
import com.example.asm_java5.services.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KhachHangServiceImpl implements KhachHangService {
    @Autowired
    KhachHangReposistory khachHangReposistory;

    @Override
    public KhachHang findKhachHanfByMaAndMatKhau(String ma, String matKhau) {
        return this.khachHangReposistory.findByMaAndMatKhau(ma,matKhau);
    }

    @Override
    public boolean addKhachHang(KhachHang khachHang) {
        try {
            this.khachHangReposistory.save(khachHang);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
