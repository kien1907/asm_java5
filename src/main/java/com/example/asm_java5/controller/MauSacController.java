package com.example.asm_java5.controller;

import com.example.asm_java5.entiy.Dong;
import com.example.asm_java5.entiy.MauSac;
import com.example.asm_java5.services.DongService;
import com.example.asm_java5.services.MauSacService;
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
public class MauSacController {
    @Autowired
    MauSacService mauSacService;
    @PostMapping("/mau-sac/add")
    public String add(@Valid @ModelAttribute("mausac") MauSac mauSac,
                      BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("error",bindingResult.getFieldError());
            model.addAttribute(
                    "component",
                    "MauSac.jsp");
            return "QuanLy";
        }
        Random random = new Random();
        String ma = "CH"+random.nextInt(1000)+1;
        mauSac.setId(null);
        mauSac.setMa(ma);
        mauSacService.saveOrUpdate(mauSac);
        return "redirect:/mau-sac/hien-thi";
    }
    @GetMapping("/mau-sac/delete/{id}")
    public String delete(@PathVariable UUID id){
        MauSac mauSac = mauSacService.findById(id);
        mauSacService.delete(mauSac);
        return "redirect:/mau-sac/hien-thi";
    }
    @GetMapping("/mau-sac/detail/{id}")
    public String detail(@PathVariable UUID id,Model model){
        MauSac mauSac = mauSacService.findById(id);
        model.addAttribute("mausac",mauSac);
        model.addAttribute(
                "component",
                "MauSac.jsp");
        return "QuanLy";
    }
    @PostMapping("/mau-sac/update")
    public String update(@Valid @ModelAttribute("mausac")MauSac mauSac,
                         BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("error",bindingResult.getFieldError());
            model.addAttribute(
                    "component",
                    "MauSac.jsp");
            return "QuanLy";
        }
        mauSacService.saveOrUpdate(mauSac);
        return "redirect:/mau-sac/hien-thi";
    }
}
