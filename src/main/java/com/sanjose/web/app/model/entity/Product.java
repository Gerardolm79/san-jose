/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sanjose.web.app.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author GLM
 */
@Entity
@Table(name= "PRODUCTS")
public class Product implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String name;
    
    private String brand;

    private String description;

    private String category;

    private Double price;

    private Integer existences;
    
    private String unit;
    
    private Integer min;
    

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }
    
    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getExistences() {
        if(existences==null){
            existences = 0;
        }
        return existences;
    }

    public String getUnit() {
        if(unit==null){
            unit = "";
        }
        return unit;
    }
    
    public Integer getMin(){
        if(min==null){
            min = 0;
        }
        return min;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setExistences(Integer existences) {
        this.existences = existences;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
    
    public void setMin(Integer min){
        this.min = min;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", code=" + code + ", price=" + price + '}';
    }
        
    private static final long serialVersionUID = 1L;    
        
}
