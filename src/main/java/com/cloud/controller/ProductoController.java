package com.cloud.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cloud.entities.Producto;
import com.cloud.service.ProductoService;
import com.cloud.service.TipoproductoService;

@Controller
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private TipoproductoService tipoproductoService;
	
	@RequestMapping(value="/newProducto")
	public String Productos(Model model){
		model.addAttribute("producto", new Producto());
		model.addAttribute("productos",productoService.listAllProducto());
		model.addAttribute("tipoproductos",tipoproductoService.listAllTipoproducto());
		return "newProducto";
	}
	
	@RequestMapping(value="/producto/new", method=RequestMethod.POST) //HOME
	public String saveProducto(@Valid Producto p, BindingResult result, Model model){
		try 
		{
			if(result.hasErrors()){
				model.addAttribute("message",result.toString());
				return "redirect:/newProducto";
			}
			productoService.saveProducto(p);
			model.addAttribute("message", "Producto guardado satisfactoriamente.");
			model.addAttribute("productos",productoService.listAllProducto());
			model.addAttribute("tipoproductos",tipoproductoService.listAllTipoproducto());
			return "newProducto";
		} 
		catch (Exception e) 
		{
			model.addAttribute("message", e.getMessage());
			return "newProducto";
		}
	}
	
	@RequestMapping(value="/productos")
	public String listarProductos(Model model){
		model.addAttribute("productos",productoService.listAllProducto());
		model.addAttribute("tipoproductos",tipoproductoService.listAllTipoproducto());
		return "productos";
	}

	@RequestMapping( value="/deleteproducto{id}")
	public String deleteProducto(@PathVariable int id, Model model)
	{
		try
		{
			productoService.deleteProducto(id);
			return"redirect:/newProducto";
		}
		catch (Exception e)
		{
			model.addAttribute("message", "ERROR: No se puede eliminar un ENTIDAD que está incluido dentro de alguna ENTIDAD.");
			model.addAttribute("producto", new Producto());
			model.addAttribute("productos",productoService.listAllProducto());
			model.addAttribute("tipoproductos",tipoproductoService.listAllTipoproducto());
			return "newProducto";
		}
	}
	
	@RequestMapping(value="/editarProducto{idproducto}",method=RequestMethod.GET)
	public String editarProducto(@PathVariable int idproducto,Model model)
	{
		model.addAttribute("producto", productoService.getByIdproducto(idproducto));
		model.addAttribute("tipoproductos",tipoproductoService.listAllTipoproducto());
		return "editarProducto";
	}

}
