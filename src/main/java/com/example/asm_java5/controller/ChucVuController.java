package com.example.asm_java5.controller;

import com.example.asm_java5.entiy.ChucVu;
import com.example.asm_java5.entiy.CuaHang;
import com.example.asm_java5.services.ChucVuService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
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
public class ChucVuController {
    @Autowired
    ChucVuService chucVuService;
    @PostMapping("/chuc-vu/add")
    public String add(@Valid @ModelAttribute("chucvu") ChucVu chucVu,
                      BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("error",bindingResult.getFieldError());
            model.addAttribute(
                    "component",
                    "ChucVu.jsp");
            return "QuanLy";
        }
        Random random = new Random();
        String ma = "CH"+random.nextInt(1000)+1;
        chucVu.setId(null);
        chucVu.setMa(ma);
        chucVuService.saveOrUpdate(chucVu);
        return "redirect:/chuc-vu/hien-thi";
    }
    @GetMapping("/chuc-vu/delete/{id}")
    public String delete(@PathVariable UUID id){
        ChucVu chucVu = chucVuService.getOne(id);
        chucVuService.delete(chucVu);
        return "redirect:/chuc-vu/hien-thi";
    }
    @GetMapping("/chuc-vu/detail/{id}")
    public String detail(@PathVariable UUID id,Model model){
        ChucVu chucVu = chucVuService.getOne(id);
        model.addAttribute("chucvu",chucVu);
        model.addAttribute(
                "component",
                "ChucVu.jsp");
        return "QuanLy";
    }
    @PostMapping("/chuc-vu/update")
    public String update(@Valid @ModelAttribute("chucvu")ChucVu chucVu,
                         BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("error",bindingResult.getFieldError());
            model.addAttribute(
                    "component",
                    "ChucVu.jsp");
            return "QuanLy";
        }
        chucVuService.saveOrUpdate(chucVu);
        return "redirect:/chuc-vu/hien-thi";
    }
}
