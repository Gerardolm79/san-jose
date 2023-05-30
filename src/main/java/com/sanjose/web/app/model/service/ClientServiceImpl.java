
package com.sanjose.web.app.model.service;

import com.sanjose.web.app.model.entity.Client;
import com.sanjose.web.app.model.repository.ClientRepository;
import java.util.List;

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
public class ClientServiceImpl implements ClientService{

    ClientRepository clientRepo;
    
    public ClientServiceImpl(ClientRepository clientRepository){
        clientRepo = clientRepository;
    }
    
    @Override
    public List<Client> findAll() {
        
        return (List)clientRepo.findAll();
    }
    
    @Override
    public Page<Client> findAll(int page, int size, String sort) {
        
        Pageable paging = PageRequest.of(page, size, Sort.by(sort));
        return clientRepo.findAll(paging);
    }
    
    @Override
    public Page<Client> findAll(int page, int size, String sort, String sortDirection) {
        Sort sorting = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sort).ascending():
                Sort.by(sort).descending();
        Pageable paging = PageRequest.of(page, size, sorting);
        return clientRepo.findAll(paging);
    }
    

    @Override
    public Client findById(Long id) {
        return clientRepo.findById(id).orElse(null);
    }
    
}
