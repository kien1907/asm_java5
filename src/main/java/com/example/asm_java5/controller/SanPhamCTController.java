package com.example.asm_java5.controller;

import com.example.asm_java5.entiy.*;
import com.example.asm_java5.reposistories.GioHangRepo;
import com.example.asm_java5.services.*;
import com.example.asm_java5.services.impl.GioHangServiceImpl;
import jakarta.validation.Valid;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.*;

@Controller
public class SanPhamCTController {

    @Autowired
    CtspService ctspService;
    @Autowired
    SanPhamService sanPhamService;
    @Autowired
    MauSacService mauSacService;
    @Autowired
    DongService dongService;
    @Autowired
    HoaDonService hoaDonService;
    @Autowired
    NSXService nsxService;
    @Autowired
    GioHangServiceImpl gioHangRepo;

    @PostMapping("/san-pham-ct/add")
    public String themSanPhamCT(@RequestParam("file") MultipartFile multipartFile) throws Exception {
        List<ChiTietSanPham> list = new ArrayList<>();
        if (!multipartFile.isEmpty()) {
            InputStream inputStream = multipartFile.getInputStream();
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            if (rowIterator.hasNext()) {
                rowIterator.next();
            }
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                String tenSP = row.getCell(0).getStringCellValue();
                SanPham sanPham = this.sanPhamService.findByName(tenSP);
                if (sanPham == null) {
                    Random random = new Random();
                    String ma = "sp" + random.nextInt(1000) + 1;
                    sanPham = SanPham.builder()
                            .ma(ma)
                            .ten(tenSP)
                            .build();
                    this.sanPhamService.saveOrUpdate(sanPham);
                }
                String tenMau = row.getCell(1).getStringCellValue();
                MauSac mauSac = this.mauSacService.findByName(tenMau);
                if (mauSac == null) {
                    Random random = new Random();
                    String ma = "ms" + random.nextInt(1000) + 1;
                    mauSac = MauSac.builder()
                            .ma(ma)
                            .ten(tenMau)
                            .build();
                    this.mauSacService.saveOrUpdate(mauSac);
                }
                String tenDong = row.getCell(2).getStringCellValue();
                Dong dong = this.dongService.findByName(tenDong);
                if (dong == null) {
                    Random random = new Random();
                    String ma = "dong" + random.nextInt(1000) + 1;
                    dong = Dong.builder()
                            .ma(ma)
                            .ten(tenDong)
                            .build();
                    this.dongService.saveOrUpdate(dong);
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
        return "redirect:/san-pham-ct/hien-thi";
    }

    @GetMapping("/san-pham-ct-bh/hien-thi")
    public String fromBH(Model model, @RequestParam("p") Optional<Integer> pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber.orElse(0), 3);
        Page<HoaDon> hoaDonPage = hoaDonService.findAll(pageable);
        model.addAttribute("pageHoaDon", hoaDonPage);
        Page<ChiTietSanPham> sanPhamCTPage = ctspService.findAll(pageable);
        model.addAttribute("pagectsp", sanPhamCTPage);
        model.addAttribute(
                "component",
                "BanHang.jsp");
        ;
        return "QuanLy";
    }

    @GetMapping("/san-pham-ct/detail/{id}")
    public String detailCTSP(@PathVariable UUID id, Model model) {
        ChiTietSanPham chiTietSanPham = ctspService.findById(id);
        model.addAttribute("ctsp", chiTietSanPham);
        model.addAttribute("listDong", dongService.getAll());
        model.addAttribute("listNSX", nsxService.getAll());
        model.addAttribute("listMau", mauSacService.getAll());
        model.addAttribute("listSP", sanPhamService.getAll());
        model.addAttribute("idDong", chiTietSanPham.getDong().getId());
        model.addAttribute("idNsx", chiTietSanPham.getNsx().getId());
        model.addAttribute("idMau", chiTietSanPham.getMauSac().getId());
        model.addAttribute("idSP", chiTietSanPham.getSanPham().getId());
        return "DetailCTSP";
    }

    @PostMapping("/san-pham-ct/update")
    public String update(@RequestParam("idMau") UUID idMau,
                         @RequestParam("idDong") UUID idDong,
                         @RequestParam("idNsx") UUID idNsx,
                         @RequestParam("idSp") UUID idSp,
                         @Valid @ModelAttribute("ctsp") ChiTietSanPham chiTietSanPham,
                         Model model) {
        SanPham sanPham = sanPhamService.findById(idSp);
        Dong dong = dongService.findById(idDong);
        NSX nsx = nsxService.findById(idNsx);
        MauSac mauSac = mauSacService.findById(idMau);
        chiTietSanPham.setSanPham(sanPham);
        chiTietSanPham.setDong(dong);
        chiTietSanPham.setNsx(nsx);
        chiTietSanPham.setMauSac(mauSac);

        ctspService.save(chiTietSanPham);
        System.out.println(chiTietSanPham.toString());
        return "redirect:/san-pham-ct/hien-thi";
    }

    @GetMapping("/san-pham-ct/delete/{id}")
    public String deleteCTSP(@PathVariable UUID id, Model model) {
        ChiTietSanPham chiTietSanPham = ctspService.findById(id);
        ctspService.delete(chiTietSanPham);
        return "redirect:/san-pham-ct/hien-thi";
    }

    @GetMapping("/san-pham-ct/add-cart/{id}")
    public String themVaoGH(@PathVariable UUID id) {
        ShopingCart shopingCart;
        ChiTietSanPham chiTietSanPham = ctspService.findById(id);
        Cart newCart = new Cart(chiTietSanPham, 1);
        if (gioHangRepo.isAlreadyExists("00001")) {
            boolean flag = false;
            shopingCart = gioHangRepo.find("00001");
            List<Cart> copyListCart = shopingCart.getList();
            for (Cart cart : copyListCart ) {
                if (cart.getCtsp().getId().equals(chiTietSanPham.getId())) {
                    cart.setSoLuong(cart.getSoLuong()+1);
                    flag = true;
                }
            }
            if (!flag) {
                copyListCart.add(newCart);
            }
            shopingCart.setList(copyListCart);
            gioHangRepo.add(shopingCart);
            return "redirect:/gio-hang/hien-thi";
        }
        List<Cart> list = new ArrayList<>();
        list.add(newCart);
        shopingCart = new ShopingCart("00001", list);
        gioHangRepo.add(shopingCart);
        return "redirect:/gio-hang/hien-thi";
    }
}
