package com.example.asm_java5.entiy;

import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("GioHang")
public class ShopingCart implements Serializable {
    @Id
    private String id;
    List<Cart> list;
}
