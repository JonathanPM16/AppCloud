package com.cloud.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cloud.entities.Solicitudcotizacion;

@Repository
@Transactional
public interface SolicitudcotizacionRepository extends CrudRepository<Solicitudcotizacion, Integer>{

}
