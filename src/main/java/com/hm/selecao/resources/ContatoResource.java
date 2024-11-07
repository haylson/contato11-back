package com.hm.selecao.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.hm.selecao.domain.Contato;
import com.hm.selecao.domain.dtos.ContatoDTO;
import com.hm.selecao.services.ContatoService;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/contatos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ContatoResource {
	
	@Autowired
	private ContatoService service;
	
	
	@GET
	public Response findAll() {
		List<Contato> list = service.findAll();
		List<ContatoDTO> listDTO = list.stream().map(obj -> new ContatoDTO(obj)).collect(Collectors.toList());
		return Response.ok(listDTO).build();
	}
	
	@GET
	@Path("/{id}")
	public Response findById(@PathParam("id") Long id) {
		Contato contato = service.findById(id);
		ContatoDTO contatoDTO = new ContatoDTO(contato);
		return Response.ok(contatoDTO).build();
	}
	
	@POST
    public Response create(@Valid ContatoDTO contatoDTO) {
        Contato novoContato = service.create(contatoDTO);
        return Response.status(Response.Status.CREATED).entity(novoContato).build();
    }
	
	@PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, @Valid ContatoDTO contatoDTO) {
        Contato contatoAtualizado = service.update(id, contatoDTO);
        if (contatoAtualizado != null) {
            return Response.ok(contatoAtualizado).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
	
	@DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.noContent().build();
    }
	
}
