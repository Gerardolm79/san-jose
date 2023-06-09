package com.sanjose.web.app.controller;

import com.sanjose.web.app.model.entity.Provider;
import com.sanjose.web.app.model.service.ProviderService;
import org.apache.catalina.authenticator.jaspic.PersistentProviderRegistrations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api")
@RestController
public class ProviderRestController {

    private ProviderService providerSvc;

    @Autowired
    public ProviderRestController(ProviderService providerService){
        providerSvc = providerService;
    }

    @GetMapping("/providers")
    public List<Provider> findAll(){
        return (List<Provider>)providerSvc.findAll();
    }

}
