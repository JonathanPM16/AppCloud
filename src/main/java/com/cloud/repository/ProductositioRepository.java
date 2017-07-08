package com.cloud.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cloud.entities.Productositio;

@Repository
@Transactional
public interface ProductositioRepository extends CrudRepository<Productositio, Integer>{

}
