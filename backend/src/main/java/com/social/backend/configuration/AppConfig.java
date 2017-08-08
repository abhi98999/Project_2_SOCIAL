package com.social.backend.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@ComponentScan(basePackages ="com.social.backend")

public class AppConfig extends WebMvcConfigurerAdapter{

		private static final Logger logger = LoggerFactory.getLogger(AppConfig.class);
		
		@Bean
		public ViewResolver viewResolver(){
			logger.debug("Starting of the method viewResolver");
			
			InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
			logger.debug("Ending of the method viewResolver");
			
			return viewResolver;
		}
		
		@Override
		public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
			configurer.enable();
		}
		
		public void addResourceHandlers(ResourceHandlerRegistry registry){
			registry.addResourceHandler("/resources/**")
			.addResourceLocations("/WEB-INF/resources/");
			}

	}

	
