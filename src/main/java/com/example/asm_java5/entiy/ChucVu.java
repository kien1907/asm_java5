package com.example.asm_java5.entiy;

import jakarta.persistence.*;
import org.springframework.context.annotation.Primary;

import java.util.UUID;

@Entity@Table(name = "chuc_vu")
public class ChucVu {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
}
