package com.sanjose.web.app.model.repository;

import com.sanjose.web.app.model.entity.Purchase;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


@Repository
public interface PurchaseRepository extends PagingAndSortingRepository<Purchase, Long>,
        CrudRepository<Purchase, Long>{

}
