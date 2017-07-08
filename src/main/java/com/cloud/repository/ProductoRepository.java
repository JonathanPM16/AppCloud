package com.cloud.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cloud.entities.Producto;

@Repository
@Transactional
public interface ProductoRepository extends CrudRepository<Producto, Integer>{

}
