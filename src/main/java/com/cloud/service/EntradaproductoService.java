package com.cloud.service;

import com.cloud.entities.Entradaproducto;

public interface EntradaproductoService {

	Entradaproducto saveEntradaproducto(Entradaproducto ep);
	Iterable<Entradaproducto> listAllEntradaproducto();
	void deleteEntradaproducto(int identradaproducto);
	Entradaproducto getByIdentradaproducto(int identradaproducto);
}
