package com.example.btcanhan.controller;

import com.example.btcanhan.entity.NhanVien;
import com.example.btcanhan.service.NhanVienService;
import com.example.btcanhan.service.PhongBanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/nhanviens")
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;
    @Autowired
    private PhongBanService phongBanService;
    @GetMapping
    public String showAllNhanVien(Model model){
        List<NhanVien> nhanViens = nhanVienService.getAllNhanviens();
        model.addAttribute("nhanviens", nhanViens);
        return "nhanviens/list";
    }
    @GetMapping("/add")
    public String addNhanVienForm(Model model){
        model.addAttribute("nhanvien",new NhanVien());
        model.addAttribute("phongban", phongBanService.getAllPhongBan());
        return "nhanviens/add";
    }
    @PostMapping("/add")
    public String addNhanVien(@Valid @ModelAttribute("nhanvien") NhanVien NHANVIEN, BindingResult result, Model model){
        // check lỗi
        if(result.hasErrors()){
            model.addAttribute("phongban", phongBanService.getAllPhongBan());
            return "nhanviens/add";
        }
        nhanVienService.addNhanVien(NHANVIEN);
        return "redirect:/nhanviens";
    }
    @GetMapping("/delete/{ma_nv}")
    public String deleteNhanvien(@PathVariable("ma_nv") String ma_nv){
        nhanVienService.deleteNhanvien(ma_nv);
        return "redirect:/nhanviens";
    }
    @GetMapping("edit/{ma_nv}")
    public String editNhanVienForm(@PathVariable("ma_nv")String ma_nv, Model model){
        NhanVien editnhanvien = nhanVienService.getNhanVienId(ma_nv);
        if (editnhanvien != null ){
            model.addAttribute("nhanvien",editnhanvien);
            model.addAttribute("phongban", phongBanService.getAllPhongBan());
            return "nhanvien/edit";
        }else {
            return "redirect:/nhanviens";
        }
    }

    @PostMapping("edit/{ma_nv}")
    public String editNhanVien(@PathVariable("ma_nv")String ma_nv, @ModelAttribute("nhanvien") @Valid NhanVien editNHANVIEN, BindingResult result, Model model){
        if (result.hasErrors()){
            model.addAttribute("phongban", phongBanService.getAllPhongBan());
            return "nhanviens/edit";
        }else {
            NhanVien existingNHANVIEN = nhanVienService.getNhanVienId(ma_nv);
            if ( existingNHANVIEN != null){
                existingNHANVIEN.setLuong(editNHANVIEN.getLuong());
                existingNHANVIEN.setNoi_sinh(editNHANVIEN.getNoi_sinh());
                existingNHANVIEN.setPhai(editNHANVIEN.getPhai());
                existingNHANVIEN.setTen_nv(editNHANVIEN.getTen_nv());
                existingNHANVIEN.setPhongban((editNHANVIEN.getPhongban()));
                nhanVienService.updateNhanvien(existingNHANVIEN);
            }
            return "redirect:/nhanviens";
        }
    }

}