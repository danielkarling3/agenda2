package br.ufpr.modelo;

import java.time.ZonedDateTime;
import java.util.Calendar;

public class Contato {

	private Long id;
	private String nome;
	private String email;
	private String endereco;
private Calendar dataNascimento;
	
	public Contato() {
	
	}
	
	
	public Contato(String nome, String email, String endereco,
			Calendar dataNascimento) {
		super();
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
		this.dataNascimento = dataNascimento;
	}



	public String getNome() {
		return nome;
	}
	public void setID(Long id) {
		this.id = id;
	}
	public Long getID(){
		return id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
	
	
	
}
