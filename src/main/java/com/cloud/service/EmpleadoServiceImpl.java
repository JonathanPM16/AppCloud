package com.cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cloud.entities.Empleado;
import com.cloud.repository.EmpleadoRepository;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	private BCryptPasswordEncoder passencoder = new BCryptPasswordEncoder();
	
	@Override
	public Empleado saveEmpleado(Empleado e) {
		
		String nuevopassword = passencoder.encode(e.getPassword());
		e.setPassword(nuevopassword);
		return empleadoRepository.save(e);
	}

	@Override
	public Iterable<Empleado> listAllEmpleado() {
		return empleadoRepository.findAll();
	}

	@Override
	public void deleteEmpleado(int idempleado) {
		empleadoRepository.delete(idempleado);
	}

	@Override
	public Empleado getByIdempleado(int idempleado) {
		return empleadoRepository.findOne(idempleado);
	}
	
	@Override
	public Empleado autenticarEmpleado(String usuario, String password) {
		Empleado empleado = empleadoRepository.findByUsuario(usuario);
		if (empleado!=null && passencoder.matches(password, empleado.getPassword()) ) {
			return empleado;
		}
		return null;
	}

}
