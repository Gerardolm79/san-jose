/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sanjose.web.app.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author GLM
 */
@Entity
@Table(name="PURCHASES")
public class Purchase implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="ORDER_DATE")
    private Date orderDate;

    private String observations;

    private Double total;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="PROVIDER_ID")
    private Provider provider;

    @OneToMany(mappedBy = "purchase", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PurchaseItem> purchaseItems;

    public Purchase(){
        this.purchaseItems = new ArrayList<>();
    }


    public Long getId() {
        return id;
    }

    @JsonBackReference
    public Provider getProvider() {
        return provider;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public String getObservations() {
        return observations;
    }

    public Double getTotal() {
        return total;
    }

    public List<PurchaseItem> getPurchaseItems(){
        return purchaseItems;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @JsonManagedReference(value="secondParent")
    public void setPurchaseItems(List<PurchaseItem> purchaseItems){
        this.purchaseItems = purchaseItems;
    }

    @Override
    public String toString() {
        return "Purchase{" + "id=" + id + ", orderDate=" + orderDate + '}';
    }
    
    private static final long serialVersionUID = 1L;    
    
}
