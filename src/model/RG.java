package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import visitor.Visitor;

//Concrete element em Visitor
public class RG implements Documento {

	private String nome;
	private String numero;
	private String expedidor;
	private LocalDate validade;

	public RG(String nome, String numero, String expedidor, LocalDate validade) {
		super();
		this.nome = nome;
		this.numero = numero;
		this.expedidor = expedidor;
		this.validade = validade;
	}

	public RG(String nome, String numero, String expedidor, String validade) {
		this(nome, numero, expedidor, LocalDate.parse(validade, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	}

	public String getNome() {
		return nome;
	}

	public String getNumero() {
		return numero;
	}

	public String getExpedidor() {
		return expedidor;
	}

	public LocalDate getValidade() {
		return validade;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visiteRG(this);
	}

}
