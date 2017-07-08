package com.cloud.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cloud.entities.Productositio;
import com.cloud.service.ProductositioService;

@Controller
public class ProductositioController {

	@Autowired
	private ProductositioService productositioService;
	
	@RequestMapping(value="/newProductositio")
	public String Productositios(Model model){
		model.addAttribute("productositio", new Productositio());
		model.addAttribute("productositios",productositioService.listAllProductositio());
		return "newProductositio";
	}
	
	@RequestMapping(value="/productositio/new", method=RequestMethod.POST) //HOME
	public String saveProductositio(@Valid Productositio ps, BindingResult result, Model model){
		try 
		{
			if(result.hasErrors()){
				model.addAttribute("message",result.toString());
				return "newProductositio";
			}
			productositioService.saveProductositio(ps);
			model.addAttribute("message", "Producto(s) en Sitio guardado satisfactoriamente.");
			model.addAttribute("productositios",productositioService.listAllProductositio());
			return "newProductositio";
		} 
		catch (Exception e) 
		{
			model.addAttribute("message", e.getMessage());
			return "newProductositio";
		}
	}
	
	@RequestMapping(value="/productositios")
	public String listarProductositios(Model model){
		model.addAttribute("productositios",productositioService.listAllProductositio());
		return "productositios";
	}

	@RequestMapping( value="/deleteproductositio{id}")
	public String deleteProductositio(@PathVariable int id, Model model)
	{
		try
		{
			productositioService.deleteProductositio(id);
			return"redirect:/newProductositio";
		}
		catch (Exception e)
		{
			model.addAttribute("message", "ERROR: No se puede eliminar un ENTIDAD que está incluido dentro de alguna ENTIDAD.");
			model.addAttribute("productositio", new Productositio());
			model.addAttribute("productositios",productositioService.listAllProductositio());
			return "newProductositio";
		}
	}
	
	@RequestMapping(value="/editarProductositio{idproductositio}",method=RequestMethod.GET)
	public String editarProductositio(@PathVariable int idproductositio,Model model)
	{
		model.addAttribute("productositio", productositioService.getByIdproductositio(idproductositio));
		return "editarProductositio";
	}

}
