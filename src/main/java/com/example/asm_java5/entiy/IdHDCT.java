package com.example.asm_java5.entiy;
import com.fasterxml.jackson.annotation.JacksonInject;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter@Setter
@AllArgsConstructor@NoArgsConstructor
@Embeddable
public class IdHDCT implements Serializable {
    @ManyToOne
    @JoinColumn(name = "id_hoa_don")
    private HoaDon hoaDon;
    @ManyToOne
    @JoinColumn(name = "id_chi_tiet_sp")
    private ChiTietSanPham chiTietSanPham;
}
