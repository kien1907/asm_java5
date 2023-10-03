package com.example.asm_java5.entiy;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter@Setter
@AllArgsConstructor@NoArgsConstructor
@Entity@Table(name = "nxs")
@ToString
public class NSX {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String ma;
    private String ten;
}
