package com.lauliett.demoREST_persist.model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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


}
