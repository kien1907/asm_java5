package com.example.asm_java5.services.impl;

import com.example.asm_java5.entiy.KhachHang;
import com.example.asm_java5.reposistories.KhachHangReposistory;
import com.example.asm_java5.services.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class KhachHangServiceImpl implements KhachHangService {
    @Autowired
    KhachHangReposistory khachHangReposistory;

    @Override
    public KhachHang findKhachHanfByMaAndMatKhau(String ma, String matKhau) {
        return this.khachHangReposistory.findByMaAndMatKhau(ma,matKhau);
    }

    @Override
    public Page<KhachHang> phanTrang(Pageable pageable) {
        return khachHangReposistory.phanTrang(pageable);
    }

    @Override
    public KhachHang findById(UUID id) {
        return khachHangReposistory.findById(id).get();
    }

    @Override
    public int saveOrUpdate(KhachHang nsx) {
        khachHangReposistory.save(nsx);
        return 0;
    }

    @Override
    public int delete(KhachHang nsx) {
        khachHangReposistory.delete(nsx);
        return 0;
    }

    @Override
    public List<KhachHang> getAll() {
        return khachHangReposistory.findAll();
    }


}
