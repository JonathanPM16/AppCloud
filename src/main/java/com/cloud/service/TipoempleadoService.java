package com.cloud.service;

import com.cloud.entities.Tipoempleado;

public interface TipoempleadoService {

	Tipoempleado saveTipoempleado(Tipoempleado te);
	Iterable<Tipoempleado> listAllTipoempleado();
	void deleteTipoempleado(int idtipoempleado);
	Tipoempleado getByIdtipoempleado(int idtipoempleado);
}
