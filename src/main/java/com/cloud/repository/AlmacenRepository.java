package com.cloud.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cloud.entities.Almacen;

@Repository
@Transactional
public interface AlmacenRepository extends CrudRepository<Almacen, Integer>{

}
