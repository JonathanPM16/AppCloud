package com.cloud.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cloud.entities.Entradaproducto;

@Repository
@Transactional
public interface EntradaproductoRepository extends CrudRepository<Entradaproducto, Integer>{

}
