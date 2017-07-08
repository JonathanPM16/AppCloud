package com.cloud.service;

import com.cloud.entities.Tipoproducto;

public interface TipoproductoService {

	Tipoproducto saveTipoproducto(Tipoproducto tp);
	Iterable<Tipoproducto> listAllTipoproducto();
	void deleteTipoproducto(int idtipoproducto);
	Tipoproducto getByIdtipoproducto(int idtipoproducto);
}
