package com.cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.entities.Empresa;
import com.cloud.repository.EmpresaRepository;

@Service
public class EmpresaServiceImpl implements EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Override
	public Empresa saveEmpresa(Empresa e) {
		return empresaRepository.save(e);
	}

	@Override
	public Iterable<Empresa> listAllEmpresa() {
		return empresaRepository.findAll();
	}

	@Override
	public void deleteEmpresa(int idempresa) {
		empresaRepository.delete(idempresa);
	}

	@Override
	public Empresa getByIdempresa(int idempresa) {
		return empresaRepository.findOne(idempresa);
	}

}
