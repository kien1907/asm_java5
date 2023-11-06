package com.example.asm_java5.entiy;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "chi_tiet_sp")
@ToString
@Builder
public class ChiTietSanPham implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_sp")
    private SanPham sanPham;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_dong_sp")
    private Dong dong;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_mau_sac")
    private MauSac mauSac;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_nsx")
    private NSX nsx;
    private int namBh;
    private String moTa;
    private String anh;
    private int soLuongTon;
    private double giaNhap;
    private double giaBan;
}
