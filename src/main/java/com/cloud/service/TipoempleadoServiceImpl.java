package com.cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.entities.Tipoempleado;
import com.cloud.repository.TipoempleadoRepository;

@Service
public class TipoempleadoServiceImpl implements TipoempleadoService {

	@Autowired
	private TipoempleadoRepository tipoempleadoRepository;
	
	@Override
	public Tipoempleado saveTipoempleado(Tipoempleado te) {
		return tipoempleadoRepository.save(te);
	}

	@Override
	public Iterable<Tipoempleado> listAllTipoempleado() {
		return tipoempleadoRepository.findAll();
	}

	@Override
	public void deleteTipoempleado(int idtipoempleado) {
		tipoempleadoRepository.delete(idtipoempleado);
	}

	@Override
	public Tipoempleado getByIdtipoempleado(int idtipoempleado) {
		return tipoempleadoRepository.findOne(idtipoempleado);
	}

}
