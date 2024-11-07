package com.hm.contato.filter;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class CorsFilter implements ContainerResponseFilter {

	@Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        responseContext.getHeaders().add("Access-Control-Allow-Origin", "http://localhost:4200"); // URL do frontend Angular
        responseContext.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS"); // Métodos permitidos
        responseContext.getHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization"); // Cabeçalhos permitidos
        responseContext.getHeaders().add("Access-Control-Allow-Credentials", "true"); // Permite cookies/autenticação
    }
	
}
