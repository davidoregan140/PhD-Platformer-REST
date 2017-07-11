package io.larkin.phdplatformer;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PhDPlatformerApplication {

//	@Bean
//	public RestTemplate restTemplate() {
//
//	    final RestTemplate restTemplate = new RestTemplate();
//
//	    restTemplate.setMessageConverters(Arrays.asList(
//	            new FormHttpMessageConverter(),
//	            new StringHttpMessageConverter(),
//	            new MappingJackson2HttpMessageConverter()
//	    ));
//	    restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor("client", "secret"));
//
//	    return restTemplate;
//	}
	
	public static void main(String[] args) {
		SpringApplication.run(PhDPlatformerApplication.class, args);
	}
}
