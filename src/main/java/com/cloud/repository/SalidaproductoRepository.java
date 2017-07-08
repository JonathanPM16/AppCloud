package com.cloud.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cloud.entities.Salidaproducto;

@Repository
@Transactional
public interface SalidaproductoRepository extends CrudRepository<Salidaproducto, Integer>{

}
