package com.sanjose.web.app.controller;

import com.sanjose.web.app.model.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequestMapping("/providers")
@Controller
public class ProviderController {

    private ProviderService providerSvc;

    @Autowired
    public ProviderController(ProviderService providerService){
        providerSvc = providerService;
    }

    @GetMapping("/listAll")
    public String listAll(Model model){
        model.addAttribute("title", "Lista de proveedores");
        model.addAttribute("providers", providerSvc.findAll());
        return "provider/listAll";
    }
}
