package com.cloud.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cloud.entities.Proveedor;
import com.cloud.service.ProveedorService;

@Controller
public class ProveedorController {

	@Autowired
	private ProveedorService proveedorService;
	
	@RequestMapping(value="/newProveedor")
	public String Proveedores(Model model){
		model.addAttribute("proveedor", new Proveedor());
		model.addAttribute("proveedores",proveedorService.listAllProveedor());
		return "newProveedor";
	}
	
	@RequestMapping(value="/proveedor/new", method=RequestMethod.POST) //HOME
	public String saveProveedor(@Valid Proveedor p, BindingResult result, Model model){
		try 
		{
			if(result.hasErrors()){
				model.addAttribute("message",result.toString());
				return "newProveedor";
			}
			proveedorService.saveProveedor(p);
			model.addAttribute("message", "Proveedor guardado satisfactoriamente.");
			model.addAttribute("proveedores",proveedorService.listAllProveedor());
			return "newProveedor";
		} 
		catch (Exception e) 
		{
			model.addAttribute("message", e.getMessage());
			return "newProveedor";
		}
	}
	
	@RequestMapping(value="/proveedores")
	public String listarProveedores(Model model){
		model.addAttribute("proveedores",proveedorService.listAllProveedor());
		return "proveedores";
	}

	@RequestMapping( value="/deleteproveedor{id}")
	public String deleteProveedor(@PathVariable int id, Model model)
	{
		try
		{
			proveedorService.deleteProveedor(id);
			return"redirect:/newProveedor";
		}
		catch (Exception e)
		{
			model.addAttribute("message", "ERROR: No se puede eliminar un ENTIDAD que está incluido dentro de alguna ENTIDAD.");
			model.addAttribute("proveedor", new Proveedor());
			model.addAttribute("proveedores",proveedorService.listAllProveedor());
			return "newProveedor";
		}
	}
	
	@RequestMapping(value="/editarProveedor{idproveedor}",method=RequestMethod.GET)
	public String editarProveedor(@PathVariable int idproveedor,Model model)
	{
		model.addAttribute("proveedor", proveedorService.getByIdproveedor(idproveedor));
		return "editarProveedor";
	}
}
