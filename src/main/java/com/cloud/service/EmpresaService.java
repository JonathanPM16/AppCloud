package com.cloud.service;

import com.cloud.entities.Empresa;

public interface EmpresaService {
	
	Empresa saveEmpresa(Empresa e);
	Iterable<Empresa> listAllEmpresa();
	void deleteEmpresa(int idempresa);
	Empresa getByIdempresa(int idempresa);
}
