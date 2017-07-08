package com.cloud.service;

import com.cloud.entities.Empleado;

public interface EmpleadoService {

	Empleado saveEmpleado(Empleado e);
	Iterable<Empleado> listAllEmpleado();
	void deleteEmpleado(int idempleado);
	Empleado getByIdempleado(int idempleado);
	Empleado autenticarEmpleado(String usuario, String password);
}
