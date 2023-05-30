/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sanjose.web.app.controller;

import com.sanjose.web.app.model.entity.Product;
import com.sanjose.web.app.model.service.ProductService;
import java.util.List;
import java.util.Map;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author GLM
 */
@RequestMapping("/inventory")
@Controller
public class InventoryController {
    
    private ProductService productSvc;
    
    public InventoryController(ProductService productService){
        productSvc = productService;
    }
    
    @GetMapping(value="/listAll")
    public String findAll(@RequestParam(name = "name", defaultValue="") String name,
            @RequestParam(name = "code", defaultValue="") String code,
            @RequestParam(name = "brand", defaultValue="") String brand,
            @RequestParam(name = "category", defaultValue="") String category,
            @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "size", defaultValue = "10") int size,
            @RequestParam(name = "sortField", defaultValue = "name") String sort,
            @RequestParam(name = "sortDir", defaultValue = "asc") String sortDir,
            Model model){
        
        model.addAttribute("title", "Inventario");
        
        
        if(name.trim().length()>0){
            model.addAttribute("products", productSvc.findByName(name));
        }else if(code.trim().length()>0){
            
            model.addAttribute("products", productSvc.findByCode(code));
        }else if(brand.trim().length()>0){
            
            model.addAttribute("products", productSvc.findByBrand(brand));
        }else if(category.trim().length()>0){
            
            model.addAttribute("products", productSvc.findByCategory(category));
        }else{
            
            Page<Product> paging = productSvc.findAll(page-1, size, sort, sortDir);
            
            model.addAttribute("products", paging.getContent());
            model.addAttribute("totalPages", paging.getTotalPages());
            model.addAttribute("totalItems", paging.getTotalElements());
            model.addAttribute("currentPage", page);

            model.addAttribute("sortField", sort);
            model.addAttribute("sortDir", sortDir);
            model.addAttribute("reverseSortDir", sortDir.equals("asc")?"desc":"asc");
        }
        return "inventory/listAll";
    }
    
    
}
