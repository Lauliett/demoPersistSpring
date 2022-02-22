package com.lauliett.demoREST_persist.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductoDTO {
    
    private String nombre;
    private float precio;
    private String categoriaNombre;

}
