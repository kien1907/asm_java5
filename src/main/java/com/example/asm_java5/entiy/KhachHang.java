package com.example.asm_java5.entiy;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.redis.core.RedisHash;

import java.util.Date;
import java.util.UUID;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "khach_hang")
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;
    private String ma;
    @NotBlank(message = "Không được để trống")
    private String ten;
    @NotBlank(message = "Không được để trống")
    private String tenDem;
    @NotBlank(message = "Không được để trống")
    private String ho;
    @Temporal(TemporalType.DATE)
    private Date ngaySinh;
    @NotBlank(message = "Không được để trống")
    @Size(max = 10,min = 10,message = "Số điện chỉ có 10 số")
    private String sdt;
    @NotBlank(message = "Không được để trống")
    private String diaChi;
    @NotBlank(message = "Không được để trống")
    private String thanhPho;
    @NotBlank(message = "Không được để trống")
    private String quocGia;
    @NotBlank(message = "Không được để trống")
    private String matKhau;
}
