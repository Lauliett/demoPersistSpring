package com.lauliett.demoREST_persist.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MiConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    /*@CrossOrigin(origins= {"http://localhost:8090", "http://192.168.50.70:8080/"}, 
methods = RequestMethod.GET)*/

    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry){
                //registry.addMapping("/**");
                registry.addMapping("/productoDTO/**")
                    .allowedOrigins("http://localhost:8090")
                    .allowedHeaders("GET")
                    .maxAge(3600);
            }  
        };
    }
}
