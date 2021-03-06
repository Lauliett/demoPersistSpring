package com.lauliett.demoREST_persist.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Categoria {

    @Id @GeneratedValue
    private Long id;
    private String nombre;
    private String importancia;
}
