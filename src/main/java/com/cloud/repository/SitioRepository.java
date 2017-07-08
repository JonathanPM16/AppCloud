package com.cloud.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cloud.entities.Sitio;

@Repository
@Transactional
public interface SitioRepository extends CrudRepository<Sitio, Integer>{

}
