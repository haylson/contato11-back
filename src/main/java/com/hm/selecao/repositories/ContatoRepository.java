package com.hm.selecao.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hm.selecao.domain.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {
	
	Optional<Contato> findByCpf(String cpf);
	Optional<Contato> findByEmail(String email);

}
