package com.example.asm_java5.controller;
import com.example.asm_java5.entiy.ChucVu;
import com.example.asm_java5.entiy.CuaHang;
import com.example.asm_java5.entiy.NhanVien;
import com.example.asm_java5.services.ChucVuService;
import com.example.asm_java5.services.CuaHangService;
import com.example.asm_java5.services.NhanVienService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

@Controller
public class NhanVienController {

    @Autowired
    NhanVienService nhanVienService;
    @Autowired
    CuaHangService cuaHangService;
    @Autowired
    ChucVuService chucVuService;

    @PostMapping("/nhan-vien/add")
    public String add(@RequestParam("ngaySinh") String date,
                      @RequestParam("idCuaHang") UUID idch,
                      @RequestParam("idChucVu") UUID idcv,
            @Valid @ModelAttribute("nhanvien") NhanVien nhanVien,
                      BindingResult result,Model model) throws Exception{
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date ngaySinh = dateFormat.parse(date);
        Random random = new Random();
        String ma = "NV"+random.nextInt(1000)+1;
        CuaHang cuaHang = cuaHangService.getOne(idch);
        ChucVu chucVu  = chucVuService.getOne(idcv);
        nhanVien.setMa(ma);
        nhanVien.setNgaySinh(ngaySinh);
        nhanVien.setCuaHang(cuaHang);
        nhanVien.setChucVu(chucVu);
        nhanVienService.saveOrUpdate(nhanVien);
        return "redirect:/nhan-vien/hien-thi";
    }
    @PostMapping("/nhan-vien/update")
    public String update(@RequestParam("ngaySinh") String date,
                      @RequestParam("idCuaHang") UUID idch,
                      @RequestParam("idChucVu") UUID idcv,
                      @Valid @ModelAttribute("nhanvien") NhanVien nhanVien,
                      BindingResult result,Model model) throws Exception{
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date ngaySinh = dateFormat.parse(date);
        CuaHang cuaHang = cuaHangService.getOne(idch);
        ChucVu chucVu  = chucVuService.getOne(idcv);
        nhanVien.setNgaySinh(ngaySinh);
        nhanVien.setCuaHang(cuaHang);
        nhanVien.setChucVu(chucVu);
        nhanVienService.saveOrUpdate(nhanVien);
        return "redirect:/nhan-vien/hien-thi";
    }
    @GetMapping("/nhan-vien/detail/{id}")
    public String detail(@PathVariable UUID id, Model model){
        NhanVien nhanVien = nhanVienService.findById(id);
        model.addAttribute("nhanvien",nhanVien);
        model.addAttribute("nv",nhanVien);
        model.addAttribute("listch",cuaHangService.getAll());
        model.addAttribute("listcv",chucVuService.getAll());
        model.addAttribute(
                "component",
                "NhanVien.jsp");
        return "QuanLy";
    }

    @GetMapping("/nhan-vien/delete/{id}")
    public String delete(@PathVariable UUID id){
        NhanVien nhanVien = nhanVienService.findById(id);
        nhanVienService.delete(nhanVien);
        return "redirect:/nhan-vien/hien-thi";
    }
}
