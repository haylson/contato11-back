package com.hm.selecao.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.hm.selecao.filter.CorsFilter;

@Configuration
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        packages("com.hm.selecao.resources"); // Substitua pelo pacote onde estão suas classes de recurso do Jersey
        register(CorsFilter.class); // Registra o filtro CORS
    }
}
