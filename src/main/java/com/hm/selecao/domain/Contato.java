package com.hm.selecao.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import com.hm.selecao.domain.dtos.ContatoDTO;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

@Entity
public class Contato implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@NotNull(message = "O nome é obrigatório.")
	@NotBlank(message = "O campo não pode ser em branco")
	@Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres.")
	private String nome;
	
	@NotNull(message = "O sobrenome é obrigatório.")
	@NotBlank(message = "O campo não pode ser em branco")
	@Size(min = 2, max = 100, message = "O sobrenome deve ter entre 2 e 100 caracteres.")
	private String sobrenome;
	
	@CPF
	@Column(unique = true)
	@Pattern(regexp = "\\d{11}", message = "O CPF deve ter 11 dígitos numéricos.")
	@NotNull(message = "O CPF é obrigatório.")
	@NotBlank(message = "O campo não pode ser em branco")
	@Size(max = 11, message = "CPF deve possuir 11 caracteres")
	private String cpf;
	
	@Column(unique = true)
	@Email(message = "O email deve ser válido.")
	@NotNull(message = "O email é obrigatório.")
	@NotBlank(message = "O campo não pode ser em branco")
	@Size(max = 100, message = "Tamanho máximo de 100 caracteres")
	private String email;
	
	@OneToMany(mappedBy = "contato", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Endereco> enderecos = new ArrayList<>();
	
	
	public Contato() {
		super();
	}
	
	public Contato(ContatoDTO contatoDTO) {
		super();
		this.codigo = contatoDTO.getCodigo();
		this.nome = contatoDTO.getNome();
		this.sobrenome = contatoDTO.getSobrenome();
		this.cpf = contatoDTO.getCpf();
		this.email = contatoDTO.getEmail();
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSobrenome() {
		return sobrenome;
	}
	
	public void setSobreNome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getEmail() {
		return email;
	}
	 
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	
	
	
	
	
}
