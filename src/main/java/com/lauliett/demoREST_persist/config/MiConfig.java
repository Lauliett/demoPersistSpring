package com.lauliett.demoREST_persist.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MiConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
