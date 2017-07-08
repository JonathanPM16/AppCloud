package com.cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.entities.Ofertacotizacion;
import com.cloud.repository.OfertacotizacionRepository;

@Service
public class OfertacotizacionServiceImpl implements OfertacotizacionService {

	@Autowired
	private OfertacotizacionRepository ofertacotizacionRepository;
	
	@Override
	public Ofertacotizacion saveOfertacotizacion(Ofertacotizacion oc) {
		return ofertacotizacionRepository.save(oc);
	}

	@Override
	public Iterable<Ofertacotizacion> listAllOfertacotizacion() {
		return ofertacotizacionRepository.findAll();
	}

	@Override
	public void deleteOfertacotizacion(int idofertacotizacion) {
		ofertacotizacionRepository.delete(idofertacotizacion);
	}

	@Override
	public Ofertacotizacion getByIdofertacotizacion(int idofertacotizacion) {
		return ofertacotizacionRepository.findOne(idofertacotizacion);
	}

}
