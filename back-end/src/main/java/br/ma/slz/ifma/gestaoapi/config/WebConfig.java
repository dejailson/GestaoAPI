package br.ma.slz.ifma.gestaoapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//Definindo o acesso global aos recurso do back-end
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")//define as permissões cada recurso disponível no back-end. {/** => todos os recursos}
            .allowedMethods("*")//define quais métodos (verbos HTTP) estão acessíveis {* => todos os verbos HTTP}.
            .allowedOrigins("http://localhost:4200","www.g1.com");// define quais origens terão acesso aos recursos {* => acesso para qualquer cliente}.
    }
    
}
