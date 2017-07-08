package com.cloud.service;

import com.cloud.entities.Transferenciaproducto;

public interface TransferenciaproductoService {

	Transferenciaproducto saveTransferenciaproducto(Transferenciaproducto tp);
	Iterable<Transferenciaproducto> listAllTransferenciaproducto();
	void deleteTransferenciaproducto(int idtransferenciaproducto);
	Transferenciaproducto getByIdtransferenciaproducto(int idtransferenciaproducto);
}
