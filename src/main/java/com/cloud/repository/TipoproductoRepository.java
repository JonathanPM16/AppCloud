package com.cloud.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cloud.entities.Tipoproducto;

@Repository
@Transactional
public interface TipoproductoRepository extends CrudRepository<Tipoproducto, Integer>{

}
