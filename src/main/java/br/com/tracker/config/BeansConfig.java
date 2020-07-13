package br.com.tracker.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

	@Bean
	public ModelMapper modelMapper() {
		final ModelMapper modelMapper = new ModelMapper();
		
		return modelMapper;
	}
	
}
