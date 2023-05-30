/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sanjose.web.app.controller;

import com.sanjose.web.app.model.entity.Product;
import com.sanjose.web.app.model.service.ProductService;
import java.util.List;
import java.util.Map;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author GLM
 */

@RestController
@RequestMapping("/api")
public class ProductRestController {
    
    private ProductService productSvc;
    
    public ProductRestController(ProductService productService){
        productSvc = productService;
    }
    
    
    @GetMapping(value="/products")
    public List<Product> findAll(){
        
        return productSvc.findAll();
    }
    
    @GetMapping(value="/products/{id}")
    public Product findById(@PathVariable(value="id") Long id){
        
        Product product = productSvc.findById(id);
        if(product==null){
            
            
        }
        
        return product;
    }
    
}
