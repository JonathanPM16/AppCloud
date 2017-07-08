package com.cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.entities.Sitio;
import com.cloud.repository.SitioRepository;

@Service
public class SitioServiceImpl implements SitioService {

	@Autowired
	private SitioRepository sitioRepository;
	
	@Override
	public Sitio saveSitio(Sitio s) {
		return sitioRepository.save(s);
	}

	@Override
	public Iterable<Sitio> listAllSitio() {
		return sitioRepository.findAll();
	}

	@Override
	public void deleteSitio(int idsitio) {
		sitioRepository.delete(idsitio);
	}

	@Override
	public Sitio getByIdsitio(int idsitio) {
		return sitioRepository.findOne(idsitio);
	}

}
