package com.example.asm_java5.entiy;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.UUID;
@Data
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@RedisHash("Account")
public class Account implements Serializable{
    @Id
    @NotBlank(message = "Không được để trống")
    private String ma;
    @NotBlank(message = "Không được để trống")
    private String matKhau;
    private boolean remember;
}
