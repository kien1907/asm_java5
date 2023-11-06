package com.example.asm_java5.services.impl;

import com.example.asm_java5.entiy.ShopingCart;
import com.example.asm_java5.reposistories.GioHangRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class GioHangServiceImpl {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    GioHangRepo gioHangRepo;

    public void add(ShopingCart shopingCart){
        ValueOperations value = redisTemplate.opsForValue();
        value.set(shopingCart.getId(),shopingCart);
    }

    public  ShopingCart find(String id){
        ValueOperations<String,Object> value = redisTemplate.opsForValue();
        return (ShopingCart) value.get(id);
    }

    public boolean isAlreadyExists(String key){
        return redisTemplate.hasKey(key);
    }

    public void xoa(String id){
        gioHangRepo.deleteById(id);
    }
}
