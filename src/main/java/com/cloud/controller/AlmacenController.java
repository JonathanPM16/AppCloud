package com.cloud.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cloud.entities.Almacen;
import com.cloud.service.AlmacenService;
import com.cloud.service.CiudadService;

@Controller
public class AlmacenController {
	
	@Autowired
	private AlmacenService almacenService;
	
	@Autowired
	private CiudadService ciudadService;
	
	@RequestMapping(value="/newAlmacen")
	public String Almacenes(Model model){
		model.addAttribute("almacen", new Almacen());
		model.addAttribute("almacenes",almacenService.listAllAlmacen());
		model.addAttribute("ciudades",ciudadService.listAllCiudad());
		return "newAlmacen";
	}
	
	@RequestMapping(value="/almacen/new", method=RequestMethod.POST) //HOME
	public String saveAlmacen(@Valid Almacen a, BindingResult result, Model model){
		try 
		{
			if(result.hasErrors()){
				model.addAttribute("message",result.toString());
				model.addAttribute("almacenes",almacenService.listAllAlmacen());
				model.addAttribute("ciudades",ciudadService.listAllCiudad());
				return "newAlmacen";
			}
			almacenService.saveAlmacen(a);
			model.addAttribute("message", "Almacen guardado satisfactoriamente.");
			model.addAttribute("almacenes",almacenService.listAllAlmacen());
			model.addAttribute("ciudades",ciudadService.listAllCiudad());
			return "newAlmacen";
		} 
		catch (Exception e) 
		{
			model.addAttribute("message", e.getMessage());
			return "newAlmacen";
		}
	}
	
	@RequestMapping(value="/almacenes")
	public String listarAlmacenes(Model model){
		model.addAttribute("almacenes",almacenService.listAllAlmacen());
		return "almacenes";
	}

	@RequestMapping( value="/deletealmacen{id}")
	public String deleteAlmacen(@PathVariable int id, Model model)
	{
		try
		{
			almacenService.deleteAlmacen(id);
			return"redirect:/newAlmacen";
		}
		catch (Exception e)
		{
			model.addAttribute("message", "ERROR: No se puede eliminar un ENTIDAD que está incluido dentro de alguna ENTIDAD.");
			model.addAttribute("almacen", new Almacen());
			model.addAttribute("almacenes",almacenService.listAllAlmacen());
			model.addAttribute("ciudades",ciudadService.listAllCiudad());
			return "newAlmacen";
		}
	}
	
	@RequestMapping(value="/editarAlmacen{idalmacen}",method=RequestMethod.GET)
	public String editarAlmacen(@PathVariable int idalmacen,Model model)
	{
		model.addAttribute("almacen", almacenService.getByIdalmacen(idalmacen));
		model.addAttribute("ciudades",ciudadService.listAllCiudad());
		return "editarAlmacen";
	}

}
