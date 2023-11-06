package com.example.asm_java5.entiy;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "hoa_don_chi_tiet")
public class HoaDonCT {
    @EmbeddedId
   private IdHDCT idHDCT;
    private Integer soLuong;
    private Double donGia;
}
