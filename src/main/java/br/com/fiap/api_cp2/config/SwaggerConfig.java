package br.com.fiap.api_cp2.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.*;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Gestão de Entregadores - Mottu")
                        .description("Esta API simula a operação da Mottu para controle de entregadores e motos alugadas. Projeto realizado pensando no Challengeadd ..")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Eduardo Miguel Forato Monteiro e Cicero Gabriel Oliveira Serafim")
                        )
                        .license(new License()
                                .name("MIT License")
                                .url("https://opensource.org/licenses/MIT"))
                );
    }
}