package com.mballem.curso.boot.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "CARGOS")
public abstract class Cargo extends AbstractEntity<Long> {
	
	@Column(name = "nome", nullable = false, unique = true, length = 60)
	private String nome;
	
	@ManyToOne // relacionamento de 1 departamento para muitos cargos (le-se da direita para a esquerda) o objeto 'departamento' é um para muitos cargos que é o nome da classe.
	@JoinColumn(name = "id_departamento_fk") // o objeto 'departamento' se relacionará com o campo 'id_departamento_fk' da tabela 'Cargos'
	private Departamento departamento;
	
	@OneToMany(mappedBy = "cargo") // Muitos funcionarios(atributo) para 1 cargo(clase) // mappedBy(lado fraco do relacionamento(cargo) e o lado forte é Funcionarios(tabela que possui a chave estrangeira. 
	private List<Funcionario> funcionarios;

	
	// Métodos acessores
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
}
