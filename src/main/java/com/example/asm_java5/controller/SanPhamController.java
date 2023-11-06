package com.example.asm_java5.controller;

import com.example.asm_java5.entiy.MauSac;
import com.example.asm_java5.entiy.SanPham;
import com.example.asm_java5.services.MauSacService;
import com.example.asm_java5.services.SanPhamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Random;
import java.util.UUID;

@Controller
public class SanPhamController {
    @Autowired
    SanPhamService sanPhamService;
    @PostMapping("/sanpham/add")
    public String add(@Valid @ModelAttribute("sanpham") SanPham sanPham,
                      BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("error",bindingResult.getFieldError());
            model.addAttribute(
                    "component",
                    "SanPham.jsp");
            return "QuanLy";
        }
        Random random = new Random();
        String ma = "SP"+random.nextInt(1000)+1;
        sanPham.setId(null);
        sanPham.setMa(ma);
        sanPhamService.saveOrUpdate(sanPham);
        return "redirect:/sanpham/hien-thi";
    }
    @GetMapping("/sanpham/delete/{id}")
    public String delete(@PathVariable UUID id){
        SanPham sanPham = sanPhamService.findById(id);
        sanPhamService.delete(sanPham);
        return "redirect:/sanpham/hien-thi";
    }
    @GetMapping("/sanpham/detail/{id}")
    public String detail(@PathVariable UUID id,Model model){
        SanPham sanPham = sanPhamService.findById(id);
        model.addAttribute("sanpham",sanPham);
        model.addAttribute(
                "component",
                "SanPham.jsp");
        return "QuanLy";
    }
    @PostMapping("/sanpham/update")
    public String update(@Valid @ModelAttribute("sanpham")SanPham sanPham,
                         BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("error",bindingResult.getFieldError());
            model.addAttribute(
                    "component",
                    "SanPham.jsp");
            return "QuanLy";
        }
        sanPhamService.saveOrUpdate(sanPham);
        return "redirect:/sanpham/hien-thi";
    }
}
