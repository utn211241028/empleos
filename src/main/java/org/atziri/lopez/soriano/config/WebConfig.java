package org.atziri.lopez.soriano.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/logos/**").addResourceLocations("https://github.com/utn211241028/empleos/tree/593947185b97c08edb457b9dc7cf5208ca155cff/empleos/img-vacantes");
	}
}
