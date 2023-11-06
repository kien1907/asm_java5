package com.example.asm_java5.controller;

import com.example.asm_java5.entiy.CuaHang;
import com.example.asm_java5.services.CuaHangService;
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
public class CuaHangController {
    @Autowired
    CuaHangService cuaHangService;

      @PostMapping("/cua-hang/add")
    public String add(@Valid @ModelAttribute("cuahang")CuaHang cuaHang,
                      BindingResult bindingResult,Model model){
          if(bindingResult.hasErrors()){
              model.addAttribute("error",bindingResult.getFieldError());
              model.addAttribute(
                      "component",
                      "CuaHang.jsp");
              return "QuanLy";
          }
          Random random = new Random();
          String ma = "CH"+random.nextInt(1000)+1;
          cuaHang.setId(null);
          cuaHang.setMa(ma);
          cuaHangService.saveOrUpdate(cuaHang);
          return "redirect:/cua-hang/hien-thi";
      }
    @GetMapping("/cua-hang/delete/{id}")
    public String delete(@PathVariable UUID id){
          CuaHang cuaHang = cuaHangService.getOne(id);
        cuaHangService.delete(cuaHang);
        return "redirect:/cua-hang/hien-thi";
    }
    @GetMapping("/cua-hang/detail/{id}")
    public String detail(@PathVariable UUID id,Model model){
        CuaHang cuaHang = cuaHangService.getOne(id);
        model.addAttribute("cuahang",cuaHang);
        model.addAttribute(
                "component",
                "CuaHang.jsp");
        return "QuanLy";
    }
    @PostMapping("/cua-hang/update")
    public String update(@Valid @ModelAttribute("cuahang")CuaHang cuaHang,
                      BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("error",bindingResult.getFieldError());
            model.addAttribute(
                    "component",
                    "CuaHang.jsp");
            return "QuanLy";
        }
        cuaHangService.saveOrUpdate(cuaHang);
        return "redirect:/cua-hang/hien-thi";
    }
}
