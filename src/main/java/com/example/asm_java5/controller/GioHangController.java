package com.example.asm_java5.controller;

import com.example.asm_java5.entiy.Cart;
import com.example.asm_java5.entiy.ShopingCart;
import com.example.asm_java5.reposistories.GioHangRepo;
import com.example.asm_java5.services.impl.GioHangServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@Controller
public class GioHangController {
    @Autowired
    GioHangServiceImpl gioHangRepo;

    @GetMapping("/gio-hang/hien-thi")
    private String hienThi(Model model){
        model.addAttribute("listGH",gioHangRepo.find("00001").getList());
        return "GioHang";
    }

    @GetMapping("/gio-hang/delete-sp/{id}")
    private String hienThi(@PathVariable UUID id, Model model){
        ShopingCart shopingCart = gioHangRepo.find("00001");
        List<Cart> list = shopingCart.getList();
        for(Cart c : list) {
            if(id.equals(c.getCtsp().getId())){
                list.remove(c);
               shopingCart.setList(list);
            gioHangRepo.add(shopingCart);
            break;
            }
        }
        return "redirect:/gio-hang/hien-thi";
    }

}
