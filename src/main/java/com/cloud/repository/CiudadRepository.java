package com.cloud.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cloud.entities.Ciudad;

@Repository
@Transactional
public interface CiudadRepository extends CrudRepository<Ciudad, Integer>{

}
