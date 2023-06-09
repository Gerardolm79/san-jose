package com.sanjose.web.app.controller;

import com.sanjose.web.app.model.entity.Purchase;
import com.sanjose.web.app.model.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api")
@RestController
public class PurchaseRestController {

    private PurchaseService purchaseSvc;

    @Autowired
    public PurchaseRestController(PurchaseService purchaseService){
        purchaseSvc = purchaseService;
    }

    @GetMapping("/purchases")
    public List<Purchase> listAll(){
        return purchaseSvc.findAll();
    }
}
