package com.sanjose.web.app.model.repository;

import com.sanjose.web.app.model.entity.Provider;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRespository extends CrudRepository<Provider, Long> {

}
