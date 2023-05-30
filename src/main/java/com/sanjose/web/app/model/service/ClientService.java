
package com.sanjose.web.app.model.service;

import com.sanjose.web.app.model.entity.Client;
import java.util.List;
import org.springframework.data.domain.Page;

/**
 *
 * @author GLM
 */
public interface ClientService {
    
    List<Client> findAll();
    
    Page<Client> findAll(int page, int size, String sort);
    
    
    Page<Client> findAll(int page, int size, String sort, String sortDirection);
    
    Client findById(Long id);
}
