package com.example.asm_java5.services.impl;

import com.example.asm_java5.entiy.Dong;
import com.example.asm_java5.reposistories.DongReposistory;
import com.example.asm_java5.services.DongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DongServiceImpl implements DongService {
    @Autowired
    DongReposistory dongReposistory;
    @Override
    public Dong add(Dong dong) {
        return dongReposistory.save(dong);
    }

    @Override
    public Dong findByName(String name) {
        return this.dongReposistory.findByTen(name);
    }
}
