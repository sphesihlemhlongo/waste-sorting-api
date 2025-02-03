package com.enviro.assessment.grad001.sphesihlemhlongo.wastesortingapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;

@Configuration
public class AppConfig {

    // ModelMapper helps in converting DTOs to Entities and vice versa
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
