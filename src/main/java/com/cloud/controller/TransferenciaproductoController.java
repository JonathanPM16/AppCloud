package com.cloud.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cloud.entities.Transferenciaproducto;
import com.cloud.service.TransferenciaproductoService;

@Controller
public class TransferenciaproductoController {

	@Autowired
	private TransferenciaproductoService transferenciaproductoService;
	
	@RequestMapping(value="/newTransferenciaproducto")
	public String Transferenciaproductos(Model model){
		model.addAttribute("transferenciaproducto", new Transferenciaproducto());
		model.addAttribute("transferenciaproductos",transferenciaproductoService.listAllTransferenciaproducto());
		return "newTransferenciaproducto";
	}
	
	@RequestMapping(value="/transferenciaproducto/new", method=RequestMethod.POST) //HOME
	public String saveTransferenciaproducto(@Valid Transferenciaproducto tp, BindingResult result, Model model){
		try 
		{
			if(result.hasErrors()){
				model.addAttribute("message",result.toString());
				return "newTransferenciaproducto";
			}
			transferenciaproductoService.saveTransferenciaproducto(tp);
			model.addAttribute("message", "Transferencia de Producto guardada satisfactoriamente.");
			model.addAttribute("transferenciaproductos",transferenciaproductoService.listAllTransferenciaproducto());
			return "newTransferenciaproducto";
		} 
		catch (Exception e) 
		{
			model.addAttribute("message", e.getMessage());
			return "newTransferenciaproducto";
		}
	}
	
	@RequestMapping(value="/transferenciaproductos")
	public String listarTransferenciaproductos(Model model){
		model.addAttribute("transferenciaproductos",transferenciaproductoService.listAllTransferenciaproducto());
		return "transferenciaproductos";
	}

	@RequestMapping( value="/deletetransferenciaproducto{id}")
	public String deleteTransferenciaproducto(@PathVariable int id, Model model)
	{
		try
		{
			transferenciaproductoService.deleteTransferenciaproducto(id);
			return"redirect:/newTransferenciaproducto";
		}
		catch (Exception e)
		{
			model.addAttribute("message", "ERROR: No se puede eliminar un ENTIDAD que está incluido dentro de alguna ENTIDAD.");
			model.addAttribute("transferenciaproducto", new Transferenciaproducto());
			model.addAttribute("transferenciaproductos",transferenciaproductoService.listAllTransferenciaproducto());
			return "newTransferenciaproducto";
		}
	}
	
	@RequestMapping(value="/editarTransferenciaproducto{idtransferenciaproducto}",method=RequestMethod.GET)
	public String editarTransferenciaproducto(@PathVariable int idtransferenciaproducto,Model model)
	{
		model.addAttribute("transferenciaproducto", transferenciaproductoService.getByIdtransferenciaproducto(idtransferenciaproducto));
		return "editarTransferenciaproducto";
	}

}