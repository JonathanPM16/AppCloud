package com.cloud.service;

import com.cloud.entities.Productositio;

public interface ProductositioService {

	Productositio saveProductositio(Productositio ps);
	Iterable<Productositio> listAllProductositio();
	void deleteProductositio(int idproductositio);
	Productositio getByIdproductositio(int idproductositio);
}
