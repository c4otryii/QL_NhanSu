package com.example.btcanhan.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@Entity
@Table(name="nhanvien")
public class NhanVien {
    @Id
    @Column(name = "ma_nv")
    private String ma_nv;
    @Column(name = "ten_nv")
    @NotEmpty(message = "Ten nhan vien khong duoc rong")
    private String ten_nv;
    @Column(name = "phai")
    private String phai;
    @Column(name = "noi_sinh")
    private String noi_sinh;
    @ManyToOne
    @JoinColumn(name = "ma_phong")
    private PhongBan phongban;
    @Column(name = "luong")
    private int luong;

}
