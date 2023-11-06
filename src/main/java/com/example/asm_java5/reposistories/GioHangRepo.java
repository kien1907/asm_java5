package com.example.asm_java5.reposistories;

import com.example.asm_java5.entiy.Cart;
import com.example.asm_java5.entiy.ChiTietSanPham;
import com.example.asm_java5.entiy.ShopingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GioHangRepo extends CrudRepository<ShopingCart,String> {
}
