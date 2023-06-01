package com.example.btcanhan.service;

import com.example.btcanhan.entity.PhongBan;
import com.example.btcanhan.repository.PhongBanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhongBanService {
    @Autowired
    private PhongBanRepository phongbanRepository;
    public List<PhongBan> getAllPhongBan(){ return phongbanRepository.findAll();}
    public PhongBan getPhongBanById(String id){return phongbanRepository.findById(id).orElse(null);}
    public PhongBan savePhongban(PhongBan PHONGBAN) { return phongbanRepository.save(PHONGBAN);}
    public void deletePhongban(String id){ phongbanRepository.deleteById(id);}
}