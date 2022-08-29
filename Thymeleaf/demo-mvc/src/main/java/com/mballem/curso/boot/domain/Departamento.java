package com.mballem.curso.boot.domain;

import java.util.List;
import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "DEPARTAMENTOS") // nome da tabela no banco de dados
public class Departamento extends AbstractEntity<Long> {
	
	@Column(name = "nome", nullable = false, unique = true, length = 60) // mapeando o atributo 'nome' para a coluna do banco de dados
	private String nome;
	
	@OneToMany(mappedBy = "departamento") // relação muitos cargos para 1 departamento, o mappedBy faz que com o relacionamento seja bidirecional, ou seja, há um lado fraco (cargo) e um forte(departamento) na relação
	private List<Cargo> cargos;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}
	
}
