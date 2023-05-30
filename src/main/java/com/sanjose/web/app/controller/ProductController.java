
package com.sanjose.web.app.controller;

import com.sanjose.web.app.model.entity.Product;
import com.sanjose.web.app.model.service.ProductService;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author GLM
 */
@RequestMapping("/products")
@Controller
public class ProductController {
    
    private ProductService productSvc;
    
    public ProductController(ProductService productService){
        productSvc = productService;
    }
    
    @GetMapping(value="/listAll")
    public String findAll(Model model){
        
        model.addAttribute("title", "Lista de productos");
        model.addAttribute("products", productSvc.findAll());
        
        return "product/listAll";
    }
    
    @GetMapping(value="/detail/{id}")
    public String findById(@PathVariable(value="id") Long id, 
            Map<String, Object> model, 
            RedirectAttributes flash){
        
        Product product = productSvc.findById(id);
        if(product==null){
            flash.addAttribute("error", "No se encontraron datos del producto " + id);
            return "redirect:/product/listAll";
        }
        model.put("product", product);
        model.put("title", "Product " + id + "-" + product.getCode());
        
        return "product/form";
    }
}