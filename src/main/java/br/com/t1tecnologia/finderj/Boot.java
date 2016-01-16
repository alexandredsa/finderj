package br.com.t1tecnologia.finderj;

import br.com.t1tecnologia.finderj.interceptor.ApplicationInterceptor;
import br.com.t1tecnologia.finderj.interceptor.EmpresaInterceptor;
import br.com.t1tecnologia.finderj.interceptor.VagaInterceptor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class Boot extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(Boot.class, args);

	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(getApplicationInterceptor()).excludePathPatterns("/usuario/**", "/login");
		registry.addInterceptor(getEmpresaInterceptor()).addPathPatterns("/empresa/**");
		registry.addInterceptor(getVagaInterceptor()).addPathPatterns("/vagas/**");
	}

	@Bean
	public HandlerInterceptor getApplicationInterceptor() {
		return new ApplicationInterceptor();
	}

	@Bean
	public HandlerInterceptor getEmpresaInterceptor() {
		return new EmpresaInterceptor();
	}

	@Bean
	public HandlerInterceptor getVagaInterceptor() {
		return new VagaInterceptor();
	}

}