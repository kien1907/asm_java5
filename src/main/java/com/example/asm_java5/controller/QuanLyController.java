package com.example.asm_java5.controller;

import com.example.asm_java5.entiy.*;
import com.example.asm_java5.services.*;
import jakarta.validation.Valid;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;
import java.util.*;

@RestController
public class QuanLyController {
    @Autowired
    NhanVienService nhanVienService;
    @Autowired
    AccountService accountService;
    @Autowired
    CtspService ctspService;
    @Autowired
    SanPhamService sanPhamService;
    @Autowired
    MauSacService mauSacService;
    @Autowired
    DongService dongService;
    @Autowired
    CuaHangService cuaHangService;
    @Autowired
    ChucVuService  chucVuService;
    @Autowired
    NSXService nsxService;
    @Autowired
    KhachHangService khachHangService;
    @Autowired
    HoaDonService hoaDonService;

    private NhanVien nhanVien;

    @GetMapping
    public String formLogin(Model model){
        model.addAttribute("acc",new Account());
        return "QuanLy";
    }

    @GetMapping("/login")
    public String login(@Validated @ModelAttribute("acc") Account account,
                         BindingResult result,Model model
                        ){
        if(result.hasErrors()){
            model.addAttribute("error",result.getFieldError());
            return"Login";
        }
        NhanVien nhanVien1 = nhanVienService.findNhanVienByMaAndMatKhau(account.getMa(),account.getMatKhau());
        if(nhanVien1 == null){
            return"Login";
        }
        if(account.isRemember()){
            accountService.saveAcc(account);
        }
        nhanVien = nhanVien1;
//        return"Login";
        return "redirect:/quan-ly";
    }

    @GetMapping("/logout/{ma}")
    public String logout(@PathVariable String ma){
        accountService.delete(ma);
        return "redirect:/";
    }

    @GetMapping("/quan-ly")
    public String hienThi( Model model){
        return "QuanLy";
    }

    @GetMapping("/san-pham-ct/hien-thi")
    public ResponseEntity hienThiSanPhamCT(@RequestParam("p") Optional<Integer> pageNumber, Model model){
        Pageable pageable = PageRequest.of(pageNumber.orElse(0),5);
        Page<ChiTietSanPham> page = ctspService.findAll(pageable);
//        model.addAttribute("page",page);
//        model.addAttribute(
//                "component",
//                "SanPhamCT.jsp");
        return new ResponseEntity(page, HttpStatus.OK);
    }

    @GetMapping("/cua-hang/hien-thi")
    public String hienThiCuaHang(@RequestParam("p") Optional<Integer> pageNumber, Model model){
        model.addAttribute("cuahang",new CuaHang());
//        model.addAttribute("listch",cuaHangService.getAll());
        Pageable pageable = PageRequest.of(pageNumber.orElse(0),5);
        Page<CuaHang> page = cuaHangService.pages(pageable);
        model.addAttribute("page",page);
        model.addAttribute(
                "component",
                "CuaHang.jsp");
        return "QuanLy";
    }

    @GetMapping("/chuc-vu/hien-thi")
    public String hienThiChucVu(@RequestParam("p") Optional<Integer> pageNumber, Model model){
        model.addAttribute("chucvu",new ChucVu());
//        model.addAttribute("listch",cuaHangService.getAll());
        Pageable pageable = PageRequest.of(pageNumber.orElse(0),5);
        Page<ChucVu> page = chucVuService.pages(pageable);
        model.addAttribute("page",page);
        model.addAttribute(
                "component",
                "ChucVu.jsp");
        return "QuanLy";
    }

    @GetMapping("/nhan-vien/hien-thi")
    public String hienThiNhanVien(@RequestParam("p") Optional<Integer> pageNumber, Model model){
        model.addAttribute("nhanvien",new NhanVien());
//        model.addAttribute("listch",cuaHangService.getAll());
        model.addAttribute("listch",cuaHangService.getAll());
        model.addAttribute("listcv",chucVuService.getAll());
        Pageable pageable = PageRequest.of(pageNumber.orElse(0),5);
        Page<NhanVien> page = nhanVienService.phanTrang(pageable);
        model.addAttribute("page",page);
        model.addAttribute(
                "component",
                "NhanVien.jsp");
        return "QuanLy";
    }

    @GetMapping("/mau-sac/hien-thi")
    public String hienThiMauSac(@RequestParam("p") Optional<Integer> pageNumber, Model model){
        model.addAttribute("mausac",new MauSac());
//        model.addAttribute("listch",cuaHangService.getAll());
        Pageable pageable = PageRequest.of(pageNumber.orElse(0),5);
        Page<MauSac> page = mauSacService.phanTrang(pageable);
        model.addAttribute("page",page);
        model.addAttribute(
                "component",
                "MauSac.jsp");
        return "QuanLy";
    }
    @GetMapping("/dong/hien-thi")
    public String hienThiDong(@RequestParam("p") Optional<Integer> pageNumber, Model model){
        model.addAttribute("dong",new Dong());
//        model.addAttribute("listch",cuaHangService.getAll());
        Pageable pageable = PageRequest.of(pageNumber.orElse(0),5);
        Page<Dong> page = dongService.phanTrang(pageable);
        model.addAttribute("page",page);
        model.addAttribute(
                "component",
                "Dong.jsp");
        return "QuanLy";
    }
    @GetMapping("/nsx/hien-thi")
    public String hienThiNSX(@RequestParam("p") Optional<Integer> pageNumber, Model model){
        model.addAttribute("nsx",new NSX());
//        model.addAttribute("listch",cuaHangService.getAll());
        Pageable pageable = PageRequest.of(pageNumber.orElse(0),5);
        Page<NSX> page = nsxService.phanTrang(pageable);
        model.addAttribute("page",page);
        model.addAttribute(
                "component",
                "NSX.jsp");
        return "QuanLy";
    }
    @GetMapping("/sanpham/hien-thi")
    public String hienThiSanPham(@RequestParam("p") Optional<Integer> pageNumber, Model model){
        model.addAttribute("sanpham",new SanPham());
//        model.addAttribute("listch",cuaHangService.getAll());
        Pageable pageable = PageRequest.of(pageNumber.orElse(0),5);
        Page<SanPham> page = sanPhamService.phanTrang(pageable);
        model.addAttribute("page",page);
        model.addAttribute(
                "component",
                "SanPham.jsp");
        return "QuanLy";
    }
    @GetMapping("/khach-hang/hien-thi")
    public String hienThiKhachang(@RequestParam("p") Optional<Integer> pageNumber, Model model){
        model.addAttribute("khachhang",new KhachHang());
//        model.addAttribute("listch",cuaHangService.getAll());
        Pageable pageable = PageRequest.of(pageNumber.orElse(0),5);
        Page<KhachHang> page = khachHangService.phanTrang(pageable);
        model.addAttribute("page",page);
        model.addAttribute(
                "component",
                "KhachHang.jsp");
        return "QuanLy";
    }

    @GetMapping("/ban-hang")
    public String fromBH(@RequestParam("p") Optional<Integer> pageNumber,Model model){
        Pageable pageable = PageRequest.of(pageNumber.orElse(0),3);
        Page<HoaDon> hoaDonPage = hoaDonService.findAll(pageable);
        Page<ChiTietSanPham> sanPhamCTPage = ctspService.findAll(pageable);
        model.addAttribute("pageHoaDon",hoaDonPage);
        model.addAttribute("pagectsp",sanPhamCTPage);
        model.addAttribute(
                "component",
                "BanHang.jsp");
        return "QuanLy";
    }

}
