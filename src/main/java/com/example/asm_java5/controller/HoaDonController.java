package com.example.asm_java5.controller;

import com.example.asm_java5.entiy.ChiTietSanPham;
import com.example.asm_java5.entiy.HoaDon;
import com.example.asm_java5.services.CtspService;
import com.example.asm_java5.services.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class HoaDonController {
    @Autowired
    HoaDonService hoaDonService;
    @Autowired
    CtspService ctspService;
    @GetMapping("/hoa-don/hien-thi")
    public String fromBH(Model model, @RequestParam("p") Optional<Integer> pageNumber){
        Pageable pageable = PageRequest.of(pageNumber.orElse(0),3);
        Page<HoaDon> hoaDonPage = hoaDonService.findAll(pageable);
        model.addAttribute("pageHoaDon",hoaDonPage);
        Page<ChiTietSanPham> sanPhamCTPage = ctspService.findAll(pageable);
        model.addAttribute("pagectsp",sanPhamCTPage);
        model.addAttribute(
                "component",
                "BanHang.jsp");
//        Pageable pageable = PageRequest.of(pageNumber.orElse(0),5);
//        Page<KhachHang> page = khachHangService.phanTrang(pageable);
        return "QuanLy";
    }
}
