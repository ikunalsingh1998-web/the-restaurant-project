package com.kunal.restaurant.Configuration;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Collections;
import java.util.List;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        // Create a new instance of MappingJackson2HttpMessageConverter
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        // Add supported media type - application/json
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
        // Add the converter to the list of converters
        converters.add(converter);
    }
}