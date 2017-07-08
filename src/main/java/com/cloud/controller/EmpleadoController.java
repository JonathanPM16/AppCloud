package com.cloud.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cloud.entities.Empleado;
import com.cloud.service.EmpleadoService;

@Controller
public class EmpleadoController {

	@Autowired
	private EmpleadoService empleadoService;
	
	@RequestMapping(value="/newEmpleado")
	public String Empleados(Model model){
		model.addAttribute("empleado", new Empleado());
		model.addAttribute("empleados",empleadoService.listAllEmpleado());
		return "newEmpleado";
	}
	
	@RequestMapping(value="/empleado/new", method=RequestMethod.POST) //HOME
	public String saveEmpleado(@Valid Empleado e, BindingResult result, Model model){
		try 
		{
			if(result.hasErrors()){
				model.addAttribute("message",result.toString());
				return "newEmpleado";
			}
			empleadoService.saveEmpleado(e);
			model.addAttribute("message", "Empleado guardado satisfactoriamente.");
			model.addAttribute("empleados",empleadoService.listAllEmpleado());
			return "newEmpleado";
		} 
		catch (Exception ex) 
		{
			model.addAttribute("message", ex.getMessage());
			return "newEmpleado";
		}
	}
	
	@RequestMapping(value="/empleados")
	public String listarEmpleados(Model model){
		model.addAttribute("empleados",empleadoService.listAllEmpleado());
		return "empleados";
	}

	@RequestMapping( value="/deleteempleado{id}")
	public String deleteEmpleado(@PathVariable int id, Model model)
	{
		try
		{
			empleadoService.deleteEmpleado(id);
			return"redirect:/newEmpleado";
		}
		catch (Exception e)
		{
			model.addAttribute("message", "ERROR: No se puede eliminar un ENTIDAD que está incluido dentro de alguna ENTIDAD.");
			model.addAttribute("empleado", new Empleado());
			model.addAttribute("empleados",empleadoService.listAllEmpleado());
			return "newEmpleado";
		}
	}
	
	@RequestMapping(value="/editarEmpleado{idempleado}",method=RequestMethod.GET)
	public String editarEmpleado(@PathVariable int idempleado,Model model)
	{
		model.addAttribute("empleado", empleadoService.getByIdempleado(idempleado));
		return "editarEmpleado";
	}
}
