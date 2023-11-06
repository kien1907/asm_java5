package com.example.asm_java5.entiy;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Primary;

import java.util.UUID;
@Getter@Setter
@AllArgsConstructor@NoArgsConstructor
@Entity@Table(name = "chuc_vu")
public class ChucVu {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String ma;
    @NotBlank(message = "Không được bỏ trống")
    private String ten;


}
