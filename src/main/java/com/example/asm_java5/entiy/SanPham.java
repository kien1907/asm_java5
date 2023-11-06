package com.example.asm_java5.entiy;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "san_pham")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SanPham implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String ma;
    @NotBlank(message = "Không được bỏ trống")
    private String ten;
}
