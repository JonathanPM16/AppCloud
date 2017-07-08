package com.cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.entities.Productositio;
import com.cloud.repository.ProductositioRepository;

@Service
public class ProductositioServiceImpl implements ProductositioService {

	@Autowired
	private ProductositioRepository productositioRepository;
	
	@Override
	public Productositio saveProductositio(Productositio ps) {
		return productositioRepository.save(ps);
	}

	@Override
	public Iterable<Productositio> listAllProductositio() {
		return productositioRepository.findAll();
	}

	@Override
	public void deleteProductositio(int idproductositio) {
		productositioRepository.delete(idproductositio);
	}

	@Override
	public Productositio getByIdproductositio(int idproductositio) {
		return productositioRepository.findOne(idproductositio);
	}

}
