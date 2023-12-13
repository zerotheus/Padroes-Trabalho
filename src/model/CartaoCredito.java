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

	public String formatar() {
		StringBuilder fmt = new StringBuilder();
		fmt.append("CART�O DE CR�DITO\n");
		fmt.append(this.nome + "\n");
		fmt.append(this.numero.substring(0, 4) + " ");
		fmt.append(this.numero.substring(4, 8) + " ");
		fmt.append(this.numero.substring(8, 12) + " ");
		fmt.append(this.numero.substring(12, 16) + "\n");
		fmt.append(this.cvc + "\n");
		fmt.append(this.vencimento.format(DateTimeFormatter.ofPattern("MM/yy")));
		return fmt.toString();

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
