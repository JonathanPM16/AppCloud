package com.cloud.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cloud.entities.Empleado;
import com.cloud.service.EmpleadoService;

@Controller
public class InicioController {
	
	@Autowired
	private EmpleadoService empleadoService;
	
	@RequestMapping(value = "/")
	public String inicio() {
		return "inicio";
	}
	
	@RequestMapping(value = "/empleado")
	public String inicioEmpleado() {
		return "loginEmpleado";
	}
	
	@RequestMapping(value = "/empleado/admin/inicio")
	public String inicioEmpleadoAdmin() {
		return "inicioEmpleadoAdmin";
	}
	
	@RequestMapping(value = "/empleado/logistica/inicio")
	public String inicioEmpleadoLogistica() {
		return "inicioEmpleadoLogistica";
	}
	
	@RequestMapping(value="/empleado/login", method=RequestMethod.POST)
	public String inicioEmpleadoLogin(@RequestParam String usuario, @RequestParam String password, Model model,
			                    HttpSession session)
	{
	   Empleado empleado = empleadoService.autenticarEmpleado(usuario, password);
	   if (usuario=="" || password=="") {
		   model.addAttribute("message", "ingresar los datos completos");
		   return "loginEmpleado";
	   }
	   else if (empleado==null) {
		   model.addAttribute("message", "los datos ingresados no son correctos");
		   return "loginEmpleado";
	   }
	   session.setAttribute("usuariologeado", empleado);
	   int idte = empleado.getIdempleado();
	   if(idte==1)
	   {
		   return "redirect:/empleado/admin/inicio";
	   }
	   if(idte==2)
	   {
		   return "redirect:/empleado/logistica/inicio";
	   }
	   return "redirect:/empleado/admin/inicio";
	   
	}
	
	@RequestMapping(value = "/proveedor")
	public String loginProveedor() {
		return "loginProveedor";
	}
}
