/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sanjose.web.app.model.service;

import com.sanjose.web.app.model.entity.Product;
import com.sanjose.web.app.model.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author GLM
 */
@Service
public class ProductServiceImpl implements ProductService{

    ProductRepository productRepo;
    
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){
        productRepo = productRepository;
    }
    
    @Override
    public List<Product> findAll() {
        return (List)productRepo.findAll();
    }
    
    @Override
    public Page<Product> findAll(int page, int size, String sort, String sortDirection) {
        Sort sorting = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sort).ascending():
                Sort.by(sort).descending();
        Pageable paging = PageRequest.of(page, size, sorting);
        return productRepo.findAll(paging);
    }

    @Override
    public Product findById(Long id) {
        return productRepo.findById(id).orElse(null);
    }

    @Override
    public List<Product> findByName(String name) {
        
        return productRepo.findByNameLikeIgnoreCase("%" + name + "%");
    }

    @Override
    public List<Product> findByCode(String code) {
        
        return productRepo.findByCodeLikeIgnoreCase("%" + code + "%");
    }
    
    
    @Override
    public List<Product> findByBrand(String brand) {
        
        return productRepo.findByBrandLikeIgnoreCase("%" + brand + "%");
    }

    @Override
    public List<Product> findByCategory(String category) {
        
        return productRepo.findByCategoryLikeIgnoreCase("%" + category + "%");
    }
    
    
}
