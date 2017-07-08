package com.cloud.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cloud.entities.Sitio;
import com.cloud.service.SitioService;


@Controller
public class SitioController {

	@Autowired
	private SitioService sitioService;
	
	@RequestMapping(value="/newSitio")
	public String Sitios(Model model){
		model.addAttribute("sitio", new Sitio());
		model.addAttribute("sitios",sitioService.listAllSitio());
		return "newSitio";
	}
	
	@RequestMapping(value="/sitio/new", method=RequestMethod.POST) //HOME
	public String saveSitio(@Valid Sitio s, BindingResult result, Model model){
		try 
		{
			if(result.hasErrors()){
				model.addAttribute("message",result.toString());
				return "newSitio";
			}
			sitioService.saveSitio(s);
			model.addAttribute("message", "Sitio guardado satisfactoriamente.");
			model.addAttribute("sitios",sitioService.listAllSitio());
			return "newSitio";
		} 
		catch (Exception e) 
		{
			model.addAttribute("message", e.getMessage());
			return "newSitio";
		}
	}
	
	@RequestMapping(value="/sitios")
	public String listarSitios(Model model){
		model.addAttribute("sitios",sitioService.listAllSitio());
		return "sitios";
	}

	@RequestMapping( value="/deletesitio{id}")
	public String deleteSitio(@PathVariable int id, Model model)
	{
		try
		{
			sitioService.deleteSitio(id);
			return"redirect:/newSitio";
		}
		catch (Exception e)
		{
			model.addAttribute("message", "ERROR: No se puede eliminar un ENTIDAD que está incluido dentro de alguna ENTIDAD.");
			model.addAttribute("sitio", new Sitio());
			model.addAttribute("sitios",sitioService.listAllSitio());
			return "newSitio";
		}
	}
	
	@RequestMapping(value="/editarSitio{idsitio}",method=RequestMethod.GET)
	public String editarSitio(@PathVariable int idsitio,Model model)
	{
		model.addAttribute("sitio", sitioService.getByIdsitio(idsitio));
		return "editarSitio";
	}

}
