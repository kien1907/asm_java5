package com.example.asm_java5.entiy;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity@Table(name = "cua_hang")
public class CuaHang {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String ma;
    @NotBlank(message = "Không được bỏ trống")
    private String ten;
    @NotBlank(message = "Không được bỏ trống")
    private String diaChi;
    @NotBlank(message = "Không được bỏ trống")
    private String thanhPho;
    @NotBlank(message = "Không được bỏ trống")
    private String quocGia;
}
