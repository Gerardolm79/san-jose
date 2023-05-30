
package com.sanjose.web.app.controller;

import com.sanjose.web.app.model.entity.Client;
import com.sanjose.web.app.model.service.ClientService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author GLM
 */
@RestController
@RequestMapping("/api")
public class ClientRestController {
    
    private final ClientService clientSvc;
    
    @Autowired
    public ClientRestController(ClientService clientService){
        clientSvc = clientService;
    }
    
    @GetMapping(value = "/clients")
    public List<Client> findAll(){
        
        List<Client> clients = clientSvc.findAll();
        
        return clients;
    }
    
    
    @GetMapping(value = "/clients/{id}")
    public Client findById(@PathVariable (value="id") Long id){
        
        Client client = clientSvc.findById(id);
        
        return client;
    }
    
}
