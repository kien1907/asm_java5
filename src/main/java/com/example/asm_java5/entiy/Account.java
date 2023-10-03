package com.example.asm_java5.entiy;

import lombok.*;
import org.springframework.data.redis.core.RedisHash;

import java.util.UUID;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Account {
    private String ma;
    private String matKhau;
    private UUID idUser;
}
