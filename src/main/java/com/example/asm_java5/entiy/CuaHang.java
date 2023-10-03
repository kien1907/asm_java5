package com.example.asm_java5.entiy;

import jakarta.persistence.*;

import java.util.UUID;
@Entity@Table(name = "cua_hang")
public class CuaHang {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
}
