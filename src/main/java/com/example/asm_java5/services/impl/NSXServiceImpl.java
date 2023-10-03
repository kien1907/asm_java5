package com.example.asm_java5.services.impl;

import com.example.asm_java5.entiy.NSX;
import com.example.asm_java5.reposistories.NSXReposistory;
import com.example.asm_java5.services.NSXService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NSXServiceImpl implements NSXService {
    @Autowired
    NSXReposistory nsxReposistory;
    @Override
    public List<NSX> getAll() {
        return this.nsxReposistory.findAll();
    }

}
