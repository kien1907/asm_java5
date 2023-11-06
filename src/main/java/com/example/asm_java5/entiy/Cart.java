package com.example.asm_java5.entiy;

import lombok.*;

import java.io.Serializable;

@Getter@Setter@ToString
@AllArgsConstructor@NoArgsConstructor
public class Cart implements Serializable {
    private static final long serialVersionUID = -5969822387667032579L;
    private ChiTietSanPham ctsp;
    private Integer soLuong;
}
