package com.example.asm_java5.controller;

import com.example.asm_java5.entiy.ChucVu;
import com.example.asm_java5.entiy.Dong;
import com.example.asm_java5.services.ChucVuService;
import com.example.asm_java5.services.DongService;
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
public class DongController {
    @Autowired
    DongService dongService;
    @PostMapping("/dong/add")
    public String add(@Valid @ModelAttribute("dong")Dong dong,
                      BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("error",bindingResult.getFieldError());
            model.addAttribute(
                    "component",
                    "Dong.jsp");
            return "QuanLy";
        }
        Random random = new Random();
        String ma = "CH"+random.nextInt(1000)+1;
        dong.setId(null);
        dong.setMa(ma);
        dongService.saveOrUpdate(dong);
        return "redirect:/dong/hien-thi";
    }
    @GetMapping("/dong/delete/{id}")
    public String delete(@PathVariable UUID id){
        Dong dong = dongService.findById(id);
        dongService.delete(dong);
        return "redirect:/dong/hien-thi";
    }
    @GetMapping("/dong/detail/{id}")
    public String detail(@PathVariable UUID id,Model model){
        Dong dong = dongService.findById(id);
        model.addAttribute("dong",dong);
        model.addAttribute(
                "component",
                "Dong.jsp");
        return "QuanLy";
    }
    @PostMapping("/dong/update")
    public String update(@Valid @ModelAttribute("dong")Dong dong,
                         BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("error",bindingResult.getFieldError());
            model.addAttribute(
                    "component",
                    "Dong.jsp");
            return "QuanLy";
        }
        dongService.saveOrUpdate(dong);
        return "redirect:/dong/hien-thi";
    }
}
