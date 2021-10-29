package com.mycode.catalogservice.repositories;

import com.mycode.catalogservice.data.CatalogEntity;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@EnableScan
public interface CatalogCrudRepository extends CrudRepository<CatalogEntity, Long> {

}
