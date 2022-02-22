package com.lauliett.demoREST_persist.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*uoalaaa!!!*/
@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class PSP_Producto {
    @Id @GeneratedValue
    private Long id;
    private String nombre;
    private float precio;
    private String descripcion;
    private String codigoDeBarras;    

    @ManyToOne 
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}
