package com.cloud.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cloud.entities.Entradaproducto;
import com.cloud.service.EntradaproductoService;

@Controller
public class EntradaproductoController {

	@Autowired
	private EntradaproductoService entradaproductoService;
	
	@RequestMapping(value="/newEntradaproducto")
	public String Entradaproductos(Model model){
		model.addAttribute("entradaproducto", new Entradaproducto());
		model.addAttribute("entradaproductos",entradaproductoService.listAllEntradaproducto());
		return "newEntradaproducto";
	}
	
	@RequestMapping(value="/entradaproducto/new", method=RequestMethod.POST) //HOME
	public String saveEntradaproducto(@Valid Entradaproducto ep, BindingResult result, Model model){
		try 
		{
			if(result.hasErrors()){
				model.addAttribute("message",result.toString());
				return "newEntradaproducto";
			}
			entradaproductoService.saveEntradaproducto(ep);
			model.addAttribute("message", "Entrada de Producto guardada satisfactoriamente.");
			model.addAttribute("entradaproductos",entradaproductoService.listAllEntradaproducto());
			return "newEntradaproducto";
		} 
		catch (Exception e) 
		{
			model.addAttribute("message", e.getMessage());
			return "newEntradaproducto";
		}
	}
	
	@RequestMapping(value="/entradaproductos")
	public String listarEntradaproductos(Model model){
		model.addAttribute("entradaproductos",entradaproductoService.listAllEntradaproducto());
		return "entradaproductos";
	}

	@RequestMapping( value="/deleteentradaproducto{id}")
	public String deleteEntradaproducto(@PathVariable int id, Model model)
	{
		try
		{
			entradaproductoService.deleteEntradaproducto(id);
			return"redirect:/newEntradaproducto";
		}
		catch (Exception e)
		{
			model.addAttribute("message", "ERROR: No se puede eliminar un ENTIDAD que está incluido dentro de alguna ENTIDAD.");
			model.addAttribute("entradaproducto", new Entradaproducto());
			model.addAttribute("entradaproductos",entradaproductoService.listAllEntradaproducto());
			return "newEntradaproducto";
		}
	}
	
	@RequestMapping(value="/editarEntradaproducto{identradaproducto}",method=RequestMethod.GET)
	public String editarEntradaproducto(@PathVariable int identradaproducto,Model model)
	{
		model.addAttribute("entradaproducto", entradaproductoService.getByIdentradaproducto(identradaproducto));
		return "editarEntradaproducto";
	}

}
