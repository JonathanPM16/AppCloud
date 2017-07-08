package com.cloud.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cloud.entities.Salidaproducto;
import com.cloud.service.SalidaproductoService;

@Controller
public class SalidaproductoController {

	@Autowired
	private SalidaproductoService salidaproductoService;
	
	@RequestMapping(value="/newSalidaproducto")
	public String Salidaproductos(Model model){
		model.addAttribute("salidaproducto", new Salidaproducto());
		model.addAttribute("salidaproductos",salidaproductoService.listAllSalidaproducto());
		return "newSalidaproducto";
	}
	
	@RequestMapping(value="/salidaproducto/new", method=RequestMethod.POST) //HOME
	public String saveSalidaproducto(@Valid Salidaproducto sp, BindingResult result, Model model){
		try 
		{
			if(result.hasErrors()){
				model.addAttribute("message",result.toString());
				return "newSalidaproducto";
			}
			salidaproductoService.saveSalidaproducto(sp);
			model.addAttribute("message", "Salida de Producto guardada satisfactoriamente.");
			model.addAttribute("salidaproductos",salidaproductoService.listAllSalidaproducto());
			return "newSalidaproducto";
		} 
		catch (Exception e) 
		{
			model.addAttribute("message", e.getMessage());
			return "newSalidaproducto";
		}
	}
	
	@RequestMapping(value="/salidaproductos")
	public String listarSalidaproductos(Model model){
		model.addAttribute("salidaproductos",salidaproductoService.listAllSalidaproducto());
		return "salidaproductos";
	}

	@RequestMapping( value="/deletesalidaproducto{id}")
	public String deleteSalidaproducto(@PathVariable int id, Model model)
	{
		try
		{
			salidaproductoService.deleteSalidaproducto(id);
			return"redirect:/newSalidaproducto";
		}
		catch (Exception e)
		{
			model.addAttribute("message", "ERROR: No se puede eliminar un ENTIDAD que está incluido dentro de alguna ENTIDAD.");
			model.addAttribute("salidaproducto", new Salidaproducto());
			model.addAttribute("salidaproductos",salidaproductoService.listAllSalidaproducto());
			return "newSalidaproducto";
		}
	}
	
	@RequestMapping(value="/editarSalidaproducto{idsalidaproducto}",method=RequestMethod.GET)
	public String editarSalidaproducto(@PathVariable int idsalidaproducto,Model model)
	{
		model.addAttribute("salidaproducto", salidaproductoService.getByIdsalidaproducto(idsalidaproducto));
		return "editarSalidaproducto";
	}

}
