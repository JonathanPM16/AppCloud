package com.cloud.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cloud.entities.Tipoproducto;
import com.cloud.service.TipoproductoService;

@Controller
public class TipoproductoController {
	
	@Autowired
	private TipoproductoService tipoproductoService;
	
	@RequestMapping(value="/newTipoproducto")
	public String Tipoproductos(Model model){
		model.addAttribute("tipoproducto", new Tipoproducto());
		model.addAttribute("tipoproductos",tipoproductoService.listAllTipoproducto());
		return "newTipoproducto";
	}
	
	@RequestMapping(value="/tipoproducto/new", method=RequestMethod.POST) //HOME
	public String saveTipoproducto(@Valid Tipoproducto tp, BindingResult result, Model model){
		try 
		{
			if(result.hasErrors()){
				model.addAttribute("message",result.toString());
				return "newTipoproducto";
			}
			tipoproductoService.saveTipoproducto(tp);
			model.addAttribute("message", "Tipo de Producto guardado satisfactoriamente.");
			model.addAttribute("tipoproductos",tipoproductoService.listAllTipoproducto());
			return "newTipoproducto";
		} 
		catch (Exception e) 
		{
			model.addAttribute("message", e.getMessage());
			return "newTipoproducto";
		}
	}
	
	@RequestMapping(value="/tipoproductos")
	public String listarTipoproductos(Model model){
		model.addAttribute("tipoproductos",tipoproductoService.listAllTipoproducto());
		return "tipoproductos";
	}

	@RequestMapping( value="/deletetipoproducto{id}")
	public String deleteTipoproducto(@PathVariable int id, Model model)
	{
		try
		{
			tipoproductoService.deleteTipoproducto(id);
			return"redirect:/newTipoproducto";
		}
		catch (Exception e)
		{
			model.addAttribute("message", "ERROR: No se puede eliminar un ENTIDAD que está incluido dentro de alguna ENTIDAD.");
			model.addAttribute("tipoproducto", new Tipoproducto());
			model.addAttribute("tipoproductos",tipoproductoService.listAllTipoproducto());
			return "newTipoproducto";
		}
	}
	@RequestMapping(value="/editarTipoproducto{idtipoproducto}",method=RequestMethod.GET)
	public String editarTipoproducto(@PathVariable int idtipoproducto,Model model)
	{
		model.addAttribute("tipoproducto", tipoproductoService.getByIdtipoproducto(idtipoproducto));
		return "editarTipoproducto";
	}

}
