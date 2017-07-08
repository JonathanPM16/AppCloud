package com.cloud.service;

import com.cloud.entities.Sitio;

public interface SitioService {

	Sitio saveSitio(Sitio s);
	Iterable<Sitio> listAllSitio();
	void deleteSitio(int idsitio);
	Sitio getByIdsitio(int idsitio);
}
