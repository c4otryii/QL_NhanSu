package com.example.btcanhan.service;

import com.example.btcanhan.entity.NhanVien;
import com.example.btcanhan.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhanVienService {
    @Autowired
    private NhanVienRepository nhanvienRepository;
    public List<NhanVien> getAllNhanviens(){
        return nhanvienRepository.findAll();
    }
    public NhanVien getNhanVienId(String id){
        return nhanvienRepository.findById(id).orElse(null);
    }
    public void addNhanVien(NhanVien nhanVien){
        nhanvienRepository.save(nhanVien);
    }
    public void deleteNhanvien(String id){
        nhanvienRepository.deleteById(id);
    }
    public void updateNhanvien(NhanVien nhanVien){
        nhanvienRepository.save(nhanVien);
    }

}