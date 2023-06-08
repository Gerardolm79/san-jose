package com.sanjose.web.app.model.service;

import com.sanjose.web.app.model.entity.Provider;
import com.sanjose.web.app.model.repository.ProviderRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderServiceImpl implements ProviderService{

    ProviderRespository providerRepo;

    @Autowired
    public ProviderServiceImpl(ProviderRespository providerRepository){
        providerRepo = providerRepository;
    }
    @Override
    public List<Provider> findAll() {
        return (List<Provider>) providerRepo.findAll();
    }
}
