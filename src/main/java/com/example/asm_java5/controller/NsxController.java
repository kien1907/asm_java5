package com.example.asm_java5.controller;

import com.example.asm_java5.entiy.MauSac;
import com.example.asm_java5.entiy.NSX;
import com.example.asm_java5.services.MauSacService;
import com.example.asm_java5.services.NSXService;
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
public class NsxController {
    @Autowired
    NSXService nsxService;
    @PostMapping("/nsx/add")
    public String add(@Valid @ModelAttribute("nsx") NSX nsx,
                      BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("error",bindingResult.getFieldError());
            model.addAttribute(
                    "component",
                    "NSX.jsp");
            return "QuanLy";
        }
        Random random = new Random();
        String ma = "NSX"+random.nextInt(1000)+1;
        nsx.setId(null);
        nsx.setMa(ma);
        nsxService.saveOrUpdate(nsx);
        return "redirect:/nsx/hien-thi";
    }
    @GetMapping("/nsx/delete/{id}")
    public String delete(@PathVariable UUID id){
        NSX nsx = nsxService.findById(id);
        nsxService.delete(nsx);
        return "redirect:/nsx/hien-thi";
    }
    @GetMapping("/nsx/detail/{id}")
    public String detail(@PathVariable UUID id,Model model){
        NSX nsx = nsxService.findById(id);
        model.addAttribute("nsx",nsx);
        model.addAttribute(
                "component",
                "NSX.jsp");
        return "QuanLy";
    }
    @PostMapping("/nsx/update")
    public String update(@Valid @ModelAttribute("nsx")NSX nsx,
                         BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("error",bindingResult.getFieldError());
            model.addAttribute(
                    "component",
                    "NSX.jsp");
            return "QuanLy";
        }
        nsxService.saveOrUpdate(nsx);
        return "redirect:/nsx/hien-thi";
    }
}
