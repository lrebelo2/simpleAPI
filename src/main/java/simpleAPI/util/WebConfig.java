package simpleAPI.util;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;


@RestController
@ComponentScan(basePackages="simpleAPI")
public class WebConfig implements WebMvcConfigurer {

	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        final Optional<HttpMessageConverter<?>> converterFound = converters
        		.stream().filter(c->c instanceof AbstractJackson2HttpMessageConverter).findFirst();
		if(converterFound.isPresent()) {
			AbstractJackson2HttpMessageConverter converter = (AbstractJackson2HttpMessageConverter) converterFound.get();
			converter.getObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
			converter.getObjectMapper().enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		}
        WebMvcConfigurer.super.configureMessageConverters(converters);
	}
	
	

}
