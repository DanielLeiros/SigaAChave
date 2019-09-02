package br.com.sigaachave.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.sigaachave.enums.TipoPapel;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nome;
	private String senha;
	
	@JsonProperty("reservas")
	@OneToMany(mappedBy = "usuario", targetEntity = Reserva.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Reserva> reservas;
	
	@Enumerated(EnumType.STRING)
	private TipoPapel papel;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public TipoPapel getPapel() {
		return papel;
	}

	public void setPapel(TipoPapel papel) {
		this.papel = papel;
	}
}
