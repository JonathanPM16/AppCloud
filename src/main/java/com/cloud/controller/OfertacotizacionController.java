package com.cloud.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cloud.entities.Ofertacotizacion;
import com.cloud.service.OfertacotizacionService;

@Controller
public class OfertacotizacionController {

	@Autowired
	private OfertacotizacionService ofertacotizacionService;
	
	@RequestMapping(value="/newOfertacotizacion")
	public String Ofertacotizaciones(Model model){
		model.addAttribute("ofertacotizacion", new Ofertacotizacion());
		model.addAttribute("ofertacotizaciones",ofertacotizacionService.listAllOfertacotizacion());
		return "newOfertacotizacion";
	}
	
	@RequestMapping(value="/ofertacotizacion/new", method=RequestMethod.POST) //HOME
	public String saveOfertacotizacion(@Valid Ofertacotizacion oc, BindingResult result, Model model){
		try 
		{
			if(result.hasErrors()){
				model.addAttribute("message",result.toString());
				return "newOfertacotizacion";
			}
			ofertacotizacionService.saveOfertacotizacion(oc);
			model.addAttribute("message", "Oferta de Cotizacion guardada satisfactoriamente.");
			model.addAttribute("ofertacotizaciones",ofertacotizacionService.listAllOfertacotizacion());
			return "newOfertacotizacion";
		} 
		catch (Exception e) 
		{
			model.addAttribute("message", e.getMessage());
			return "newOfertacotizacion";
		}
	}
	
	@RequestMapping(value="/ofertacotizaciones")
	public String listarOfertacotizaciones(Model model){
		model.addAttribute("ofertacotizaciones",ofertacotizacionService.listAllOfertacotizacion());
		return "ofertacotizaciones";
	}

	@RequestMapping( value="/deleteofertacotizacion{id}")
	public String deleteOfertacotizacion(@PathVariable int id, Model model)
	{
		try
		{
			ofertacotizacionService.deleteOfertacotizacion(id);
			return"redirect:/newOfertacotizacion";
		}
		catch (Exception e)
		{
			model.addAttribute("message", "ERROR: No se puede eliminar un ENTIDAD que está incluido dentro de alguna ENTIDAD.");
			model.addAttribute("ofertacotizacion", new Ofertacotizacion());
			model.addAttribute("ofertacotizaciones",ofertacotizacionService.listAllOfertacotizacion());
			return "newOfertacotizacion";
		}
	}
	
	@RequestMapping(value="/editarOfertacotizacion{idofertacotizacion}",method=RequestMethod.GET)
	public String editarOfertacotizacion(@PathVariable int idofertacotizacion,Model model)
	{
		model.addAttribute("ofertacotizacion", ofertacotizacionService.getByIdofertacotizacion(idofertacotizacion));
		return "editarOfertacotizacion";
	}

}
