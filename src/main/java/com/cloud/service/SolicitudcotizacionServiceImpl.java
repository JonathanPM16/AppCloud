package com.cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.entities.Solicitudcotizacion;
import com.cloud.repository.SolicitudcotizacionRepository;

@Service
public class SolicitudcotizacionServiceImpl implements SolicitudcotizacionService {

	@Autowired
	private SolicitudcotizacionRepository solicitudcotizacionRepository;
	
	@Override
	public Solicitudcotizacion saveSolicitudcotizacion(Solicitudcotizacion sc) {
		return solicitudcotizacionRepository.save(sc);
	}

	@Override
	public Iterable<Solicitudcotizacion> listAllSolicitudcotizacion() {
		return solicitudcotizacionRepository.findAll();
	}

	@Override
	public void deleteSolicitudcotizacion(int idsolicitudcotizacion) {
		solicitudcotizacionRepository.delete(idsolicitudcotizacion);
	}

	@Override
	public Solicitudcotizacion getByIdsolicitudcotizacion(int idsolicitudcotizacion) {
		return solicitudcotizacionRepository.findOne(idsolicitudcotizacion);
	}

}
