package com.cloud.service;

import com.cloud.entities.Salidaproducto;

public interface SalidaproductoService {

	Salidaproducto saveSalidaproducto(Salidaproducto sp);
	Iterable<Salidaproducto> listAllSalidaproducto();
	void deleteSalidaproducto(int salidaproducto);
	Salidaproducto getByIdsalidaproducto(int idsalidaproducto);
}
