package com.lauliett.demoREST_persist.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.lauliett.demoREST_persist.dto.PSP_ProductoDTOConverter;
import com.lauliett.demoREST_persist.dto.ProductoDTO;
import com.lauliett.demoREST_persist.model.PSP_Producto;
import com.lauliett.demoREST_persist.repository.CategoriaRepository;
import com.lauliett.demoREST_persist.repository.PSP_ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PSP_ProductoControladorDTO {

	@Autowired
	private  PSP_ProductRepository productoRepositorio;
	@Autowired
	private CategoriaRepository categoriaRepositorio;	
	@Autowired
	private PSP_ProductoDTOConverter productoDTOConverter;

	/**
	 * Obtenemos todos los productos
	 * 
	 * @return
	 */
	@GetMapping("/productoDTO")
	//public List<PSP_Productos> obtenerTodos() {
	public ResponseEntity<?> obtenerTodos() {
		
		List<PSP_Producto> resultado = productoRepositorio.findAll();
		if (resultado.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			List<ProductoDTO> dtoList =
				/*resultado.stream()
						 .map(productoDTOConverter::convertToDTO)
						 .collect(Collectors.toList());*/
				resultado.stream()
						 .map(p -> productoDTOConverter.convertToDTO(p))
						 .collect(Collectors.toList());						 
			
			return ResponseEntity.ok(dtoList);
		}		
	}

	/**
	 * Obtenemos un producto en base a su ID
	 * 
	 * @param id
	 * @return Null si no encuentra el producto
	 */
	@GetMapping("/productoDTO/{id}")
	//public PSP_Productos obtenerUno(@PathVariable Long id) {
	public ResponseEntity<?> obtenerUno(@PathVariable Long id) {
		
		PSP_Producto resultado =  productoRepositorio.findById(id).orElse(null);
		if (resultado == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(resultado);
		}						
	}

	/**
	 * Insertamos un nuevo producto
	 * 
	 * @param nuevo
	 * @return producto insertado
	 */
	@PostMapping("/productoDTO")
	//public PSP_Productos nuevoProducto(@RequestBody PSP_Productos nuevo) {
	public ResponseEntity<?> nuevoProducto(@RequestBody PSP_Producto nuevo) {
		
		PSP_Producto productoSalvado = productoRepositorio.save(nuevo);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(productoSalvado);
	}

	/**
	 * 
	 * @param editar
	 * @param id
	 * @return
	 */
	@PutMapping("/productoDTO/{id}")
	//public PSP_Productos editarProducto(@RequestBody PSP_Productos editar, @PathVariable Long id) {
	public ResponseEntity<?> editarProducto(@RequestBody PSP_Producto editar, @PathVariable Long id) {
		
		/*if (productoRepositorio.existsById(id)) {
			editar.setId(id);
			return productoRepositorio.save(editar);
			
		}else return null;*/
		
		return productoRepositorio.findById(id).map(p -> {
			p.setNombre(editar.getNombre());
			p.setPrecio(editar.getPrecio());
			return ResponseEntity.ok(productoRepositorio.save(p));
		}).orElseGet(() -> {
			return ResponseEntity.notFound().build();
		});								
	}

	/**
	 * Borra un producto del catálogo en base a su id
	 * @param id
	 * @return
	 */
	@DeleteMapping("/productoDTO/{id}")
//	public PSP_Productos borrarProducto(@PathVariable Long id) {
		public ResponseEntity<?> borrarProducto(@PathVariable Long id) {
		
		/*if (productoRepositorio.existsById(id)) {
			
			PSP_Productos producto = productoRepositorio.findById(id).get();
			productoRepositorio.deleteById(id);
			return producto;
			
		}
		else return null;*/
		
		productoRepositorio.deleteById(id);
		return ResponseEntity.noContent().build();																
	}		
}