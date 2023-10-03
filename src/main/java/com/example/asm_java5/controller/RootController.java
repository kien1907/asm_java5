package com.example.asm_java5.controller;

import com.example.asm_java5.entiy.*;
import com.example.asm_java5.services.CtspService;
import com.example.asm_java5.services.KhachHangService;
import com.example.asm_java5.services.NSXService;
import com.example.asm_java5.services.NhanVienService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Random;
import java.util.UUID;

@Controller
@RequestMapping("/")
public class RootController {
    @Autowired
    NSXService nsxService;
    @Autowired
    CtspService ctspService;
    @Autowired
    NhanVienService nhanVienService;
    @Autowired
    KhachHangService khachHangService;

    @GetMapping("/")
    public String hienThi(Model model) {
        model.addAttribute("listNSX", this.nsxService.getAll());
        model.addAttribute("filter", new Filter());
        model.addAttribute("listCTSP", this.ctspService.getAll());
        model.addAttribute("acc", new Account());
        model.addAttribute("login", "Login1.jsp");
        return "index";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("acc") Account account, Model model) {
        NhanVien nhanVien = this.nhanVienService
                .findNhanVienByMaAndMatKhau(account.getMa(), account.getMatKhau());
        KhachHang khachHang = this.khachHangService
                .findKhachHanfByMaAndMatKhau(account.getMa(), account.getMatKhau());
        if (nhanVien != null) {
            return "redirect:/quan-ly/"+nhanVien.getId();
        }
        if (khachHang == null) {
            return "index";
        }
        model.addAttribute(
                "fullName",
                khachHang.getHo() + " " + khachHang.getTenDem() + " " + khachHang.getTen());
        model.addAttribute("login", "Login2.jsp");
        model.addAttribute("listNSX", this.nsxService.getAll());
        model.addAttribute("filter", new Filter());
        model.addAttribute("listCTSP", this.ctspService.getAll());
        model.addAttribute("acc", new Account());
        return "index";

    }

    @GetMapping("/register")
    public String dangKi(Model model) {
        model.addAttribute("kh", new KhachHang());
        return "DangKi";
    }

    @PostMapping("/addnewkh")
    public String addNewKh(@Valid @ModelAttribute("kh") KhachHang khachHang, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("error", bindingResult.getFieldError());
            return "DangKi";
        }
        this.khachHangService.addKhachHang(khachHang);
        return "redirect:/";
    }

    @GetMapping("/detailsp/{id}")
    public String dangKi(@PathVariable UUID id, Model model) {
        System.out.println(id);
        ChiTietSanPham chiTietSanPham = this.ctspService.findById(id);
        model.addAttribute("sp", chiTietSanPham);
        return "Detail";
    }
}
