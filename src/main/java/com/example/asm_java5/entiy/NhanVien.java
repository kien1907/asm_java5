package com.example.asm_java5.entiy;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.UUID;

@Getter@Setter
@NoArgsConstructor@AllArgsConstructor
@Entity@Table(name = "nhan_vien")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String ma;
    private String ten;
    private String tenDem;
    private String ho;
    private String gioiTinh;
    private Date ngaySinh;
    private String diaChi;
    private String sdt;
    private String matKhau;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_ch")
    private CuaHang cuaHang;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cv")
    private ChucVu chucVu;
}
