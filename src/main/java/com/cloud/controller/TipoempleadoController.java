package com.cloud.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cloud.entities.Tipoempleado;
import com.cloud.service.TipoempleadoService;

@Controller
public class TipoempleadoController {

	@Autowired
	private TipoempleadoService tipoempleadoService;
	
	@RequestMapping(value="/newTipoempleado")
	public String Tipoempleados(Model model){
		model.addAttribute("tipoempleado", new Tipoempleado());
		model.addAttribute("tipoempleados",tipoempleadoService.listAllTipoempleado());
		return "newTipoempleado";
	}
	
	@RequestMapping(value="/tipoempleado/new", method=RequestMethod.POST) //HOME
	public String saveTipoempleado(@Valid Tipoempleado te, BindingResult result, Model model){
		try 
		{
			if(result.hasErrors()){
				model.addAttribute("message",result.toString());
				return "newTipoempleado";
			}
			tipoempleadoService.saveTipoempleado(te);
			model.addAttribute("message", "Tipo de Empleado guardado satisfactoriamente.");
			model.addAttribute("tipoempleados",tipoempleadoService.listAllTipoempleado());
			return "newTipoempleado";
		} 
		catch (Exception e) 
		{
			model.addAttribute("message", e.getMessage());
			return "newTipoempleado";
		}
	}
	
	@RequestMapping(value="/tipoempleados")
	public String listarTipoempleados(Model model){
		model.addAttribute("tipoempleados",tipoempleadoService.listAllTipoempleado());
		return "tipoempleados";
	}

	@RequestMapping( value="/deletetipoempleado{id}")
	public String deleteTipoempleado(@PathVariable int id, Model model)
	{
		try
		{
			tipoempleadoService.deleteTipoempleado(id);
			return"redirect:/newTipoempleado";
		}
		catch (Exception e)
		{
			model.addAttribute("message", "ERROR: No se puede eliminar un ENTIDAD que está incluido dentro de alguna ENTIDAD.");
			model.addAttribute("tipoempleado", new Tipoempleado());
			model.addAttribute("tipoempleados",tipoempleadoService.listAllTipoempleado());
			return "newTipoempleado";
		}
	}
	
	@RequestMapping(value="/editarTipoempleado{idtipoempleado}",method=RequestMethod.GET)
	public String editarTipoempleado(@PathVariable int idtipoempleado,Model model)
	{
		model.addAttribute("tipoempleado", tipoempleadoService.getByIdtipoempleado(idtipoempleado));
		return "editarTipoempleado";
	}
}
