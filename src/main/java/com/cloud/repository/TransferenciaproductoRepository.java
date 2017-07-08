package com.cloud.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cloud.entities.Transferenciaproducto;

@Repository
@Transactional
public interface TransferenciaproductoRepository extends CrudRepository<Transferenciaproducto, Integer>{

}
