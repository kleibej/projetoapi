package com.usuario.usuario.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="nomeCompleto")
	private String nomeCompleto;
	@Column(name = "nomeSocial")
	private String nomeSocial;
	@Column(name = "dataDeNascimento")
	private String dataDeNascimento;
	@Column(name = "codigo")
	private Integer codigo;
	@Column(name = "sexo")
	private char sexo;
	@Column(name = "email")
	private String email;
	@Column(name = "estado")
	private String estado;
	@Column(name = "municipio")
	private String municipio;
	@Column(name = "numeroDeAcessos")
	private Integer numeroDeAcessos;
	@Column(name = "situacaoNoCurso")
	private String situacaoNoCurso;
	@Column(name = "dataDeVinculo")
	private String dataDeVinculo;
		
	public Usuario() {
	}
	
	
	public Usuario(String nomeCompleto, String nomeSocial, String dataDeNascimento, Integer codigo, char sexo,
			String email, String estado, String municipio, Integer numeroDeAcessos, String situacaoNoCurso,
			String dataDeVinculo) {
		this.nomeCompleto = nomeCompleto;
		this.nomeSocial = nomeSocial;
		this.dataDeNascimento = dataDeNascimento;
		this.codigo = codigo;
		this.sexo = sexo;
		this.email = email;
		this.estado = estado;
		this.municipio = municipio;
		this.numeroDeAcessos = numeroDeAcessos;
		this.situacaoNoCurso = situacaoNoCurso;
		this.dataDeVinculo = dataDeVinculo;
	}

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getNomeSocial() {
		return nomeSocial;
	}

	public void setNomeSocial(String nomeSocial) {
		this.nomeSocial = nomeSocial;
	}

	public String getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(String dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public Integer getNumeroDeAcessos() {
		return numeroDeAcessos;
	}

	public void setNumeroDeAcessos(Integer numeroDeAcessos) {
		this.numeroDeAcessos = numeroDeAcessos;
	}

	public String getSituacaoNoCurso() {
		return situacaoNoCurso;
	}

	public void setSituacaoNoCurso(String situacaoNoCurso) {
		this.situacaoNoCurso = situacaoNoCurso;
	}

	public String getDataDeVinculo() {
		return dataDeVinculo;
	}

	public void setDataDeVinculo(String dataDeVinculo) {
		this.dataDeVinculo = dataDeVinculo;
	}
	
	
	
}
