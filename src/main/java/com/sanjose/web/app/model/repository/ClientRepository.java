
package com.sanjose.web.app.model.repository;

import com.sanjose.web.app.model.entity.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import org.springframework.stereotype.Repository;

/**
 *
 * @author GLM
 */
@Repository
public interface ClientRepository extends PagingAndSortingRepository<Client, Long>,
            CrudRepository<Client, Long>{
    
}
