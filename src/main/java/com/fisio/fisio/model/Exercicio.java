package com.fisio.fisio.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Exercicio {

	@Id
	Integer id;
	
	String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	
}
