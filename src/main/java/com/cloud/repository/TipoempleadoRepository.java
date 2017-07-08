package com.cloud.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cloud.entities.Tipoempleado;

@Repository
@Transactional
public interface TipoempleadoRepository extends CrudRepository<Tipoempleado, Integer>{

}
