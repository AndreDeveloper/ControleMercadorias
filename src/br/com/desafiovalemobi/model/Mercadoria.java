package br.com.desafiovalemobi.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Mercadoria implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	private long codigo;
	private String tipo;
	private String nome;
	private int quantidade;
	private double preco;
	private String negocio;
	
	public Mercadoria() {
		super();
	}

	public Mercadoria(long codigo, String tipo, String nome, int quantidade, double preco, String negocio) {
		super();
		this.codigo = codigo;
		this.tipo = tipo;
		this.nome = nome;
		this.quantidade = quantidade;
		this.preco = preco;
		this.negocio = negocio;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getNegocio() {
		return negocio;
	}

	public void setNegocio(String negocio) {
		this.negocio = negocio;
	}

	@Override
	public String toString() {
		return "Mercadoria [codigo=" + codigo + ", tipo=" + tipo + ", nome=" + nome + ", quantidade=" + quantidade
				+ ", preco=" + preco + ", negocio=" + negocio + "]";
	}
	
	
}
