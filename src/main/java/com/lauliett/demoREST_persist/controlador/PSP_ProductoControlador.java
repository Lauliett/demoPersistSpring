package com.lauliett.demoREST_persist.controlador;

import java.util.List;

import com.lauliett.demoREST_persist.model.PSP_Producto;
import com.lauliett.demoREST_persist.repository.PSP_ProductRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PSP_ProductoControlador {
	
	@Autowired
	private  PSP_ProductRepository productoRepositorio;
	/**
	 * Obtenemos todos los productos
	 * 
	 * @return
	 */
    //Donde va estar nuestro servicio REST para obtener el producto
	@GetMapping("/producto")
	public List<PSP_Producto> obtenerTodos() {
		
		return productoRepositorio.findAll();
	}

	/**
	 * Obtenemos un producto en base a su ID
	 * 
	 * @param id
	 * @return Null si no encuentra el producto
	 */
    /*Significa que vamos a obtener un producto concreto de la base de datos!*/
	@GetMapping("/producto/{id}")
	//Por eos lo anotamos como PathVariable
    public PSP_Producto obtenerUno(@PathVariable Long id) {
		// Vamos a modificar este código
		return null;
	}

	/**
	 * Insertamos un nuevo producto
	 * 
	 * @param nuevo
	 * @return producto insertado
	 */
    /* Post producto*/
	@PostMapping("/producto")
	public PSP_Producto nuevoProducto(@RequestBody PSP_Producto nuevo) {
		// Vamos a modificar este código
		return productoRepositorio.save(nuevo);
	}

	/**
	 * 
	 * @param editar
	 * @param id
	 * @return
	 */
	@PutMapping("/producto/{id}")
	public PSP_Producto editarProducto(@RequestBody PSP_Producto editar, @PathVariable Long id) {
		// Vamos a modificar este código
		return null;
	}

	/**
	 * Borra un producto del catálogo en base a su id
	 * @param id
	 * @return
	 */
	@DeleteMapping("/producto/{id}")
	public PSP_Producto borrarProducto(@PathVariable Long id) {
		// Vamos a modificar este código
		return null;
	}	
}