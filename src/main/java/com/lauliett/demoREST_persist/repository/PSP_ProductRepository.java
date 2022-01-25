package com.lauliett.demoREST_persist.repository;
//Esto es un dao!

import com.lauliett.demoREST_persist.model.PSP_Producto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//El repository necesita estar parametrizado!
@Repository
public interface PSP_ProductRepository extends JpaRepository<PSP_Producto, Long>{
    
}
