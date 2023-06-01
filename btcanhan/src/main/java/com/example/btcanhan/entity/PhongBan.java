package com.example.btcanhan.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "phongban")
public class PhongBan {
    @Id
    @Column(name = "ma_phong")
    private String ma_phong;
    @Column(name = "ten_phong")
    private String ten_phong;
    private List<NhanVien> nhanviens;

}