package com.cloud.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cloud.entities.Ofertacotizacion;

@Repository
@Transactional
public interface OfertacotizacionRepository extends CrudRepository<Ofertacotizacion, Integer>{

}
