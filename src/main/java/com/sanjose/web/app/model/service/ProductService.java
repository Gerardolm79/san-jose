/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sanjose.web.app.model.service;

import com.sanjose.web.app.model.entity.Client;
import com.sanjose.web.app.model.entity.Product;
import java.util.List;
import org.springframework.data.domain.Page;

/**
 *
 * @author GLM
 */
public interface ProductService {
    
    List<Product> findAll();
    
    Page<Product> findAll(int page, int size, String sort, String sortDirection);
    
    Product findById(Long id);
    
    List<Product> findByName(String name);
    
    List<Product> findByCode(String code);
    
    List<Product> findByBrand(String brand);
    
    List<Product> findByCategory(String category);
    
}
