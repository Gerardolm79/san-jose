
package com.sanjose.web.app.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author GLM
 */
@Entity
@Table(name="SALES")
public class Sale implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="ORDER_NUMBER")
    private String orderNumber;
    
    @Column(name="ORDER_DATE")
    private Date orderDate;
    
    @Column(name="DELIVERY_DATE")
    private Date deliveryDate;
            
    private String observations;
    
    @Column(name="DELIVERY_ADDRESS")
    private String deliveryAddress;
    
    private Double total;

    public Long getId() {
        return id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public String getObservations() {
        return observations;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public Double getTotal() {
        return total;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Sale{" + "orderNumber=" + orderNumber + ", orderDate=" + orderDate + ", total=" + total + '}';
    }
    
    private static final long serialVersionUID = 1L; 
}
