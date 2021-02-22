package com.vasitum.assessmentengine;

import com.vasitum.assessmentengine.config.interceptor.ClientAuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class AssessmentengineApplication {

	@Autowired
	private ClientAuthInterceptor clientAuthInterceptor;
	public static void main(String[] args) {
		SpringApplication.run(AssessmentengineApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			//when we push the live comment the single star *
			@Override
			public void addInterceptors(InterceptorRegistry interceptorRegistry) {
				interceptorRegistry.addInterceptor(clientAuthInterceptor).addPathPatterns("/token/**");

				//interceptorRegistry.addInterceptor(apiAuthInterceptor).addPathPatterns("/v2/external_job/**");
			}

			/*@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("*", "http://vasitum.com", "http://www.vasitum.com", "https://vasitum.com",
								"https://www.vasitum.com")
						.exposedHeaders(BaseConstants.HEADER_AUTH_TOKEN).allowedMethods("*").allowedHeaders("*")
						.allowCredentials(true).maxAge(3600);
			}*/
		};
	}
}
