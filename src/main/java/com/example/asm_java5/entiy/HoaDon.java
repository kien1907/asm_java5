package com.example.asm_java5.entiy;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter@Setter
@AllArgsConstructor@NoArgsConstructor
@Entity
@Table(name = "hoa_don")
public class HoaDon {
    @Id
    private UUID id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_kh")
    private KhachHang khachHang;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_nv")
    private NhanVien nhanVien;
    private String ma;
    @Temporal(TemporalType.DATE)
    private Date ngayTao;
    private Date ngayShip;
    private Date ngayNhan;
    private int tinhTrang;
    private String tenNguoiNhan;
    private String diaChi;
    private String sdt;
}
