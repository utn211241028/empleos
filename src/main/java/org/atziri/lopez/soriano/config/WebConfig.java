package org.atziri.lopez.soriano.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/logos/**").addResourceLocations("https://github.com/utn211241028/empleos/tree/31f77d426b6d41ffbabacd31679f4c8bf802c679/empleos/img-vacantes");
	}
}
