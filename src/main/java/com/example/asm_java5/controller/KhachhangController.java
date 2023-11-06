package com.example.asm_java5.controller;
import com.example.asm_java5.entiy.ChucVu;
import com.example.asm_java5.entiy.CuaHang;
import com.example.asm_java5.entiy.KhachHang;
import com.example.asm_java5.entiy.NhanVien;
import com.example.asm_java5.services.ChucVuService;
import com.example.asm_java5.services.CuaHangService;
import com.example.asm_java5.services.KhachHangService;
import com.example.asm_java5.services.NhanVienService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@RestController
@CrossOrigin("http://localhost:3000")
public class KhachhangController {

@Autowired
    KhachHangService khachHangService;

    @GetMapping("/api/khach-hang/hien-thi")
    public List<KhachHang> hienthi(){
        return khachHangService.getAll();
    }

    @PostMapping("/khach-hang/add")
    public String add(@RequestParam("ngaySinh") String date,
                      @Valid @ModelAttribute("khachhang")KhachHang khachHang,
                      BindingResult result, Model model) throws Exception{
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date ngaySinh = dateFormat.parse(date);
        Random random = new Random();
        String ma = "NV"+random.nextInt(1000)+1;
        khachHang.setMa(ma);
        khachHang.setNgaySinh(ngaySinh);
        khachHangService.saveOrUpdate(khachHang);
        return "redirect:/khach-hang/hien-thi";
    }
    @PostMapping("/khach-hang/update")
    public String update(@RequestParam("ngaySinh") String date,
                         @Valid @ModelAttribute("khachhang")KhachHang khachHang,
                      BindingResult result,Model model) throws Exception{
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date ngaySinh = dateFormat.parse(date);
        khachHang.setNgaySinh(ngaySinh);;
        khachHangService.saveOrUpdate(khachHang);
        return "redirect:/khach-hang/hien-thi";
    }
    @GetMapping("/khach-hang/detail/{id}")
    public String detail(@PathVariable UUID id, Model model){
        KhachHang khachHang = khachHangService.findById(id);
        model.addAttribute("khachhang",khachHang);
        model.addAttribute("kh",khachHang);
        model.addAttribute(
                "component",
                "KhachHang.jsp");
        return "QuanLy";
    }

    @GetMapping("/khach-hang/delete/{id}")
    public String delete(@PathVariable UUID id){
        KhachHang khachHang = khachHangService.findById(id);
        khachHangService.delete(khachHang);
        return "redirect:/khach-hang/hien-thi";
    }
}
