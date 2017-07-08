package com.cloud.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cloud.entities.Ciudad;
import com.cloud.service.CiudadService;

@Controller
public class CiudadController {

	@Autowired
	private CiudadService ciudadService;
	
	@RequestMapping(value="/newCiudad")
	public String Ciudades(Model model){
		model.addAttribute("ciudad", new Ciudad());
		model.addAttribute("ciudades",ciudadService.listAllCiudad());
		return "newCiudad";
	}
	
	@RequestMapping(value="/ciudad/new", method=RequestMethod.POST) //HOME
	public String saveCiudad(@Valid Ciudad c, BindingResult result, Model model){
		try 
		{
			if(result.hasErrors()){
				model.addAttribute("message",result.toString());
				return "newCiudad";
			}
			ciudadService.saveCiudad(c);
			model.addAttribute("message", "Ciudad guardada satisfactoriamente.");
			model.addAttribute("ciudades",ciudadService.listAllCiudad());
			return "newCiudad";
		} 
		catch (Exception e) 
		{
			model.addAttribute("message", e.getMessage());
			return "newCiudad";
		}
	}
	
	@RequestMapping(value="/ciudades")
	public String listarCiudades(Model model){
		model.addAttribute("ciudades",ciudadService.listAllCiudad());
		return "ciudades";
	}

	@RequestMapping( value="/deleteciudad{id}")
	public String deleteCiudad(@PathVariable int id, Model model)
	{
		try
		{
			ciudadService.deleteCiudad(id);
			return"redirect:/newCiudad";
		}
		catch (Exception e)
		{
			model.addAttribute("message", "ERROR: No se puede eliminar un ENTIDAD que está incluido dentro de alguna ENTIDAD.");
			model.addAttribute("ciudad", new Ciudad());
			model.addAttribute("ciudades",ciudadService.listAllCiudad());
			return "newCiudad";
		}
	}
	
	@RequestMapping(value="/editarCiudad{idciudad}",method=RequestMethod.GET)
	public String editarCiudad(@PathVariable int idciudad,Model model)
	{
		model.addAttribute("ciudad", ciudadService.getByIdciudad(idciudad));
		return "editarCiudad";
	}

}
