package com.example.asm_java5.entiy;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter@Setter
@NoArgsConstructor@AllArgsConstructor
@Entity@Table(name = "nhan_vien")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String ma;
    @NotBlank(message = "Không được bỏ trống")
    private String ten;
    @NotBlank(message = "Không được bỏ trống")
    private String tenDem;
    @NotBlank(message = "Không được bỏ trống")
    private String ho;
    private String gioiTinh;
    @Temporal(TemporalType.DATE)
    private Date ngaySinh;
    @NotBlank(message = "Không được bỏ trống")
    private String diaChi;
    @NotBlank(message = "Không được bỏ trống")
    private String sdt;
    @NotBlank(message = "Không được bỏ trống")
    private String matKhau;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_ch")
    private CuaHang cuaHang;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cv")
    private ChucVu chucVu;
    private int trangThai;
}
