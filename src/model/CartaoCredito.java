package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import visitor.Visitor;

//Concrete element em Visitor
public class CartaoCredito implements Documento {
	private String nome;
	private String numero;
	private String cvc;
	private LocalDate vencimento;

	public CartaoCredito(String nome, String numero, String cvc, LocalDate vencimento) {
		super();
		this.nome = nome;
		this.numero = numero;
		this.cvc = cvc;
		this.vencimento = vencimento;
	}

	public CartaoCredito(String nome, String numero, String cvc, String vencimento) {
		this(nome, numero, cvc, LocalDate.parse(vencimento, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	}

	public String getNome() {
		return nome;
	}

	public String getNumero() {
		return numero;
	}

	public String getCvc() {
		return cvc;
	}

	public LocalDate getVencimento() {
		return vencimento;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visiteCartao(this);
	}

}
