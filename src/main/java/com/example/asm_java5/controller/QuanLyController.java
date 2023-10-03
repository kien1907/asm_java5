package com.example.asm_java5.controller;

import com.example.asm_java5.entiy.*;
import com.example.asm_java5.services.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;
import java.util.*;

@Controller
@RequestMapping("/quan-ly")
public class QuanLyController {
    @Autowired
    NhanVienService nhanVienService;
    @Autowired
    CtspService ctspService;
    @Autowired
    SanPhamService sanPhamService;
    @Autowired
    MauSacService mauSacService;
    @Autowired
    DongService dongService;

    private NhanVien nhanVien;
    @GetMapping("/{id}")
    public String hienThi(@PathVariable UUID id, Model model){
        nhanVien = this.nhanVienService.findById(id);
        model.addAttribute(
                "fullName",
                nhanVien.getHo() + " " + nhanVien.getTenDem() + " " + nhanVien.getTen());
        model.addAttribute("login", "Login2.jsp");
        return "QuanLy";
    }

    @GetMapping("/san-pham/hien-thi")
    public String hienThiSanPham(Model model){
        model.addAttribute("login", "Login2.jsp");
        model.addAttribute("listctsp", ctspService.getAll());
        model.addAttribute(
                "fullName",
                nhanVien.getHo() + " " + nhanVien.getTenDem() + " " + nhanVien.getTen());
        model.addAttribute(
                "page",
                "SanPham.jsp");
        return "QuanLy";
    }

    @PostMapping("/san-pham/add")
    public String themSanPham(@RequestParam("file") MultipartFile multipartFile) throws Exception{
        List<ChiTietSanPham> list = new ArrayList<>();
         if (!multipartFile.isEmpty()){
            InputStream inputStream = multipartFile.getInputStream();
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            if (rowIterator.hasNext()){
                rowIterator.next();
            }
            while (rowIterator.hasNext()){
                Row row = rowIterator.next();
                String tenSP = row.getCell(0).getStringCellValue();
                SanPham sanPham = this.sanPhamService.findByName(tenSP);
                if(sanPham==null){
                    Random random = new Random();
                    String ma = "sp"+random.nextInt(1000)+1;
                    sanPham = SanPham.builder()
                            .ma(ma)
                            .ten(tenSP)
                            .build();
                    this.sanPhamService.add(sanPham);
                }
                String tenMau = row.getCell(1).getStringCellValue();
                MauSac mauSac = this.mauSacService.findByName(tenMau);
                if(mauSac==null){
                    Random random = new Random();
                    String ma = "ms"+random.nextInt(1000)+1;
                    mauSac = MauSac.builder()
                            .ma(ma)
                            .ten(tenMau)
                            .build();
                    this.mauSacService.add(mauSac);
                }
                String tenDong = row.getCell(2).getStringCellValue();
                Dong dong = this.dongService.findByName(tenDong);
                if(dong==null){
                    Random random = new Random();
                    String ma = "dong"+random.nextInt(1000)+1;
                    dong = Dong.builder()
                            .ma(ma)
                            .ten(tenDong)
                            .build();
                    this.dongService.add(dong);
                }
                int soLuong = (int) row.getCell(3).getNumericCellValue();
                int namBH = (int) row.getCell(4).getNumericCellValue();
                String moTa = row.getCell(5).getStringCellValue();
                double giaBan = (double) row.getCell(6).getNumericCellValue();
                double giaNhap = (double) row.getCell(7).getNumericCellValue();
                String anh = row.getCell(8).getStringCellValue();
                ChiTietSanPham chiTietSanPham = ChiTietSanPham.builder()
                        .sanPham(sanPham)
                        .mauSac(mauSac)
                        .dong(dong)
                        .soLuongTon(soLuong)
                        .namBh(namBH)
                        .moTa(moTa)
                        .giaBan(giaBan)
                        .giaNhap(giaNhap)
                        .anh(anh)
                        .build();
                list.add(chiTietSanPham);
            }
            this.ctspService.saveAll(list);
        }
        return "redirect:/quan-ly/san-pham/hien-thi";
    }
}
