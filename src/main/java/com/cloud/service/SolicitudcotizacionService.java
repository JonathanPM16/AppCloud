package com.cloud.service;

import com.cloud.entities.Solicitudcotizacion;

public interface SolicitudcotizacionService {

	Solicitudcotizacion saveSolicitudcotizacion(Solicitudcotizacion sc);
	Iterable<Solicitudcotizacion> listAllSolicitudcotizacion();
	void deleteSolicitudcotizacion(int idsolicitudcotizacion);
	Solicitudcotizacion getByIdsolicitudcotizacion(int idsolicitudcotizacion);
}
