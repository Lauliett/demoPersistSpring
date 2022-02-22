package com.lauliett.demoREST_persist.controlador;

import java.util.List;

import com.lauliett.demoREST_persist.model.Categoria;
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
public class CategoriaControlador {

	@Autowired
	private  CategoriaRepository categoriaRepository;

	/**
	 * Obtenemos todos los productos
	 * 
	 * @return
	 */
	@GetMapping("/categoria")
	//public List<PSP_Productos> obtenerTodas() {
	public ResponseEntity<?> obtenerTodas() {
		
		List<Categoria> resultado = categoriaRepository.findAll();
		
		if (resultado.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(resultado);
		}		
	}

	/**
	 * Obtenemos un producto en base a su ID
	 * 
	 * @param id
	 * @return Null si no encuentra el producto
	 */
	@GetMapping("/categoria/{id}")
	//public PSP_Productos obtenerUna(@PathVariable Long id) {
	public ResponseEntity<?> obtenerUna(@PathVariable Long id) {
		
		Categoria resultado =  categoriaRepository.findById(id).orElse(null);
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
	@PostMapping("/categoria")
	//public PSP_Productos nuevaCategoria(@RequestBody PSP_Productos nuevo) {
	public ResponseEntity<?> nuevaCategoria(@RequestBody Categoria nuevo) {
		
		Categoria productoSalvado = categoriaRepository.save(nuevo);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(productoSalvado);
	}

	/**
	 * 
	 * @param editar
	 * @param id
	 * @return
	 */
	@PutMapping("/categoria/{id}")
	//public PSP_Productos editarCategoria(@RequestBody PSP_Productos editar, @PathVariable Long id) {
	public ResponseEntity<?> editarCategoria(@RequestBody Categoria editar, @PathVariable Long id) {
		
		/*if (categoriaRepository.existsById(id)) {
			editar.setId(id);
			return categoriaRepository.save(editar);
			
		}else return null;*/
		
		return categoriaRepository.findById(id).map(p -> {
			p.setNombre(editar.getNombre());
			p.setImportancia(editar.getImportancia());
			return ResponseEntity.ok(categoriaRepository.save(p));
		}).orElseGet(() -> {
			return ResponseEntity.notFound().build();
		});								
	}

	/**
	 * Borra un producto del catálogo en base a su id
	 * @param id
	 * @return
	 */
	@DeleteMapping("/categoria/{id}")
//	public PSP_Productos borrarCategoria(@PathVariable Long id) {

	public ResponseEntity<?> borrarCategoria(@PathVariable Long id) {

		/*if (categoriaRepository.existsById(id)) {
			
			PSP_Productos producto = categoriaRepository.findById(id).get();
			categoriaRepository.deleteById(id);
			return producto;
			
		}
		else return null;*/
		
		categoriaRepository.deleteById(id);
		return ResponseEntity.noContent().build();																
	}		
}