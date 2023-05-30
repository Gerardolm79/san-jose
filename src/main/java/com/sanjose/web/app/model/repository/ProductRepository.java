
package com.sanjose.web.app.model.repository;

import com.sanjose.web.app.model.entity.Product;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author GLM
 */
public interface ProductRepository extends PagingAndSortingRepository<Product, Long>,
        CrudRepository<Product, Long>{
    
    public List<Product> findByNameLikeIgnoreCase(String name);
    
     public List<Product> findByCodeLikeIgnoreCase(String code);
     
     public List<Product> findByBrandLikeIgnoreCase(String code);
     
     public List<Product> findByCategoryLikeIgnoreCase(String category);
     
    
}
