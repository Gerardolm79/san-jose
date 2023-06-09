package com.sanjose.web.app.model.service;

import com.sanjose.web.app.model.entity.Purchase;
import com.sanjose.web.app.model.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    private PurchaseRepository purchaseRepo;

    @Autowired
    public PurchaseServiceImpl(PurchaseRepository purchaseRepository){
        purchaseRepo = purchaseRepository;
    }

    @Override
    public List<Purchase> findAll() {
        return (List<Purchase>) purchaseRepo.findAll();
    }
}
