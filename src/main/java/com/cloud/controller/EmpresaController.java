package com.cloud.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cloud.entities.Empresa;
import com.cloud.service.EmpresaService;

@Controller
public class EmpresaController {

	@Autowired
	private EmpresaService empresaService;
	
	@RequestMapping(value="/newEmpresa")
	public String Empresas(Model model){
		model.addAttribute("empresa", new Empresa());
		model.addAttribute("empresas",empresaService.listAllEmpresa());
		return "newEmpresa";
	}
	
	@RequestMapping(value="/empresa/new", method=RequestMethod.POST) //HOME
	public String saveEmpresa(@Valid Empresa e, BindingResult result, Model model){
		try 
		{
			if(result.hasErrors()){
				model.addAttribute("message",result.toString());
				return "newEmpresa";
			}
			empresaService.saveEmpresa(e);
			model.addAttribute("message", "Empresa guardada satisfactoriamente.");
			model.addAttribute("empresas",empresaService.listAllEmpresa());
			return "newEmpresa";
		} 
		catch (Exception ex) 
		{
			model.addAttribute("message", ex.getMessage());
			return "newEmpresa";
		}
	}
	
	@RequestMapping(value="/empresas")
	public String listarEmpresas(Model model){
		model.addAttribute("empresas",empresaService.listAllEmpresa());
		return "empresas";
	}

	@RequestMapping( value="/deleteempresa{id}")
	public String deleteEmpresa(@PathVariable int id, Model model)
	{
		try
		{
			empresaService.deleteEmpresa(id);
			return"redirect:/newEmpresa";
		}
		catch (Exception e)
		{
			model.addAttribute("message", "ERROR: No se puede eliminar un ENTIDAD que está incluido dentro de alguna ENTIDAD.");
			model.addAttribute("empresa", new Empresa());
			model.addAttribute("empresas",empresaService.listAllEmpresa());
			return "newEmpresa";
		}
	}
	
	@RequestMapping(value="/editarEmpresa{idempresa}",method=RequestMethod.GET)
	public String editarEmpresa(@PathVariable int idempresa,Model model)
	{
		model.addAttribute("empresa", empresaService.getByIdempresa(idempresa));
		return "editarEmpresa";
	}

}
