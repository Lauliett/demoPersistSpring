package com.lauliett.demoREST_persist.dto;

import com.lauliett.demoREST_persist.model.PSP_Producto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor //Esto es una pasada porque ya nos hace el autowired!!!! Pero solo sobre los finals!! :):):):):):
public class PSP_ProductoDTOConverter {        
  
    private final ModelMapper modelMapper;

    public ProductoDTO convertToDTO(PSP_Producto producto){
        
        return modelMapper.map(producto, ProductoDTO.class);
    }
}
