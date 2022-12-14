package com.generation.blogpessoal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity//transforma o objeto em uma entidade = tabela dentro do banco de dados
@Table(name = "tb_temas")
public class Tema {
	
	@Id//tranforma o id em chave primaria
	
	//gene - 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "O Atributo Descrição é obrigatório")
	private String descricao;

	
	//relacionamento entre tabelas - 1 tema para varias postagens 
	@OneToMany(mappedBy = "tema", cascade = CascadeType.ALL)
	
	//RECURSIVIDADE = A api não tem um limite de requisicoes= looping infinito, 
	//para evitar isso temos @ignoreproperties para travar a aplicacao e evitar o looping infinito
	@JsonIgnoreProperties("tema")
	private List<Postagem> postagem;
	
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Postagem> getPostagem() {
		return this.postagem;
	}

	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}

	
	
}