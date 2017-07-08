package com.cloud.service;

import com.cloud.entities.Ofertacotizacion;

public interface OfertacotizacionService {

	Ofertacotizacion saveOfertacotizacion(Ofertacotizacion oc);
	Iterable<Ofertacotizacion> listAllOfertacotizacion();
	void deleteOfertacotizacion(int idofertacotizacion);
	Ofertacotizacion getByIdofertacotizacion(int idofertacotizacion);
}
