package com.hm.selecao.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.selecao.domain.Contato;
import com.hm.selecao.domain.dtos.ContatoDTO;
import com.hm.selecao.repositories.ContatoRepository;
import com.hm.selecao.services.exceptions.DataIntegrityViolationException;
import com.hm.selecao.services.exceptions.ObjectNotFoundException;

import javax.validation.Valid;

@Service
public class ContatoService {
	
	@Autowired
	private ContatoRepository repository;
	
	public List<Contato> findAll() {
		return repository.findAll();
	}
	
	public Contato findById(Long id) {
		Optional<Contato> contato = repository.findById(id);
		return contato.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
	}
	
	public Contato create(ContatoDTO contatoDTO) {
		contatoDTO.setCodigo(null);
		validaPorCpfEEmail(contatoDTO);
		Contato newContato = new Contato(contatoDTO);
		return repository.save(newContato);
	}
	
	public Contato update(Long id, @Valid ContatoDTO contatoDTO) {
		contatoDTO.setCodigo(id);
		Contato contato = findById(id);
		validaPorCpfEEmail(contatoDTO);
		contato = new Contato(contatoDTO);
		return repository.save(contato);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	private void validaPorCpfEEmail(ContatoDTO contatoDTO) {
		
		Optional<Contato> obj = repository.findByCpf(contatoDTO.getCpf());
		
		if(obj.isPresent() && obj.get().getCodigo() != contatoDTO.getCodigo()) {
			throw new DataIntegrityViolationException("CPF já cadastrado no sistema!");
		}
		
		obj = repository.findByEmail(contatoDTO.getEmail());
		
		if(obj.isPresent() && obj.get().getCodigo() != contatoDTO.getCodigo()) {
			throw new DataIntegrityViolationException("Email já cadastrado no sistema!");
		}
		
	}


	

}
