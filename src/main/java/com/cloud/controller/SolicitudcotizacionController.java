package com.cloud.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cloud.entities.Solicitudcotizacion;
import com.cloud.service.SolicitudcotizacionService;

@Controller
public class SolicitudcotizacionController {

	@Autowired
	private SolicitudcotizacionService solicitudcotizacionService;
	
	@RequestMapping(value="/newSolicitudcotizacion")
	public String Solicitudcotizaciones(Model model){
		model.addAttribute("solicitudcotizacion", new Solicitudcotizacion());
		model.addAttribute("solicitudcotizaciones",solicitudcotizacionService.listAllSolicitudcotizacion());
		return "newSolicitudcotizacion";
	}
	
	@RequestMapping(value="/solicitudcotizacion/new", method=RequestMethod.POST) //HOME
	public String saveSolicitudcotizacion(@Valid Solicitudcotizacion sc, BindingResult result, Model model){
		try 
		{
			if(result.hasErrors()){
				model.addAttribute("message",result.toString());
				return "newSolicitudcotizacion";
			}
			solicitudcotizacionService.saveSolicitudcotizacion(sc);
			model.addAttribute("message", "Solicitud de Cotizacion guardada satisfactoriamente.");
			model.addAttribute("solicitudcotizaciones",solicitudcotizacionService.listAllSolicitudcotizacion());
			return "newSolicitudcotizacion";
		} 
		catch (Exception e) 
		{
			model.addAttribute("message", e.getMessage());
			return "newSolicitudcotizacion";
		}
	}
	
	@RequestMapping(value="/solicitudcotizaciones")
	public String listarSolicitudcotizaciones(Model model){
		model.addAttribute("solicitudcotizaciones",solicitudcotizacionService.listAllSolicitudcotizacion());
		return "solicitudcotizaciones";
	}

	@RequestMapping( value="/deletesolicitudcotizacion{id}")
	public String deleteSolicitudcotizacion(@PathVariable int id, Model model)
	{
		try
		{
			solicitudcotizacionService.deleteSolicitudcotizacion(id);
			return"redirect:/newSolicitudcotizacion";
		}
		catch (Exception e)
		{
			model.addAttribute("message", "ERROR: No se puede eliminar un ENTIDAD que está incluido dentro de alguna ENTIDAD.");
			model.addAttribute("solicitudcotizacion", new Solicitudcotizacion());
			model.addAttribute("solicitudcotizaciones",solicitudcotizacionService.listAllSolicitudcotizacion());
			return "newSolicitudcotizacion";
		}
	}
	
	@RequestMapping(value="/editarSolicitudcotizacion{idsolicitudcotizacion}",method=RequestMethod.GET)
	public String editarSolicitudcotizacion(@PathVariable int idsolicitudcotizacion,Model model)
	{
		model.addAttribute("solicitudcotizacion", solicitudcotizacionService.getByIdsolicitudcotizacion(idsolicitudcotizacion));
		return "editarSolicitudcotizacion";
	}

}
