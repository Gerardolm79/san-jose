package com.sanjose.web.app.controller;

import com.sanjose.web.app.model.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/purchases")
@Controller
public class PurchaseController {

    private PurchaseService purchaseSvc;

    @Autowired
    public PurchaseController(PurchaseService purchaseService){
        purchaseSvc = purchaseService;
    }

    @GetMapping("/listAll")
    public String findAll(Model model){

        model.addAttribute("title", "Lista de compras");
        model.addAttribute("purchases", purchaseSvc.findAll());
        return "purchase/listAll";

    }


}
