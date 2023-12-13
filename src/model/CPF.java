package model;

import visitor.Visitor;

//Concrete element em Visitor
public class CPF implements Documento {

	private String nome;
	private String numero;

	public CPF(String nome, String numero) {
		super();
		this.nome = nome;
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public String getNumero() {
		return numero;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visiteCpf(this);
	}

}
